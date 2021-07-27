package za.ac.cput.repository;

/*
 Factory for Report
 Author: Mlungisi Xakekile (215126505)
 Date: 26 July 2021
*/

import za.ac.cput.entity.Report;

import java.util.Set;

public interface IReportRepository extends IRepository<Report, Integer> {
    Set<Report> getAll();
}
