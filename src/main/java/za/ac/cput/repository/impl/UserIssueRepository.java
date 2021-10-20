package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.UserIssue;

public interface UserIssueRepository extends JpaRepository<UserIssue, String> {
}
