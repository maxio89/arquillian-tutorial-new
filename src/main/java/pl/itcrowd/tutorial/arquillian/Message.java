package pl.itcrowd.tutorial.arquillian;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/19/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @SequenceGenerator(name = "MESSAGE_ID_SEQUENCE", sequenceName = "MESSAGE_ID_SEQUENCE", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_ID_SEQUENCE")
    private Long id;

    @Column(name = "TEXT")
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
