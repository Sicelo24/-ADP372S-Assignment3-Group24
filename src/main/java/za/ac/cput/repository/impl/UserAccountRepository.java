package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

}
