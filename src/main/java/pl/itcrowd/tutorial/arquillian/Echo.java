package pl.itcrowd.tutorial.arquillian;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/18/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class Echo {

    @PersistenceContext
    private EntityManager entityManager;

    public void echo(String message) {
        entityManager.persist(new Message(message));
    }
}
