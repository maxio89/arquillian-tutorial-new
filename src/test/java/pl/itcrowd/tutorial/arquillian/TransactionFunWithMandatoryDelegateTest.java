package pl.itcrowd.tutorial.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.itcrowd.tutorial.arquillian.delegate.MandatoryDelegate;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRequiredException;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/7/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class TransactionFunWithMandatoryDelegateTest {

    @EJB
    private TransactionFun transactionFun;

    @Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(TransactionFun.class, TransactionDelegate.class, MandatoryDelegate.class);
    }

    @Test
    public void transactionRequired() {

        //Given

        //When
        transactionFun.transactionRequired();

        //Then

    }

    @Test(expected = EJBTransactionRequiredException.class)
    public void transactionNotSupported() {

        //Given

        //When
        transactionFun.transactionNotSupported();

        //Then

    }


}
