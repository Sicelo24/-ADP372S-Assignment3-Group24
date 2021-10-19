package za.ac.cput.service.impl;

import za.ac.cput.entity.Ticket;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IUserAccountService extends IService<UserAccount, String> {

    public Set<UserAccount> getAll();
}
