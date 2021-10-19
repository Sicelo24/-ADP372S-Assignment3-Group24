/* ITicketRepository.java Class
 * Author: Sicelo Zitha (216140943)
 * Date: 26 July 2021
 */
package za.ac.cput.repository.impl;

import za.ac.cput.entity.Ticket;
import za.ac.cput.repository.IRepository;
import java.util.Set;

@Deprecated
public interface ITicketRepository extends IRepository<Ticket,String> {
    Set<Ticket> getAll();

}
