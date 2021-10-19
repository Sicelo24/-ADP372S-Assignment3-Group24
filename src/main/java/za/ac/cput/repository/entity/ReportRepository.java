package za.ac.cput.repository.entity;

/*
 Factory for Report
 Author: Mlungisi Xakekile (215126505)
 Date: 26 July 2021
*/

import za.ac.cput.entity.Report;
import za.ac.cput.repository.impl.IReportRepository;

import java.util.HashSet;
import java.util.Set;

@Deprecated
public class ReportRepository implements IReportRepository {
    private static ReportRepository reportRepository = null;
    private Set<Report> reportSet;

    private ReportRepository() {
        this.reportSet = new HashSet<>();
    }

    public static IReportRepository geReportRepository() {
        if (reportRepository == null) {
            reportRepository = new ReportRepository();
        }
        return new ReportRepository();
    }

    @Override
    public Report create(Report report) {
        this.reportSet.add(report);
        return report;
    }

    @Override
    public Report read(Integer integer) {
        for (Report report : this.reportSet) {
            return report;
        }
        return null;
    }


    @Override
    public Report update(Report report) {
        Report r = create(report);
        if (r != null)
            this.reportSet.remove(r);
        this.reportSet.add(report);
        return report;
    }


    @Override
    public boolean delete(Integer integer) {
        Report report = read(integer);
        if (report != null) {
            this.reportSet.remove(report);
            return true;
        } else
        return false;
    }

    @Override
    public Set<Report> getAll() {
        return null;
    }

}