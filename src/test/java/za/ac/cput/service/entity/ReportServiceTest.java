package za.ac.cput.service.entity;

/*
 Service for Report
 Author: Mlungisi Xakekile (215126505)
 Date:  02 August 2021


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Report;
import za.ac.cput.factory.ReportFactory;
import za.ac.cput.service.entity.ReportService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class ReportServiceTest{

   // private static final ReportService reportSer;// = (ReportService) ReportService.getReportService();
    private static final Report report = ReportFactory.createReport("215126505",
            "Mr. M Xakekile",
            "02 August 2021");

    @Test
    void getReportService() {
    }

    @Test
    void create() {
        assertEquals(report.getReportId(), report.getReportId());
        System.out.println("\nReport created: " + report);
    }

    @Test
    void read() {
       Report read = reportSer.read(reportSer.read);
        assertNotNull(read);
        System.out.println("\nTo String:\n" + read);

    }

    @Test
    void update() {
        Report report1 = new Report.Builder().copy(report).setReportId("212121212")
                .setReportDate
                ("16 September 2021").setReportAuth("")
                .build();
        report1 = reportSer.update(report1);
        assertEquals(report1.getReportId(), report1.getReportId());
        System.out.println("\nUpdated Report: " + report1);
    }

    @Test
    void delete() {
       boolean deleteSuccessful = reportSer.delete(reportSer.delete);
        assertTrue(deleteSuccessful);

    }

    @Test
    public void getAll() {
        Set<Report> reportSet = reportSer.getAll();
        assertEquals(report, report);
        System.out.println("\nDisplay all Test: " + reportSet);
    }
} */