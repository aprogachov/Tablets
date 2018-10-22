package com.salereport;

import com.salereport.reader.MenuReport;
import com.salereport.service.TransactionSaleReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.text.ParseException;

public class ReportMain {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ReportConfig.class);

        context.getBean(MenuReport.class).menu();

//        TransactionSaleReportService tSaleReport = context.getBean(TransactionSaleReportService.class);
//        try {
//            tSaleReport.excelReport();
//        } catch (ParseException pe) {
//             pe.printStackTrace();
//        }

        context.close();
    }
}
