package za.ac.cput.service.entity;



import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Auditor;
import za.ac.cput.factory.AuditorFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class AuditorServiceTest {
    private static AuditorService service = AuditorService.getService();
    private static Auditor auditor = AuditorFactory.buildAuditor("215041720", "Sisanda", "Xaki",
            "121212");

    @Test
    void a_create() {
        Auditor created = service.create(auditor);
        assertEquals(created.getAuditorFirstName(), auditor.getAuditorFirstName());
        System.out.println("Create" + created);

    }

    @Test
    void b_read() {
        Auditor read = service.read(auditor.getAuditorID());
        assertEquals("215041720", auditor.getAuditorID());
        System.out.println("Read success " +read);
    }


    @Test
    void c_update() {
        Auditor updated = new Auditor.Builder().copy(auditor).setAuditorSurname("Somtsai").build();
        assertNotNull(service.update(updated));
        System.out.println("Surname updated successfully: " +updated );
    }

    @Test
    void e_delete() {
        boolean success = service.delete(auditor.getAuditorID());
        assertTrue(success);
        System.out.println("Delete: "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());

    }
    @Test
    void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

}