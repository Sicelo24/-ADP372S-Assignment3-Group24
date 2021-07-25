package za.ac.cput.repository;

import za.ac.cput.entity.Issue;

import java.util.HashSet;
import java.util.Set;

public class IssueRepository implements IIssueRepository{
    private static IssueRepository issueRepository = null;
    private Set<Issue> issueDB;

    private IssueRepository(){
        issueDB = new HashSet<>();
    }

    public static IssueRepository createIssueRepository(){
        if(issueRepository == null) issueRepository = new IssueRepository();
        return issueRepository;
    }

    @Override
    public Set<Issue> getAll() {
        return issueDB;
    }

    @Override
    public Issue create(Issue issue) {
        issueDB.add(issue);
        return issue;
    }

    @Override
    public Issue read(String s) {
        for(Issue issue: issueDB)
            if(issue.getIssueId() == s) return issue;
        return null;
    }

    @Override
    public Issue update(Issue issue) {
        for(Issue i: issueDB)
            if(issue.getIssueId() == issue.getIssueId()) ;// Under construction
        return null;
    }

    @Override
    public boolean delete(String s) {
        boolean success = false;
        for(Issue issue: issueDB)
            if(issue.getIssueId() == s) success = issueDB.remove(issue);
        return success;
    }
}
