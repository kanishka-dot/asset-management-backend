package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.GTN;
import com.example.demo.entity.InvLocation;
import com.example.demo.repositary.GTNRepositary;
import com.example.demo.repositary.InvLocationRepositary;

@Service
public class GTNService {

	static LocalDate date = LocalDate.now();



	@Autowired
	GTNRepositary gtnRepositary;

	@Autowired
	DocMasterService docMasterService;

	@Autowired
	InvLocationRepositary invLocationRepositary;

	@Transactional(rollbackFor = Exception.class)
	public ArrayList<String> saveGTN(ArrayList<GTN> gtnList) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			Integer docNum = docMasterService.getDocNum("GTN");

			if (docNum == 0) {

				throw new Exception("Unable to find doc master para for GTN");
			}

			for (int i = 0; i < gtnList.size(); i++) {

				GTN updateGTN = gtnList.get(i);

				InvLocation updateInvLocation = invLocationRepositary.findById(updateGTN.getSerialno()).orElse(null);

				if (updateInvLocation == null) {

					throw new Exception("Unable to find Inventory Item in Location");
				}

				updateGTN.getGtnPK().setDoccode("GTN");
				updateGTN.getGtnPK().setDocno(docNum);
				updateGTN.getGtnPK().setSeq_no(i);
				updateGTN.setStatus("NAP");
				updateGTN.setCre_date(date.toString());
				updateGTN.setMod_date("1000-01-01");
				updateGTN.setApp_date("1000-01-01");
				gtnRepositary.save(updateGTN);

				updateInvLocation.setTemploc(updateGTN.getToloc());
				updateInvLocation.setStatus("TRD");
				updateInvLocation.setMod_date(date.toString());
				updateInvLocation.setMod_by(updateGTN.getCre_by());
				invLocationRepositary.save(updateInvLocation);

			}

			docMasterService.updateDocNum("GTN");

			result.add("1");
			result.add("GTN Successfully saved - " + docNum);

			return result;

		} catch (Exception e) {
			result.add("0");
			result.add(e.getLocalizedMessage());
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}

	}

	@Transactional(rollbackFor = Exception.class)
	public ArrayList<String> approveGTN(Integer gtnNo, String user) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			List<GTN> gtnList = gtnRepositary.findByGtnPKDocno(gtnNo);
			System.out.println(gtnList);
			if (gtnList.size() == 0) {

				throw new Exception("Unable to Find  GTN");
			}

			for (int i = 0; i < gtnList.size(); i++) {

				GTN getGtnEntity = gtnList.get(i);
				String itemSerial = getGtnEntity.getSerialno();
				invLocationRepositary.updateInvLocation(itemSerial);

			}

			gtnRepositary.updateGTNApproved(user, date.toString(), gtnNo);

			result.add("1");
			result.add("GTN Sucessfully Approved");

			return result;
		} catch (Exception e) {

			result.add("0");
			result.add(e.getLocalizedMessage());
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}

	}

	public List<GTN> getAvailableGTN(Integer Str_location) {
		return gtnRepositary.getAllAvailableGTN(Str_location);
	}

	public List<GTN> getSelectGTN(Integer docno) {
		return gtnRepositary.findByGtnPKDocno(docno);
	}

}
