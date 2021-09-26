package za.ac.cput.factory;

import za.ac.cput.entity.UniversityStaff;

public class UniversityStaffFactory {

    public static UniversityStaff buildUniversityStaff(String staffID,
                                                       String staffFirstName,
                                                       String staffSurname,
                                                       String cellphone)
    {
        return new UniversityStaff.Builder()
                .setStaffID(staffID)
                .setstaffFirstName(staffFirstName)
                .setstaffSurname(staffSurname)
                .setcellphone(cellphone)
                .build();
    }
}
