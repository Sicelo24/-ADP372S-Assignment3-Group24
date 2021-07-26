package za.ac.cput.repository;
import za.ac.cput.entity.Issue;
import java.util.Set;

public interface IIssueRepository extends IRepository<Issue, String>{
    public Set<Issue> getAll();
}
