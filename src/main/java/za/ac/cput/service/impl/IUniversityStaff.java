package za.ac.cput.service.impl;

import za.ac.cput.entity.UniversityStaff;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IUniversityStaff extends IService<UniversityStaff, String>{
    Set<UniversityStaff> getAll();
}
