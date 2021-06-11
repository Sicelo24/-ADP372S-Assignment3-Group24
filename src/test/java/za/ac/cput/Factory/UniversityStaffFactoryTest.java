package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.factory.UniversityStaffFactory;

import static org.junit.jupiter.api.Assertions.*;

class UniversityStaffFactoryTest {
    UniversityStaff UniStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");
    UniversityStaff UniStaff2= UniversityStaffFactory.buildUniversityStaff("218345896","HAVOC","CPT","0837663734");

    @Test
    void buildUser(){
        UniversityStaff UniStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");
        assertNotNull(UniStaff);
        System.out.println(UniStaff);
    }
    //equality test
    @Test
    void testEquality(){
        UniversityStaff UniStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");
        UniversityStaff UniStaff2 = UniStaff;
        assertEquals(UniStaff,UniStaff2);
    }
    //disabled
    @Disabled("disable for maintenance")
    @Test
    void testEqualityDisable(){
        UniversityStaff UniStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");
        UniversityStaff UniStaff2 = UniStaff;
        assertEquals(UniStaff,UniStaff2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        UniversityStaff UniStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");
        UniversityStaff UniStaff2 = UniStaff;
        assertEquals(UniStaff,UniStaff2);
    }
}