package za.ac.cput.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Issue;
import za.ac.cput.repository.impl.IssueRepository;
import za.ac.cput.repository.impl.UniversityStaffRepository;
import za.ac.cput.service.impl.IUniversityStaffService;
import za.ac.cput.entity.UniversityStaff;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UniversityStaffService implements IUniversityStaffService {

    @Autowired
    private UniversityStaffRepository repository;

    @Override
    public UniversityStaff create(UniversityStaff universityStaff) {
        return this.repository.save(universityStaff);
    }

    @Override
    public UniversityStaff read(String staffID) {
        return this.repository.findById(staffID).orElse(null);
    }

    @Override
    public UniversityStaff update(UniversityStaff universityStaff) {
        return this.read(universityStaff.getStaffID()) != null ? repository.save(universityStaff) : null;
    }
    @Override
    public boolean delete(String staffID) {
        repository.deleteById(staffID);
        return this.read(staffID) == null ? true : false;
    }

    @Override
    public Set<UniversityStaff> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

}