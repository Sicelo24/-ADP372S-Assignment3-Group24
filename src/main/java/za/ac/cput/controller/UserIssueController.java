package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.UserIssue;
import za.ac.cput.factory.IssueFactory;
import za.ac.cput.factory.UserIssueFactory;
import za.ac.cput.service.entity.IssueService;
import za.ac.cput.service.entity.UserIssueService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/userissue")
public class UserIssueController {

    @Autowired
    private UserIssueService service;

    @Autowired
    private IssueService issueService;

    @PostMapping("/create")
    public UserIssue create(@RequestBody UserIssue userIssue) {
        UserIssue newUserIssue = UserIssueFactory.createUserIssue(userIssue.getUserId(), userIssue.getIssueId());
        return this.service.create(newUserIssue);
    }

    @GetMapping("/read/{id}")
    public UserIssue read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public UserIssue update(@RequestBody UserIssue userIssue) {
        return service.update(userIssue);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return service.delete(id) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }

    @GetMapping("/getall")
    public Set<UserIssue> getAll() {
        return service.getAll();
    }
  //@GetMapping("/getuserissuesof/tt23")
    @GetMapping("/getuserissuesof/{userId}")
    public ArrayList<Issue> getIssuesOfUser(@PathVariable String userId) {
        Set<UserIssue> userIssues = service.getUserIssuesOfUser(userId);
        ArrayList<Issue> issues = new ArrayList<>();
        for(UserIssue userIssue : userIssues)
            issues.add(issueService.read(userIssue.getIssueId()));
        return issues;
    }

}
