import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");
      
      // String sName = request.queryParams("stylistName");
      // Stylist newStylist = new Stylist(sname);
      
      String name = request.queryParams("clientName");
      int phone = Integer.parseInt(request.queryParams("clientPhone"));
      int stylist_id = Integer.parseInt(request.queryParams("stylistid"));
      Client newClient = new Client(name, phone, stylist_id);
      newClient.save();
      
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/new-client", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/new-client.vtl");
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/new-stylist", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/new-stylist.vtl");
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    get("/edit-client", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-client.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/edit-client-success", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-client-success.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}