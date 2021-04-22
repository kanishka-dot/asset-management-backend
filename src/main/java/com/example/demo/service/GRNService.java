package com.example.demo.service;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GRN;
import com.example.demo.repositary.GRNRepositary;

@Service
public class GRNService {

	@Autowired
	private GRNRepositary grnRepositary;

	@Autowired
	private DocMasterService docMasterService;

	@PersistenceContext
	EntityManager em;

	public int saveGRN(List<GRN> grnList) {
		em.getTransaction().begin();

		try {

			int docno = docMasterService.getSeqNum("GRN");

			for (int i = 0; i < grnList.size(); i++) {

				GRN updateGRN = grnList.get(i);

				if (!IsSerialUnique(updateGRN.getSerialno())) {
					return 3;
				}

				updateGRN.setDocno(docno);
				updateGRN.setSeqno(i);
				grnRepositary.save(updateGRN);
			}
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return 0;
		}
	}

	private boolean IsSerialUnique(String para_serialno) {

		Query qry = em.createNativeQuery("select a.serialno from inv_doc_grn a where a.serialno = ?");
		qry.setParameter(1, para_serialno);
		Object[] rslt = (Object[]) qry.getSingleResult();

		if (rslt[0] == null || rslt[0] == "") {
			return true;
		} else {
			return false;
		}

	}

}
