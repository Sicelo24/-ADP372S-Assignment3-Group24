/* IssueService.java Class
 * Entity for Issue Service
 * Author: Athenkosi Zono (218030185)
 * Date: 28 July 2021
 */

package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Issue;
import za.ac.cput.repository.entity.IssueRepository;
import java.util.Set;

@Service
public class IssueService implements IIssueService{

    private static IssueService issueService = null;
    private static IssueRepository repository = null;

    private IssueService(){
        repository = IssueRepository.createIssueRepository();
    }

    public static IssueService createIssueService(){
        if(issueService == null) issueService = new IssueService();
        return issueService;
    }

    @Override
    public Issue create(Issue issue) {
        return repository.create(issue);
    }

    @Override
    public Issue read(String s) {
        return repository.read(s);
    }

    @Override
    public Issue update(Issue issue) {
        return repository.update(issue);
    }

    @Override
    public boolean delete(String s) {
        return repository.delete(s);
    }

    @Override
    public Set<Issue> getAll() {
        return repository.getAll();
    }
}
