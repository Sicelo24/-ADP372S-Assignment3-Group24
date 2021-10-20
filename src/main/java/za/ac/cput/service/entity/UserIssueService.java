package za.ac.cput.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserIssue;
import za.ac.cput.repository.impl.UserIssueRepository;
import za.ac.cput.service.impl.IUserIssue;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserIssueService implements IUserIssue {

    @Autowired
    private UserIssueRepository repository;

    @Override
    public UserIssue create(UserIssue userIssue) {
        return this.repository.save(userIssue);
    }

    @Override
    public UserIssue read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public UserIssue update(UserIssue userIssue) {
        return this.read(userIssue.getIssueId()) != null ? repository.save(userIssue) : null;
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return this.read(id) == null ? true : false;
    }

    @Override
    public Set<UserIssue> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<UserIssue> getUserIssuesOfUser(String userId) {
        return repository.findAll().stream().filter(userIssue -> userIssue.getUserId().equals(userId)).collect(Collectors.toSet());
    }

}
