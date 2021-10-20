package za.ac.cput.factory;

/*
 Entity for ReportFactoryTest
 Author: Mlungisi Xakekile (215126505)
 Date: 09 June 2021
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Report;
import za.ac.cput.factory.ReportFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ReportFactoryTest {

    Report r1;
    Report r2;

    @BeforeEach

    public void setUp() throws Exception {
        r1 = ReportFactory.createReport(
                "215126505"
                ,"Mlungisi Xakekile"
                , "NA"
                ,"09 June 2021");

        r2 = ReportFactory.createReport(
                "215100002"
                ,"President"
                ,"NA"
                ,"09 June 2021");
    }
    @Test
    void buildReport() {
        assertNotNull(r1);
        System.out.println(r2);
    }

    @Test
    void objectEquality() {
        assertEquals(r1.getReportDate(), r2.getReportDate());
    }

    @Test
    void objectIdentity(){
        assertSame(r1.getReportDate(), r2.getReportDate());
    }

    @Test
    void timeouts() throws Exception {
        Thread.sleep(1000);
        assertNotNull(r1);
    }

    @Disabled("Disable the test")
    @Test void disablingTests(){
        assertNotNull(r2);
    }

}
