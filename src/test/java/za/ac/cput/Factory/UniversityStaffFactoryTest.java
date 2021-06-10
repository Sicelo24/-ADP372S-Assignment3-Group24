/* Assignment 3.java
 Entity for the UniversityStaff
 Author: Avuyile Xozumthi (218331827)
 Date: 10 june 2021
*/
package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UniversityStaff;

import static org.junit.jupiter.api.Assertions.*;

class UniversityStaffFactoryTest {
    UniversityStaff UniStaff;

    @BeforeEach
    void setUp() {
        UniStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");
    }
    @Test
    void buildUser(){
        assertNotNull(UniStaff);
        System.out.println(UniStaff);
    }

}