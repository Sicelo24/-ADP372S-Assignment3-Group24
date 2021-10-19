package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.entity.Auditor;
import za.ac.cput.factory.AuditorFactory;
import za.ac.cput.service.entity.AuditorService;


import java.util.Set;


@RestController
@RequestMapping("/auditor")
public class AuditorController {

    @Autowired
    private AuditorService auditorService;

    //@RequestMapping(value = "create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Auditor create(@RequestBody Auditor auditor) {
        Auditor newauditor = AuditorFactory.buildAuditor(auditor.getAuditorID(), auditor.getAuditorFirstName(),
                auditor.getAuditorSurname(), auditor.getCellphone());
        return auditorService.create(newauditor);
    }

    @GetMapping("/read/{auditorID}")
    public Auditor read (@PathVariable String auditorID){
        return auditorService.read(auditorID);

    }
    @PutMapping("/update")
    public Auditor update(@RequestBody Auditor auditor){
        return auditorService.update(auditor);
    }

    //delete not working

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody String auditorID){
        return auditorService.delete(auditorID);

    }
    @GetMapping("/getAll")
    public Set<Auditor> getAll(){
        return auditorService.getAll();
    }

    @GetMapping("/getallwitha")
    public Set<Auditor> getallwitha(){
        return auditorService.getAllAuditorsStartWithA();
    }

}

