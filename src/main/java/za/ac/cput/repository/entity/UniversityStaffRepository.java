package za.ac.cput.repository.entity;

import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.repository.impl.IUniversityStaffRepository;

import java.util.HashSet;
import java.util.Set;
@Deprecated
public class UniversityStaffRepository implements IUniversityStaffRepository {
    private static UniversityStaffRepository UniversityStaffRepository = null;
    private static za.ac.cput.repository.entity.UniversityStaffRepository repository;
    private Set<UniversityStaff> UniversityStaffDB;

    private UniversityStaffRepository() {
        UniversityStaffDB = new HashSet<>();
    }

    public static UniversityStaffRepository getRepository(){
        if(repository == null) repository = new UniversityStaffRepository();
        return repository;

    }
    public static UniversityStaffRepository createUniversityStaffRepository() {
        if (UniversityStaffRepository == null) UniversityStaffRepository = new UniversityStaffRepository();
        return UniversityStaffRepository;
    }
    @Override
    public Set<UniversityStaff> getAll() {
        return UniversityStaffDB;
    }

    @Override
    public UniversityStaff create(UniversityStaff universityStaff) {
        UniversityStaffDB.add(universityStaff);
        return universityStaff;
    }

    @Override
    public UniversityStaff read(String s) {
        for (UniversityStaff UniversityStaff : UniversityStaffDB) {
            return UniversityStaff;
        }
        return null;
    }
    @Override
    public UniversityStaff update(UniversityStaff UniversityStaff) {
        UniversityStaff r = create(UniversityStaff);
        if (r != null)
            this.UniversityStaffDB.remove(r);
        this.UniversityStaffDB.add(UniversityStaff);
        return UniversityStaff;
    }

    @Override
    public boolean delete(String s) {
        UniversityStaff universityStaff = read(s);
        if (universityStaff != null) {
            this.UniversityStaffDB.remove(universityStaff);
            return true;
        } else
            return false;
    }
}

