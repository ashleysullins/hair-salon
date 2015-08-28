import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
  
  @ClassRule
  public static DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Beauty School Digital Rolodex");
  }
  
  @Test
  public void stylistIsCreated() {
    Stylist myStylist = new Stylist ("Amy");
    myStylist.save();
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Amy");
  }
  
  @Test
  public void clientIsCreated() {
    Stylist myStylist = new Stylist ("Annie");
    myStylist.save();
    Client myClient = new Client ("Helen", 8675309, myStylist.getId());
    myClient.save();
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Helen");
    assertThat(pageSource()).contains("8675309");
    assertThat(pageSource()).contains("Annie");
  }
  
  @Test
  public void clientIsUpdated() {
    Stylist myStylist = new Stylist ("Annie");
    myStylist.save();
    Client myClient = new Client ("Helen", 8675309, myStylist.getId());
    myClient.save();
    myClient.update("Sara", 6488888, myStylist.getId());
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Sara");
    assertThat(pageSource()).contains("6488888");
  }
  
  @Test
  public void stylistIsUpdated() {
    Stylist myStylist = new Stylist ("Annie");
    myStylist.save();
    myStylist.update("Anna");
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Anna");
  }
  
}