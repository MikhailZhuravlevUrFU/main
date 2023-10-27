import org.example.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testCreateUserWithParameters() {
        User user = new User("testuser", "test@urfu.ru");
        assertNotNull(user);
    }

    @Test
    public void testCreateUserWithoutParameters() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void testSetInvalidEmail() {
        User user = new User();
        user.setEmail("invalidEmail");
        assertNull(user.getEmail());
    }

    @Test
    public void testSetShortLogin() {
        User user = new User();
        user.setLogin("bbb");
        assertNull(user.getLogin());
    }
}
