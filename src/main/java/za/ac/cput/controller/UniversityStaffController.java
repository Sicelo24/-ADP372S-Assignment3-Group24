package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.service.entity.UniversityStaffService;

import java.util.Set;

@RestController
@RequestMapping("/UniversityStaff")
public class UniversityStaffController {

    @Autowired
    private UniversityStaffService UniversityStaff;

    private UniversityStaffController() {
        UniversityStaff = UniversityStaffService.createUniversityStaffService();
    }

    @PostMapping("/create")
    public za.ac.cput.entity.UniversityStaff create(@RequestBody UniversityStaff UniversityStaff) {
        return UniversityStaff.create(UniversityStaff);
    }

    @GetMapping("/read")
    public UniversityStaff read(@RequestBody String id) {
        return UniversityStaff.read(id);
    }

    @PostMapping("/update")
    public UniversityStaff update(@RequestBody UniversityStaff UniversityStaff) {
        return UniversityStaff.update(UniversityStaff);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody String id){
        return UniversityStaff.delete(id) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }

    @GetMapping("/getall")
    public Set<UniversityStaff> getAll() {
        return UniversityStaff.getAll();
    }


}

