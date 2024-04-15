import org.example.Message;
import org.example.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    ArrayList<User> recipients = new ArrayList<>();
    @Test
    public void testGetSender() {
        recipients.add(new User("someone") );
        Message m1 = new Message(new User("user1"), recipients, "12:00:00", "This is a test message");

        String expected = "user1";
        String actual = m1.getSender().getUserName();
        assertEquals(expected, actual);

    }

    @Test
    public void testGetRecipients() {
        recipients.add(new User("someone") );
        Message m1 = new Message(new User("user1"), recipients, "12:00:00", "This is a test message");

        String expected = "someone";
        String actual = m1.getRecipients().get(0).getUserName();
        assertEquals(expected, actual);

    }

    @Test
    public void testFormattedMessage() {
        recipients.add(new User("someone") );
        Message m1 = new Message(new User("user1"), recipients, "12:00:00", "This is a test message");

        String expected = "<user1>\t[12:00:00]\tThis is a test message";
        String actual = m1.getFormattedMessage();
        assertEquals(expected, actual);

    }
}
