package za.ac.cput.repository.impl;

import za.ac.cput.entity.UniversityStaff;

import java.util.Set;
@Deprecated

public interface IUniversityStaffRepository {
    Set<UniversityStaff> getAll();

    UniversityStaff create(UniversityStaff universityStaff);

    UniversityStaff read(String s);

    UniversityStaff update(UniversityStaff UniversityStaff);

    boolean delete(String s);
}
