package za.ac.cput.factory;

/*
        @Author : Lindokuhle Xaki 215041720
        AuditorFactoryTest class
        date 5 June 2021

*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Auditor;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class AuditorFactoryTest {


    Auditor auditor;

    @BeforeEach

    public void setUp() throws Exception {
        auditor = AuditorFactory.buildAuditor(
                 "215041720"
                ,"101"
                ,"Lindokuhle"
                ,"Xaki"
                ,"06555111285");
    }
    //Test
    @Test
    void buildAuditor() {
        assertNotNull(auditor);
        System.out.println(auditor);
    }
}