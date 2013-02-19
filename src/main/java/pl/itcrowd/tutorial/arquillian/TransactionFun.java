package pl.itcrowd.tutorial.arquillian;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/19/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class TransactionFun {

    @EJB
    private TransactionDelegate delegate;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void transactionNotSupported() {
        delegate.haveFun();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void transactionRequired() {
        delegate.haveFun();
    }
}
