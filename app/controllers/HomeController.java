package controllers;

import controllers.dto.InboundAction;
import models.personages.Person;
import models.personages.enemies.FireElemental;
import models.personages.heroes.Warrior;
import play.cache.CacheApi;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.FightContext;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    @Inject
    private CacheApi cacheApi;
    @Inject
    private FormFactory formFactory;

    public static final String fightStateKey = "fightState";


    public Result getPersons() {
        List<Person> persons = Person.find.where().ilike("name", "%igor%").findPagedList(0, 10).getList();
        return ok(toJson(persons));
    }

    public Result initGame() {
        Warrior warrior = Warrior.createWarrior("Igor");
        FireElemental fireElemental = FireElemental.createFireElemental();

        FightContext fightContext = new FightContext();
        fightContext.setupPersonages(warrior,fireElemental);
        fightContext.setupFullHealthMana();
        cacheApi.set(fightStateKey, fightContext);
        return getCurrentState();
    }

    public Result getCurrentState() {
        return ok(toJson(cacheApi.get(fightStateKey)));
    }

    public Result heroTurn() {
        InboundAction inboundAction = formFactory.form(InboundAction.class).bindFromRequest().get();
        FightContext fightContext = cacheApi.get(fightStateKey);
        fightContext.doTurn(inboundAction);
        cacheApi.set(fightStateKey, fightContext);
        return getCurrentState();
    }


}
