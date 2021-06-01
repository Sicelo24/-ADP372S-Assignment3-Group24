/* IssueFactory.java Class
 * Entity for Hiding Issue Implementation
 * Author: Athenkosi Zono (218030185)
 * Date: 1 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Issue;

public class IssueFactory {
    //String issueId, issueDescription, issueArea, issueRaisedDate, issueResolvedDate;
    // boolean issueStatus, isResolved, isValidated;
    public static Issue createIssue(String issueDescription, String issueArea, String issueRaisedDate,
                                    String issueResolvedDate, boolean issueStatus, boolean isResolved,
                                    boolean isValidated){

        Issue issue = new Issue.Builder().issueId("").issueDescription(issueDescription).issueArea(issueArea)
                .issueRaisedDate(issueRaisedDate).issueResolvedDate(issueResolvedDate).issueStatus(issueStatus)
                .isResolved(isResolved).isValidated(isValidated).Build();
        return issue;
    }
}
