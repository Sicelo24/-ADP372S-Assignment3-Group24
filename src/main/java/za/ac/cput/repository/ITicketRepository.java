/* ITicketRepository.java Class
 * Author: Sicelo Zitha (216140943)
 * Date: 26 July 2021
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Ticket;
import java.util.Set;

public interface ITicketRepository extends IRepository<Ticket,String> {
    Set<Ticket> getAll();

}
