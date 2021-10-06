package za.ac.cput.factory;
/*
        @Author : Lindokuhle Xaki 215041720
        AuditorFactoryTest class
        date 5 June 2021
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Auditor;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


import za.ac.cput.entity.Auditor;


class AuditorFactoryTest {
    Auditor auditor;
    Auditor auditor2;

    @BeforeEach

    public void setUp() throws Exception {
        auditor = AuditorFactory.buildAuditor("215041720"
                ,"Lindokuhle"
                ,"Xaki"
                ,"06555111285");



        auditor2= AuditorFactory.buildAuditor("218275041"
                ,"Melokuhle"
                ,"Athandwa"
                ,"0744317738");
    }
    //Building auditor test
    @Test
    void buildAuditor() {
        assertNotNull(auditor);
        System.out.println(auditor);
    }

    //Testing object equality
    //Test passed Object Equality
    @Test
    void objectEquality() {
        assertEquals(auditor2, auditor2);
    }

    @Test
    void testIdentity() {
        //Testing Object Identity
        //Test passed Object Identity
        assertSame(auditor, auditor2);

    }

    @Test
    void timeoutExceededTest() {
        //It will display error message when time has exceeded
        assertTimeout(Duration.ofMillis(10), () -> {

            Thread.sleep(100);
            System.out.println("Timeout Exceeded");
        });
    }

    //disabling tests


    @Test
    @Disabled("Disabling the test")
    void disableTest() {

        assertSame(auditor, auditor2);
    }


}