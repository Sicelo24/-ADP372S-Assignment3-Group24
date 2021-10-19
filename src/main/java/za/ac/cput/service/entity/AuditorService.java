package za.ac.cput.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Auditor;
import za.ac.cput.repository.impl.AuditorRepository;
import za.ac.cput.repository.impl.IAuditorRepository;
import za.ac.cput.service.IService;
import za.ac.cput.service.impl.IAuditorService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class AuditorService implements IAuditorService {

    private static AuditorService service = null;

    @Autowired
    private AuditorRepository repository;


    @Override
    public Auditor create(Auditor auditor) {
        return this.repository.save(auditor);
    }

    @Override
    public Auditor read(String auditorID) {
        return this.repository.findById(auditorID).orElse(null);
    }

    @Override
    public Auditor update(Auditor auditor) {
        if (this.repository.existsById(auditor.getAuditorID()))
        return repository.save(auditor);
        return null;
    }

    @Override
    public boolean delete(String auditorID) {
        this.repository.deleteById(auditorID);
        if (this.repository.existsById(auditorID))
            return false;
        else
            return true;
    }
    public Set<Auditor> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    public Set<Auditor> getAllAuditorsStartWithA(){
        Set<Auditor> auditorWithA = new HashSet<Auditor>();
        Set<Auditor> auditors = getAll();
        for(Auditor auditor: auditors){
            if(auditor.getAuditorID().trim().toLowerCase().startsWith("a")){
                auditorWithA.add(auditor);
            }
        }
        return auditorWithA;
    }

    public Auditor getAuditorGivenFirstName(String auditorFirstName){
        Auditor a = null;
        Set<Auditor> auditors = getAll();
        for(Auditor auditor: auditors){
            if(auditor.getAuditorFirstName().equals(auditorFirstName)){

                a = auditor;
                break;

            }
        }

        return a;
    }
}
