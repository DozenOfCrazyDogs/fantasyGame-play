package controllers;

import models.Person;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Hello igor"));
    }

    public Result addPerson() {
        Person person = formFactory.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.HomeController.index());
    }

    public Result getPerson(Integer id) {
        Person person = Person.find.byId(id);
        return ok(toJson(person));
    }

    public Result getPersons() {
        List<Person> persons = Person.find.where().ilike("name", "%igor%").findPagedList(0, 10).getList();
        return ok(toJson(persons));
    }


}
