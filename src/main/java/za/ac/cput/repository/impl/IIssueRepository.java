package za.ac.cput.repository.impl;
import za.ac.cput.entity.Issue;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IIssueRepository extends IRepository<Issue, String> {
    public Set<Issue> getAll();
}
