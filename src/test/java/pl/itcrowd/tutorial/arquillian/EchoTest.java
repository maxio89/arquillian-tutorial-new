package pl.itcrowd.tutorial.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/18/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Arquillian.class)
public class EchoTest {

    @Inject
    private Echo echo;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(Echo.class, Message.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

    }

    @ShouldMatchDataSet(excludeColumns = "id")
    @UsingDataSet
    @Test
    public void testEcho() {

        //Given
        final String message = "Jack";

        //When
        echo.echo(message);

        //Then

    }

}
