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
  
  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Helen", 8675309, 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }
  
  @Test
  public void find_findsClientInDatabase_true() {
    Client myClient = new Client("Helen", 8675309, 1);
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertTrue(myClient.equals(savedClient));
  }
  
  @Test
  public void update_updateClientInDatabase() {
    Client myClient = new Client("Helen", 8675309, 1);
    myClient.save();
    myClient.update("Megan", 6488888, 2);
    assertEquals("Megan", Client.all().get(0).getName());
  }
  
  @Test
  public void delete_deleteClientInDatabase() {
    Client myClient = new Client("Helen", 8675309, 1);
    myClient.save();
    myClient.delete();
    assertEquals(Client.all().size(), 0);
  }
}