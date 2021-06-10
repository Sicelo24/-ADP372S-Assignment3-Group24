package za.ac.cput.Factory;

/*
 Entity for ReportFactoryTest
 Author: Mlungisi Xakekile (215126505)
 Date: 09 June 2021
*/

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Report;
import za.ac.cput.factory.ReportFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ReportFactoryTest {

    Report r;

    @BeforeEach

    public void setUp() throws Exception {
        r = ReportFactory.createReport(
                "215126505"
                ,"Mlungisi Xakekile"
                ,"09 June 2021");
    }
    @Test
    void buildReport() {
        assertNotNull(r);
        System.out.println(r);
    }

}
