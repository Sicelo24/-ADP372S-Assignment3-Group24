package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Auditor;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, String> {

}
