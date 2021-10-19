package za.ac.cput.service.entity;

import org.springframework.stereotype.Service;
import za.ac.cput.repository.entity.UniversityStaffRepository;
import za.ac.cput.service.impl.IUniversityStaff;
import za.ac.cput.entity.UniversityStaff;

import java.util.Set;

@Service
public class UniversityStaffService implements IUniversityStaff {

    private static UniversityStaffService universityStaffService = null;
    private static UniversityStaffRepository repository = null;

    private UniversityStaffService(){repository = UniversityStaffRepository.getRepository();}

    public static UniversityStaffService createUniversityStaffService(){
        if(universityStaffService == null) universityStaffService = new UniversityStaffService();
        return universityStaffService;
    }

    @Override
    public UniversityStaff create(UniversityStaff universityStaff) {
        return repository.create(universityStaff);
    }

    @Override
    public UniversityStaff read(String s) {
        return repository.read(s);
    }

    @Override
    public UniversityStaff update(UniversityStaff universityStaff) {
        return repository.update(universityStaff);
    }

    @Override
    public boolean delete(String s) {
        return repository.delete(s);
    }

    @Override
    public Set<UniversityStaff> getAll() {
        return repository.getAll();
    }
}

