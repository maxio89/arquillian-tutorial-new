package pl.itcrowd.tutorial.arquillian.jsf;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/20/13
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@SessionScoped
public class UserAuthenticator implements Serializable {

    private static final String SUCCESS_MESSAGE = "Welcome";
    private static final String FAILURE_MESSAGE = "Incorrect username or password";

    private User currentUser;

    @SuppressWarnings("UnusedDeclaration")
    @Inject
    private Credentials credentials;

    public String login() {
        if ("demo".equals(credentials.getUsername()) &&
                "demo".equals(credentials.getPassword())) {
            currentUser = new User("demo");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(SUCCESS_MESSAGE));
            return "home.xhtml";
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        FAILURE_MESSAGE, FAILURE_MESSAGE));
        return null;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    @Produces
    @Named
    public User getCurrentUser() {
        return currentUser;
    }

}
