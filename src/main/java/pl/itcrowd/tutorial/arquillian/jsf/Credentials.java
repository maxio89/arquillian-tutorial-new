package pl.itcrowd.tutorial.arquillian.jsf;

import javax.enterprise.inject.Model;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/20/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Model
public class Credentials implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
