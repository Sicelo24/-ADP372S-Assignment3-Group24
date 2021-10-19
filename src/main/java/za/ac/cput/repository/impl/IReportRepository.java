package za.ac.cput.repository.impl;

/*
 Factory for Report
 Author: Mlungisi Xakekile (215126505)
 Date: 26 July 2021
*/

import za.ac.cput.entity.Report;
import za.ac.cput.repository.IRepository;

import java.util.Set;

@Deprecated
public interface IReportRepository extends IRepository<Report, Integer> {
    Set<Report> getAll();
}
