package pl.itcrowd.tutorial.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/18/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Arquillian.class)
public class EchoTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(Echo.class);
    }

    @Test
    public void testEcho() {

        //Given
        final String message = "Jack";
        final Echo echo = new Echo();

        //When
        final String result = echo.echo(message);

        //Then
        assertEquals(message, result);

    }


}
