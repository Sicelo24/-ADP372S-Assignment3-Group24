package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.Ticket;
import za.ac.cput.entity.UserAccount;

import java.util.Set;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
    UserAccount findByEmailAndPassword(String email, String Password);
}
