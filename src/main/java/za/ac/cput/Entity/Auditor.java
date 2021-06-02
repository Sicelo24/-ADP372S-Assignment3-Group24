package za.ac.cput.Entity;
/*
@Author : Lindokuhle Xaki 215041720
 Auditor class
date 1 June 2021
*/

public class Auditor {



    private String auditorID;
    private String auditorFirstName;
    private String auditorSurname;
    private String cellphone;



    private Auditor(Builder builder) {
        this.auditorID = builder.auditorID;
        this.auditorFirstName = builder.auditorFirstName;;
        this.auditorSurname = builder.auditorSurname;;
        this.cellphone = builder.cellphone;
    }

    public String getAuditorID() {
        return auditorID;
    }

    public String getAuditorFirstName() {
        return auditorFirstName;
    }

    public String getAuditorSurname() {
        return auditorSurname;
    }

    public String getCellphone() {
        return cellphone;
    }


    @Override
    public String toString() {
        return "Builder{" +
                "auditorID='" + auditorID + '\'' +
                ", auditorFirstName='" + auditorFirstName + '\'' +
                ", auditorSurname='" + auditorSurname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';

    }

    public static class Builder {

        private String auditorID;
        private String auditorFirstName;
        private String auditorSurname;
        private String cellphone;


        public Builder setAuditorID(String auditorID) {
            this.auditorID = auditorID;
            return this;
        }

        public Builder setAuditorFirstName(String auditorFirstName) {
            this.auditorFirstName = auditorFirstName;
            return this;
        }

        public Builder setAuditorSurname(String auditorSurname) {
            this.auditorSurname = auditorSurname;
            return this;
        }

        public Builder setCellphone(String cellphone) {
            this.cellphone = cellphone;
            return this;
        }

        public Auditor Build() {
            return new Auditor(this);
        }

        private Builder copy(Auditor auditor) {
            this.auditorID = auditor.auditorID;
            this.auditorFirstName = auditor.auditorFirstName;
            this.auditorSurname = auditor.auditorSurname;
            this.cellphone = auditor.cellphone;

            return this;

        }

        private String auditorID;
        private String auditorFirstName;
        private String auditorSurname;
        private String cellphone;


        private Auditor(Builder builder) {
            this.auditorID = builder.auditorID;
            this.auditorFirstName = builder.auditorFirstName;
            ;
            this.auditorSurname = builder.auditorSurname;
            ;
            this.cellphone = builder.cellphone;
        }

        public String getAuditorID() {
            return auditorID;
        }

        public String getAuditorFirstName() {
            return auditorFirstName;
        }

        public String getAuditorSurname() {
            return auditorSurname;
        }

        public String getCellphone() {
            return cellphone;
        }


        @Override
        public String toString() {
            return "Builder{" +
                    "auditorID='" + auditorID + '\'' +
                    ", auditorFirstName='" + auditorFirstName + '\'' +
                    ", auditorSurname='" + auditorSurname + '\'' +
                    ", cellphone='" + cellphone + '\'' +
                    '}';

        }

        public static class Builder {

            private String auditorID;
            private String auditorFirstName;
            private String auditorSurname;
            private String cellphone;


            public Builder setAuditorID(String auditorID) {
                this.auditorID = auditorID;
                return this;
            }

            public Builder setAuditorFirstName(String auditorFirstName) {
                this.auditorFirstName = auditorFirstName;
                return this;
            }

            public Builder setAuditorSurname(String auditorSurname) {
                this.auditorSurname = auditorSurname;
                return this;
            }

            public Builder setCellphone(String cellphone) {
                this.cellphone = cellphone;
                return this;
            }

            public Auditor Build() {
                return new Auditor(this);
            }

            private Builder copy(Auditor auditor) {
                this.auditorID = auditor.auditorID;
                this.auditorFirstName = auditor.auditorFirstName;
                this.auditorSurname = auditor.auditorSurname;
                this.cellphone = auditor.cellphone;

                return this;

            }}}}


