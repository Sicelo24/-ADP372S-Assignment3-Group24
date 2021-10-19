package za.ac.cput.service.entity;

/*
 Service for Report
 Author: Mlungisi Xakekile (215126505)
 Date:  02 August 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Report;
import za.ac.cput.repository.impl.ReportRepository;
import za.ac.cput.service.impl.IReportService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReportService implements IReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report create(Report report) {
        return this.reportRepository.save(report);
    }

    @Override
    public Report read(String id) {
        return this.reportRepository.findById(id).orElse(null);
    }


    @Override
    public Report update(Report report) {
        return this.reportRepository.save(report);
    }

    @Override
    public boolean delete(String id) {
        reportRepository.deleteById(id);
        return this.read(id) == null ? true : false;
    }

    @Override
    public Set<Report> getAll() {
        return reportRepository.findAll().stream().collect(Collectors.toSet());
    }

}
