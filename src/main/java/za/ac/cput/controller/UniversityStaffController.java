package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.service.entity.UniversityStaffService;

import java.util.Set;

@RestController
@RequestMapping("/universitystaff")
public class UniversityStaffController {

    @Autowired
    private UniversityStaffService UniversityStaff;

    @PostMapping("/create")
    public za.ac.cput.entity.UniversityStaff create(@RequestBody UniversityStaff UniversityStaf) {
        return UniversityStaff.create(UniversityStaf);
    }

    @GetMapping("/read/{id}")
    public UniversityStaff read(@PathVariable String id) {
        return UniversityStaff.read(id);
    }

    @PutMapping("/update")
    public UniversityStaff update(@RequestBody UniversityStaff UniversityStaf) {
        return UniversityStaff.update(UniversityStaf);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return UniversityStaff.delete(id) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }


    @GetMapping("/getall")
    public Set<UniversityStaff> getAll() {
        return UniversityStaff.getAll();
    }


}

