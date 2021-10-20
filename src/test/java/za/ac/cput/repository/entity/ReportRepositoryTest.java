package za.ac.cput.repository.entity;

/*
 Factory for Report
 Author: Mlungisi Xakekile (215126505)
 Date: 26 July 2021
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Report;
import za.ac.cput.factory.ReportFactory;
import za.ac.cput.repository.entity.ReportRepository;
import za.ac.cput.repository.impl.IReportRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ReportRepositoryTest {
    private static IReportRepository reportRepository = ReportRepository.geReportRepository();
    private static Report report = ReportFactory.createReport("215126505",
            "Mlungisi Xakekile","NA",
            "2021/03/16");

    @Test
    public void geReportRepository() {
    }

    @Test
    public void create() {
        Report report1 = reportRepository.create(reportRepository.create(report));
        assertEquals(report.getReportId(), report.getReportId());
        System.out.println("\nCreated: " + report);
    }

    @Test
    public void read() {
        Report read = reportRepository.create(report);
        assertNotNull(read);
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void update() {
        Report r = new Report.Builder().copy(report).setReportId("215126505")
                .setReportAuth("Mr Xakekile")
                .setReportDate("26 July 2021")
                .build();
        assertEquals(report.getReportId(), r.getReportId());
        System.out.println("Update: " + r);
    }

    @Test
    public void delete() {
        boolean deleteSuccessful = reportRepository.getAll().remove(report.getReportId());
        assertTrue(deleteSuccessful);
    }

    @Test
    public void getAll() {
        System.out.println("\nDisplay All: " + reportRepository.getAll());
    }
}