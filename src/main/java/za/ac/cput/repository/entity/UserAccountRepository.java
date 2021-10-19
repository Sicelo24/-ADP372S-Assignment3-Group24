package za.ac.cput.repository.entity;
/*
 User Account Rep
 Author: Tashreeq Williams (217290671)
 Date: 26 July 2021
*/
import za.ac.cput.entity.UserAccount;
import za.ac.cput.repository.impl.IUserAccountRepository;

import java.util.*;
import java.util.Set;
@Deprecated
public class UserAccountRepository implements IUserAccountRepository {
    private static UserAccountRepository userAccountRepository = null;
    private Set<UserAccount> userAccountsDB;

    private UserAccountRepository() {
        userAccountsDB = new HashSet<>();
    }

    public static UserAccountRepository createUserAccountRepository() {
        if (userAccountRepository == null) userAccountRepository = new UserAccountRepository();
        return userAccountRepository;
    }

    @Override
    public Set<UserAccount> getAll() {
        return userAccountsDB;
    }

    @Override
    public UserAccount create(UserAccount userAccount) {
        userAccountsDB.add(userAccount);
        return userAccount;
    }

    @Override
    public UserAccount read(String s) {
        for (UserAccount userAccount : userAccountsDB) {
            return userAccount;
        }
        return null;
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        UserAccount r = create(userAccount);
        if (r != null)
            this.userAccountsDB.remove(r);
        this.userAccountsDB.add(userAccount);
        return userAccount;
    }

    @Override
    public boolean delete(String s) {
        UserAccount userAccount = read(s);
        if (userAccount != null) {
            this.userAccountsDB.remove(userAccount);
            return true;
        } else
            return false;
    }
}
