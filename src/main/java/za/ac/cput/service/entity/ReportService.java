package za.ac.cput.service.entity;

/*
 Service for Report
 Author: Mlungisi Xakekile (215126505)
 Date:  02 August 2021
*/

import za.ac.cput.entity.Report;
import za.ac.cput.repository.entity.ReportRepository;
import za.ac.cput.service.impl.IReportService;

import java.util.Set;


public class ReportService implements IReportService {

    public static IReportService reportSer = null;
    public Integer delete;
    public Integer read;
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
    public Report read(Integer integer) {

        return this.reportRepository.read(integer);
    }


    @Override
    public Report update(Report report) {

        return this.reportRepository.update(report);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.reportRepository.delete(integer);
    }

    @Override
    public Set<Report> getAll() {

        return this.reportRepository.getAll();
    }

}
