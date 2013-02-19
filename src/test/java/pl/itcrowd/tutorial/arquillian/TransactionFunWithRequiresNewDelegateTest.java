package pl.itcrowd.tutorial.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.itcrowd.tutorial.arquillian.delegate.RequiresNewDelegate;

import javax.ejb.EJB;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/7/13
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Arquillian.class)
public class TransactionFunWithRequiresNewDelegateTest {

    @EJB
    private TransactionFun transactionFun;

    //    @Deployment(name = "")
    @Deployment()
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(TransactionFun.class, TransactionDelegate.class, RequiresNewDelegate.class);
    }

    //    @OperateOnDeployment()
    @Test
    public void transactionRequired() {

        //Given

        //When
        transactionFun.transactionRequired();

        //Then

    }

    @Test()
    public void transactionNotSupported() {

        //Given

        //When
        transactionFun.transactionNotSupported();

        //Then

    }


}
