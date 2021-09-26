package za.ac.cput.service.impl;


import za.ac.cput.entity.Auditor;
import za.ac.cput.service.IService;
import java.util.Set;

public interface IAuditorService extends IService<Auditor, String> {
    public Set<Auditor> getAll();
    public Auditor getAuditorGivenFirstName(String auditorFirstName);


}
