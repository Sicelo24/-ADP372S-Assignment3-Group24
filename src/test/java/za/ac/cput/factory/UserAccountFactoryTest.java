package za.ac.cput.factory;

        /*@Author : Tashreeq Williams (217290671)
        UserAccount TDD
        9/6/2021*/



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserAccount;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountFactoryTest {
    UserAccount uAccount;

    @BeforeEach
    void setUp() {
        uAccount = UserAccountFactory.buildUserAccount("102",
                "JohnDoe@gmail.com",
                "myPassword",
                true,
                "11/6/2020");
    }
    @Test
    void buildUser(){
        assertNotNull(uAccount);
        System.out.println(uAccount);
    }

}