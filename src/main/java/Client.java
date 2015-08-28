import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private int phone;
  private int stylist_id;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  public int getPhone() {
    return phone;
  }
  
  public int getStylist_Id() {
    return stylist_id;
  }

  public Client(String name, Integer phone, Integer stylist_id) {
    this.name = name;
    this.phone = phone;
    this.stylist_id = stylist_id;
  }

  public static List<Client> all() {
    String sql = "SELECT id, name, phone, stylist_id FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }
  
  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
        this.getPhone() == (newClient.getPhone()) &&
        this.getStylist_Id() == (newClient.getStylist_Id());
    }
  }
}