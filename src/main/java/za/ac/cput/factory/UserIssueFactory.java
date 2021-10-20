package za.ac.cput.factory;

import za.ac.cput.entity.UserIssue;
import za.ac.cput.util.KeyGenerator;

public class UserIssueFactory {

    public static UserIssue createUserIssue(String userId, String issueId){
        if(userId.isEmpty() || userId == null || issueId.isEmpty() || issueId == null)
            return new UserIssue.Builder().build();
        String userIssueId = KeyGenerator.genratedId();
        return new UserIssue.Builder().userIssueId(userIssueId).userId(userId).issueId(issueId).build();
    }
}
