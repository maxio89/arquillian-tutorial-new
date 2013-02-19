package pl.itcrowd.tutorial.arquillian.delegate;

import pl.itcrowd.tutorial.arquillian.TransactionDelegate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/7/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class RequiredDelegate implements TransactionDelegate {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void haveFun() {

    }
}
