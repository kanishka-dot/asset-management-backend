package com.example.demo.controler;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.BeanConnection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@CrossOrigin(origins = "*")
public class Report {

	@Autowired
	BeanConnection dataSource;

	@GetMapping("/report/itemmaster")
	public ArrayList<String> viewItemMaster() {

		ArrayList<String> result = new ArrayList<String>();

		try {
			Connection con = dataSource.getDataSource();

			final InputStream stream = this.getClass().getResourceAsStream("/itemmaster.jrxml");

			final JasperReport report = JasperCompileManager.compileReport(stream);

			final JasperPrint print = JasperFillManager.fillReport(report, null, con);

			final String filePath = "E:\\Learn\\Spring Boot\\ITInventoryApi\\reports";
			JasperExportManager.exportReportToPdfFile(print, filePath + "\\ItemMaster.pdf");

			result.add("1");
			result.add("E:\\Learn\\Spring Boot\\ITInventoryApi\\reports\\ItemMaster.pdf");
			return result;

		} catch (JRException e) {
			result.add("0");
			result.add(e.getLocalizedMessage());
			return result;
		} catch (SQLException e) {
			result.add("0");
			result.add(e.getLocalizedMessage());
			return result;

		}
	}

}
