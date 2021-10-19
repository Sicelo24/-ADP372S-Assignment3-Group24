package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Report;

@Repository
public interface ReportRepository  extends JpaRepository<Report, String> {
}
