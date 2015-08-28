import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  
  @Rule
  public DatabaseRule database = new DatabaseRule();
  
  @Test
  public void all_emptyAtFirst() {
  assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfStylistsAretheSame() {
    Stylist firstStylist = new Stylist("Amy");
    Stylist secondStylist = new Stylist("Amy");
    assertTrue(firstStylist.equals(secondStylist));
  }
  
  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Amy");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }
  
  @Test
  public void find_findsStylistInDatabase_true() {
    Stylist myStylist = new Stylist("Amy");
    myStylist.save();
    Stylist savedStylist = Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }
  
  @Test
  public void update_updateStylistInDatabase() {
    Stylist myStylist = new Stylist("Amy");
    myStylist.save();
    myStylist.update("Andrew");
    assertEquals("Andrew", Stylist.all().get(0).getName());
  }
  
  @Test
  public void delete_deleteStylistInDatabase() {
    Stylist myStylist = new Stylist("Amy");
    myStylist.save();
    myStylist.delete();
    assertEquals(Stylist.all().size(), 0);
  }
}