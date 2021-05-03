package com.example.reports;

import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;

public class ItemMasterRepo {
		
	
	
	public void compileJasper() throws JRException {
		InputStream itemMasterReport = getClass().getResourceAsStream("/itemmaster.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(itemMasterReport);
		JRSaver.saveObject(jasperReport, "itemmaster.jasper");
	}
	


	
}
