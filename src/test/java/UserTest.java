import org.example.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user1= new User("user1");
    @Test
    public void testUser() {
        String expected = "user1";
        String actual = user1.getUserName();
        assertEquals(expected, actual);

    }
}
