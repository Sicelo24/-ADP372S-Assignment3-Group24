package za.ac.cput.service.impl;

/*
 Service for Report
 Author: Mlungisi Xakekile (215126505)
 Date:  02 August 2021
*/

import za.ac.cput.entity.Report;
import za.ac.cput.service.IService;
import java.util.Set;

public interface IReportService extends IService<Report, Integer> {
    Set<Report> getAll();
}
