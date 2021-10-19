package za.ac.cput.service.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.factory.UniversityStaffFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniversityStaffServiceTest {
    private static UniversityStaffService service;
    private static UniversityStaff stuff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");

    @Test
    void create() {
        UniversityStaff generate = service.create(stuff);
        assertEquals(stuff.getStaffID(), generate.getStaffID());
        System.out.println("Created: " + generate);
    }

    @Test
    void read() {
        UniversityStaff read = service.read(stuff.getStaffID());
        assertEquals("218331827", stuff.getStaffID());
        System.out.println("Created" + "\n " + read );
    }

    @Test
    void update() {
        UniversityStaff updated = new UniversityStaff.Builder().Copy(stuff).
                staffID("218331827").Build();

        updated = service.update(updated);
        assertEquals(stuff.getStaffID(), updated.getStaffID());
        System.out.println("Updated stuff\n" +updated );
    }
    @Test
    void delete() {
        service.delete("218331827");
        assertNull(service.read(stuff.getStaffID()));
        System.out.println("Delete\n"+service.read(stuff.getStaffID()));
    }

    @Test
    void getAll() {
        Set<UniversityStaff> UniversityStaffset = service.getAll();
        assertEquals(0,UniversityStaffset.size());
        System.out.println("" + UniversityStaffset);
    }
}