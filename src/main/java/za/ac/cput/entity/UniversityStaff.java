/* Assignment 3.java
 Entity for the UniversityStaff
 Author: Avuyile Xozumthi (218331827)
 Date: 01 june 2021
*/
package za.ac.cput.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UniversityStaff implements Serializable {
    @Id
    private String staffID;
    private String staffFirstName, staffSurname,cellphone;

    private UniversityStaff(){}

    private UniversityStaff(Builder builder){
        this.staffID=builder.staffID;
        this.staffFirstName=builder.staffFirstName;
        this.staffSurname=builder.staffSurname;
        this.cellphone=builder.cellphone;
    }

    public static class Builder{

        private String staffID, staffFirstName, staffSurname, cellphone;
        public Builder staffID(String staffID){
            this.staffID = staffID;
            return this;
        }
        public Builder staffFirstName(String staffFirstName){
            this.staffFirstName = staffFirstName;
            return this;
        }
        public Builder staffSurname(String staffSurname){
            this.staffSurname = staffSurname;
            return this;
        }
        public Builder cellphone(String cellphone){
            this.cellphone = cellphone;
            return this;
        }

        public Builder Copy(UniversityStaff UniversityStaff){
            this.staffID = UniversityStaff.staffID;
            this.staffFirstName = UniversityStaff.staffFirstName;
            this.staffSurname = UniversityStaff.staffSurname;
            this.cellphone = UniversityStaff.cellphone;
            return this;
        }

        public UniversityStaff Build(){
            return new UniversityStaff(this);
        }
    }
    public String getStaffID() {
        return staffID;
    }
    public String getStaffFirstName() {
        return staffFirstName;
    }
    public String getStaffSurname() {
        return staffSurname;
    }
    public String getCellphone() {
        return cellphone;
    }

    @Override
    public String toString()
    {
        return "Issue{" +
                "staffID='" + staffID + '\'' +
                ", staffFirstName='" + staffFirstName + '\'' +
                ", staffSurname='" + staffSurname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}

