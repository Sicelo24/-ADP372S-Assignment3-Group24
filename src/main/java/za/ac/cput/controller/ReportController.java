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
        boolean reportExist = false;
        Report newReport = ReportFactory.
                createReport(report.getReportId(),
                report.getReportAuth(),
                report.getReportDate());

        if (newReport != null) {
            reportExist = true;
        }
        if (reportExist) {
            return reportService.create(newReport);
        }
        else return ReportFactory.createReport(null,null,null);
    }

    @GetMapping("/read {reportId}")
    public Report read(@PathVariable Integer id){
        boolean reportExist = false;
        if(id !=null){
            reportExist = true;
        }
        if (reportExist = true) {
            return reportService.read(id);
        }
        else return null;
    }

    @PostMapping("/update")
    public Report update(@RequestBody Report report){
        boolean reportExist = false;
        if(report !=null) {
            reportExist = true;
        }
        if (reportExist) {
            return reportService.update(report);
        }
        else return null;
    }

    @DeleteMapping("/delete {reportId}")
    public boolean delete(@PathVariable Integer id){
        boolean reportExist = false;
        if(id != null){
            reportExist = true;
        }
        if (reportExist) {
            return reportService.delete(id);
        }
        else return false;
    }

    @GetMapping("/all")
    public Set<Report> getAll(){
        return reportService.getAll();
    }

}
