package za.ac.cput.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.repository.impl.IUserAccountRepository;
import za.ac.cput.repository.impl.UserAccountRepository;
import za.ac.cput.service.impl.IUserAccountService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserAccountService implements IUserAccountService {

    @Autowired
    private UserAccountRepository repository;


    public UserAccount login(String email, String password){
        return this.repository.findByEmailAndPassword(email, password);
    }

    @Override
    public UserAccount create(UserAccount userAccount) {
        return this.repository.save(userAccount);
    }

    @Override
    public UserAccount read(String userId) {
        return this.repository.findById(userId).orElse(null);
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return this.read(userAccount.getUserId()) != null ? repository.save(userAccount) : null;
    }

    @Override
    public boolean delete(String userId) {
        repository.deleteById(userId);
        return this.read(userId) == null ? true : false;
    }

    @Override
    public Set<UserAccount> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public UserAccount blockUser(String userId) {
        UserAccount block = this.read(userId);
        block = new UserAccount.Builder().copy(block).setloginStatus(-1).build();
        return this.update(block);
    }

    @Override
    public UserAccount getByEmail(String email) {
        return this.repository.findByEmail(email);
    }
}
