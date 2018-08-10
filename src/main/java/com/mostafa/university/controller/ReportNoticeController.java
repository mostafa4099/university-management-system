/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafa.university.controller;

import com.mostafa.university.dao.JasperReportDAO;
import com.mostafa.university.report.ReportInputForm;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
public class ReportNoticeController {

    @RequestMapping(value = "/noticeReport", method = RequestMethod.GET)
    public String loadSurveyPg(
            @ModelAttribute("reportInputForm") ReportInputForm reportInputForm,
            Model model) {
        model.addAttribute("reportInputForm", reportInputForm);

        return "report_notice";
    }
    @RequestMapping(value = "/noticeReport", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") ReportInputForm reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "notice";
        JasperReportDAO jrdao = new JasperReportDAO();
        
        Connection conn = null;

        try {
            conn = jrdao.getConnection();

            int id = reportInputForm.getId();

            HashMap<String, Object> hmParams = new HashMap<String, Object>();

            hmParams.put("noticeId", id);

            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,
                    request);

//            if (rptFormat.equalsIgnoreCase("html")) {
//
//                JasperPrint jasperPrint = JasperFillManager.fillReport(
//                        jasperReport, hmParams, conn);
//                jrdao.generateReportHtml(jasperPrint, request, response); // For
//                // HTML
//                // report
//
//            } else if (rptFormat.equalsIgnoreCase("pdf")) {

                jrdao.generateReportPDF(response, hmParams, jasperReport, conn); // For
                // PDF
                // report

//            }

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
}
