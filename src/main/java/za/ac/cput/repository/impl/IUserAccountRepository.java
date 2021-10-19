package za.ac.cput.repository.impl;
/*
 User Account Rep
 Author: Tashreeq Williams (217290671)
 Date: 26 July 2021
*/

import za.ac.cput.entity.UserAccount;
import za.ac.cput.repository.IRepository;
import java.util.Set;
@Deprecated
public interface IUserAccountRepository extends IRepository<UserAccount,String>{
    Set<UserAccount> getAll();
}
