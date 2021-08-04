package za.ac.cput.repository.entity;

import za.ac.cput.entity.Auditor;
import za.ac.cput.repository.impl.IAuditorRepository;

import java.util.*;
import java.util.Set;

public class AuditorRepository implements IAuditorRepository {

    private static AuditorRepository repository = null;
    private Map<String, Auditor> auditors;

    private AuditorRepository(){

        this.auditors = new HashMap<>();
    }

    public static AuditorRepository getRepository(){
        if(repository == null) repository = new AuditorRepository();
        return repository;

    }

    @Override
    public Auditor create(Auditor auditor) {
        if(read(auditor.getAuditorID())  == null){
            this.auditors.put(auditor.getAuditorID(),auditor);
        }
        return auditor;
    }

    @Override
    public Auditor read(String s) {
        return this.auditors.get(s);
    }

    @Override
    public Auditor update(Auditor auditor) {
        if(read(auditor.getAuditorID()) != null){
            auditors.replace(auditor.getAuditorID(), auditor);
        }
        return auditor;
    }

    @Override
    public boolean delete(String s) {
        Auditor auditor = read(s);
        this.auditors.remove(s, auditor);
        if (s == null)
            return false;
        auditors.remove(s);

        return true;
}
    @Override
    public Set<Auditor> getAll() {
        Collection<Auditor> auditors = this.auditors.values();
        Set<Auditor> set = new HashSet<>();
        set.addAll(auditors);
        return set;
    }
}
