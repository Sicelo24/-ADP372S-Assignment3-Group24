package za.ac.cput.factory;

        /*@Author : Tashreeq Williams (217290671)
        UserAccount TDD
        9/6/2021*/



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.entity.UserAccount;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountFactoryTest {
    UserAccount uA1 = UserAccountFactory.buildUserAccount("102",
            "JohnDoe@Gmail.com",
            "MyPassword",
            true,
            "11/6/2021");

    UserAccount uA2 = UserAccountFactory.buildUserAccount("103",
            "PeterPan@Gmail.com",
            "PetersPassword",
            true,
            "7/6/2010");

    @Test
    void buildingAUserAccount(){
        UserAccount uA1 = UserAccountFactory.buildUserAccount("102",
                "JohnDoe@Gmail.com",
                "MyPassword",
                true,
                "11/6/2021");

        assertNotNull(uA1);
        System.out.println("This is UserAccount1: " + uA1);
    }

    @Test
    void EqualityTesting(){
        UserAccount uA1 = UserAccountFactory.buildUserAccount("102",
                "JohnDoe@Gmail.com",
                "MyPassword",
                true,
                "11/6/2021");

        UserAccount uA2 = uA1;
        assertEquals(uA1,uA2);

    }
    @Disabled("-> disable <-")
    @Test
    void testEqualityDis(){
        UserAccount uA1 = UserAccountFactory.buildUserAccount("102",
                "JohnDoe@Gmail.com",
                "MyPassword",
                true,
                "11/6/2021");

        UserAccount uA2 = uA1;
        assertEquals(uA1,uA2);

    }
    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        UserAccount uA1 = UserAccountFactory.buildUserAccount("102",
                "JohnDoe@Gmail.com",
                "MyPassword",
                true,
                "11/6/2021");


        UserAccount uA2 = uA1;
        assertEquals(uA1,uA2);
    }





  }
