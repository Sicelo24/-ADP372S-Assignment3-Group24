/* IssueService.java Class
 * Entity for Issue Service
 * Author: Athenkosi Zono (218030185)
 * Date: 28 July 2021
 */

package za.ac.cput.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Issue;
import za.ac.cput.repository.impl.IssueRepository;
import za.ac.cput.service.impl.IIssueService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IssueService implements IIssueService {

    @Autowired
    private IssueRepository repository;

    @Override
    public Issue create(Issue issue) {
        //return repository.create(issue);
        return this.repository.save(issue);
    }

    @Override
    public Issue read(String issueId) {
        //return repository.read(issueId);
        return this.repository.findById(issueId).orElse(null);
    }

    @Override
    public Issue update(Issue issue) {
        //return repository.update(issue);
        return this.read(issue.getIssueId()) != null ? repository.save(issue) : null;
    }

    @Override
    public boolean delete(String issueId) {
        //return repository.delete(issueId);
        repository.deleteById(issueId);
        return this.read(issueId) == null ? true : false;
    }

    @Override
    public Set<Issue> getAll() {
        //return repository.getAll();
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Issue> getAllClosed() {
        return repository.findAll().stream().filter(issue -> issue.getIssueStatus() <= 0).collect(Collectors.toSet());
    }

    @Override
    public Set<Issue> getAllOpen() {
        return repository.findAll().stream().filter(issue -> issue.getIssueStatus() > 0).collect(Collectors.toSet());
    }
}
