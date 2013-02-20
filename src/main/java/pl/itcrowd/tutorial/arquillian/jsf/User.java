package pl.itcrowd.tutorial.arquillian.jsf;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/20/13
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String username;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
