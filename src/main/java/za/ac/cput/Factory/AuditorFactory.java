package za.ac.cput.Factory;

/*
        @Author : Lindokuhle Xaki 215041720
        Factory class
        date 4 June 2021

*/

import za.ac.cput.Entity.Auditor;
import za.ac.cput.Factory.AuditorFactory;


public class AuditorFactory {


    public static Auditor buildAuditor(String auditorID,
                                       String auditorFirstName,
                                       String auditorSurname,
                                       String cellphone)
    {

        return new Auditor.Builder()
                .auditorID(auditorID)
                .auditorFirstName(auditorFirstName)
                .auditorSurname(auditorSurname)
                .cellphone(cellphone)
                .Build();
    }
}