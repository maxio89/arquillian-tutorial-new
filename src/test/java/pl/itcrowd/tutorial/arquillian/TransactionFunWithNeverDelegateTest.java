package pl.itcrowd.tutorial.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.itcrowd.tutorial.arquillian.delegate.NeverDelegate;

import javax.ejb.EJB;
import javax.ejb.EJBException;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/7/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class TransactionFunWithNeverDelegateTest {

    @EJB
    private TransactionFun transactionFun;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(TransactionFun.class, TransactionDelegate.class, NeverDelegate.class);
    }

    @Test(expected = EJBException.class)
    public void transactionRequired() {

        //Given

        //When
        transactionFun.transactionRequired();

        //Then

    }

    @Test
    public void transactionNotSupported() {

        //Given

        //When
        transactionFun.transactionNotSupported();

        //Then

    }


}
