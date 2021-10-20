package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Report;
import za.ac.cput.factory.ReportFactory;
import za.ac.cput.service.entity.ReportService;

import java.util.Set;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/create")
    public Report create(@RequestBody Report report){
        Report newReport = ReportFactory.
                createReport(report.getReportId(),
                report.getReportAuth(),
                report.getReport(),
                report.getReportDate());
        return reportService.create(newReport);
    }

    @GetMapping("/read/{id}")
    public Report read(@PathVariable String id){
        return reportService.read(id);
    }

    @PutMapping("/update")
    public Report update(@RequestBody Report report){
        return reportService.update(report);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
       return reportService.delete(id);
    }

    @GetMapping("/all")
    public Set<Report> getAll(){
        return reportService.getAll();
    }

}
