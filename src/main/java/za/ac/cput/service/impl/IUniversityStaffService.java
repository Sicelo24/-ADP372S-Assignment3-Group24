package za.ac.cput.service.impl;

import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IUniversityStaffService extends IService<UniversityStaff, String>{
    Set<UniversityStaff> getAll();
}
