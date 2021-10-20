package za.ac.cput.service.impl;

import za.ac.cput.entity.Issue;
import za.ac.cput.entity.UserIssue;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IUserIssue extends IService<UserIssue, String> {
    Set<UserIssue> getAll();
    Set<UserIssue> getUserIssuesOfUser(String userId);
}
