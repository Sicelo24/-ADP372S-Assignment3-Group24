package za.ac.cput.repository.impl;

import za.ac.cput.entity.Auditor;
import za.ac.cput.repository.IRepository;
import java.util.Set;

@Deprecated
public interface IAuditorRepository extends IRepository<Auditor,String> {

    Set<Auditor> getAll();

}
