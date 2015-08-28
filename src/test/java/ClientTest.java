import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  
  @Rule
  public DatabaseRule database = new DatabaseRule();
  
  @Test
  public void all_emptyAtFirst() {
  assertEquals(Client.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfClientsAretheSame() {
    Client firstClient = new Client("Helen", 8675309, 1);
    Client secondClient = new Client("Helen", 8675309, 1);
    assertTrue(firstClient.equals(secondClient));
  }
}