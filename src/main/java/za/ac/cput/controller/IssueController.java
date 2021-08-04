/* IssueController.java Class
 * Entity for Issue Controller
 * Author: Athenkosi Zono (218030185)
 * Date: 4 August 2021
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.service.impl.IssueService;

import java.util.Set;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService service;

    private IssueController() { service = IssueService.createIssueService(); }

    @PostMapping("/create")
    public Issue createIssue(@RequestBody Issue issue) { return service.create(issue); }

    @GetMapping("/read")
    public Issue read(@RequestBody String id) { return service.read(id); }

    @GetMapping("/update")
    public Issue update(@RequestBody Issue issue) { return service.update(issue); }

    @DeleteMapping("/delete")
    public String delete(@RequestBody String id){
        String status = service.delete(id) ? "Successfully deleted." : "Could Not Perform delete successfully!";
        return status;
    }

    @GetMapping("/getall")
    public Set<Issue> getAll() { return service.getAll(); }

}
