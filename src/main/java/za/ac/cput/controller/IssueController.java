/* IssueController.java Class
 * Entity for Issue Controller
 * Author: Athenkosi Zono (218030185)
 * Date: 4 August 2021
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.factory.IssueFactory;
import za.ac.cput.service.entity.IssueService;
import java.util.Set;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService service;

    @PostMapping("/create")
    public Issue create(@RequestBody Issue issue) {
        Issue newIssue = IssueFactory.createIssue(issue.getIssueDescription(),
                issue.getIssueArea(), issue.getIssueRaisedDate(), issue.getIssueResolvedDate(),
                issue.isIssueStatus(), issue.isResolved(), issue.isValidated());
        return service.create(newIssue);
    }

    @GetMapping("/read/{id}")
    public Issue read(@PathVariable String id) {
        return service.read(id);
    }

    @PostMapping("/update")
    public Issue update(@RequestBody Issue issue) {
        return service.update(issue);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return service.delete(id) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }

    @GetMapping("/getall")
    public Set<Issue> getAll() {
        return service.getAll();
    }

}
