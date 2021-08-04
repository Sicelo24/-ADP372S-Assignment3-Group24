package za.ac.cput.service.impl;

/*
 Service for Report
 Author: Mlungisi Xakekile (215126505)
 Date:  02 August 2021
*/

import za.ac.cput.entity.Report;
import za.ac.cput.repository.impl.IssueRepository;
import za.ac.cput.repository.impl.ReportRepository;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class ReportService implements IReportService{

    public static IReportService reportSer = null;
    private ReportRepository reportRepository;

    private ReportService(){
        this.reportRepository = (ReportRepository) ReportRepository.geReportRepository();
    }

    public static IReportService getReportService(){
        if(reportSer == null) {
            reportSer = new ReportService();
        }
        return reportSer;
    }

    @Override
    public Report create(Report report) {

        return this.reportRepository.create(report);
    }

    @Override
    public Report read(Integer s) {
        return this.reportRepository.read(s);
    }

    @Override
    public Report update(Report report) {
        return this.reportRepository.update(report);
    }

    @Override
    public boolean delete(Integer s) {
        return this.reportRepository.delete(s);
    }

    @Override
    public Set<Report> getAll() {
        return this.reportRepository.getAll();
    }
}
