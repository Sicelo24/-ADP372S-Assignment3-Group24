package za.ac.cput.repository.entity;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Auditor;
import za.ac.cput.factory.AuditorFactory;
import za.ac.cput.repository.entity.AuditorRepository;


import static org.junit.jupiter.api.Assertions.*;
public class AuditorRepositoryTest {
    AuditorRepository repository;
    Auditor auditor;

    @BeforeEach
    public void setUp() throws Exception {
        repository = AuditorRepository.getRepository();
        auditor = AuditorFactory.buildAuditor("215041720"
                , "123"
                , "Lindokuhle"
                , "Xaki"
                , "0744317738");
    }


    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(auditor);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(auditor);
        assertNotNull(repository.read(auditor.getAuditorID()));
        System.out.println("Created\n" + repository.read(auditor.getAuditorID()));
    }

    @Test
    public void read() {
        assertNotNull(repository.read(auditor.getAuditorID()));
        System.out.println("Read\n" + repository.read(auditor.getAuditorID()));
    }

    @Test
    public void update() {
    Auditor revise = new Auditor.Builder().copy(auditor).setAuditorFirstName("Melo").setAuditorSurname("Dyidi").Build();
    revise = repository.update(revise);
    assertEquals(auditor.getAuditorID(), revise.getAuditorID());
    System.out.println("Update: " + revise);
}

    @Test
    public void delete() {

        repository.delete("215041720");
        assertNull(repository.read("215041720"));
        System.out.println("Deleted\n" + repository.read("215041720"));

}}
