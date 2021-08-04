package za.ac.cput;

import org.springframework.boot.SpringApplication;
import za.ac.cput.controller.IssueController;

public class AuditApplication {
    public static void main(String[] args) {
        SpringApplication.run(IssueController.class,args);
    }
}
