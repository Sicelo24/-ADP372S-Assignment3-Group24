package za.ac.cput.repository.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Auditor;
import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.factory.AuditorFactory;
import za.ac.cput.factory.UniversityStaffFactory;

import static org.junit.jupiter.api.Assertions.*;

class UniversityStaffRepositoryTest {

    UniversityStaffRepository repository;
    UniversityStaff  UniversityStaff;

    @BeforeEach
    public void setUp() throws Exception {
        repository = UniversityStaffRepository.getRepository();
        UniversityStaff = UniversityStaffFactory.buildUniversityStaff("218331827","Avuyile","Xozumthi","0839281109");

    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(UniversityStaff);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(UniversityStaff);
        assertNotNull(repository.read(UniversityStaff.getStaffID()));
        System.out.println("Created\n" + repository.read(UniversityStaff.getStaffID()));
    }

    @Test
    public void read() {
        assertNotNull(repository.read(UniversityStaff.getStaffID()));
        System.out.println("Read\n" + repository.read(UniversityStaff.getStaffID()));
    }

    @Test
    public void update() {
        UniversityStaff revise = new UniversityStaff.Builder().Copy(UniversityStaff).setstaffFirstName("AVO").setstaffSurname("CALEB").Build();
        revise = repository.update(revise);
        assertEquals(UniversityStaff.getStaffID(), revise.getStaffID());
        System.out.println("Update: " + revise);
    }


    @Test
    public void delete() {

        repository.delete("218331827");
        assertNull(repository.read("218331827"));
        System.out.println("Deleted\n" + repository.read("218331827"));
    }

}