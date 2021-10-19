package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.factory.UserAccountFactory;
import za.ac.cput.service.entity.UserAccountService;

import java.util.Set;

@RestController
@RequestMapping("/userAccount")
public class UserAccountController {
    @Autowired
    private UserAccountService service;

    @PostMapping("/create {login}")
    public UserAccount login(@PathVariable String email, String password){
        boolean emailExist = false;
        boolean passwordExist = false;
        if (email != null){
            emailExist = true;
        }
        if (emailExist = true) {
            return service.read(email);
        }
        if (password != null){
            passwordExist = true;
        }
        if (passwordExist = true){
            return service.read(password);
        }
        else return null;
    }

    @PostMapping("/create")
    public UserAccount create(@RequestBody UserAccount userAccount) {
        UserAccount newUserAccount = UserAccountFactory.buildUserAccount(userAccount.getUserId(),
                userAccount.getEmail(), userAccount.getPassword(), userAccount.getLoginStatus(), userAccount.getRegisterDate());
        return this.service.create(newUserAccount);
    }
    @GetMapping("/read/{id}")
    public UserAccount read(@PathVariable String id) {
        return service.read(id);
    }

    @PostMapping("/update")
    public UserAccount update(@RequestBody UserAccount userAccount) {
        return service.update(userAccount);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return service.delete(id) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }

    @GetMapping("/getall")
    public Set<UserAccount> getAll() {
        return service.getAll();
    }

}
