package za.ac.cput.service.entity;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.entity.Auditor;
import za.ac.cput.factory.AuditorFactory;
import za.ac.cput.service.entity.AuditorService;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AuditorServiceTest {

    private static AuditorService service = AuditorService.getService();
    private static Auditor auditor = AuditorFactory.buildAuditor("215041720", "114", "Sisanda",
            "Xaki", "121212");

    @Test
    void getService() {
        assertNotNull(service);
        System.out.println(service);
    }



    @Test
    void create() {
        Auditor generate = service.create(auditor);
        assertEquals(auditor.getAuditorID(), generate.getAuditorID());
        System.out.println("Created: " + generate);

    }

    @Test
    void read() {
        Auditor read = service.read(auditor.getAuditorFirstName());
        assertEquals("Sisanda", auditor.getAuditorFirstName());
        System.out.println("Created" + "\n " + read );
    }


    @Test
    void update() {
        Auditor updated = new Auditor.Builder().copy(auditor).
                setAuditorSurname("Somtsai").Build();

        updated = service.update(updated);
        assertEquals(auditor.getAuditorID(), updated.getAuditorID());
        System.out.println("Updated auditor\n" +updated );

    }

    @Test
    void delete() {
        service.delete("215041720");
        assertNull(service.read(auditor.getCellphone()));
        System.out.println("Delete\n"+service.read(auditor.getCellphone()));

    }

    @Test
    void getAll() {
        Set<Auditor> auditor = service.getAll();
        assertEquals(1,auditor.size());
        System.out.println("" + auditor);

    }
}