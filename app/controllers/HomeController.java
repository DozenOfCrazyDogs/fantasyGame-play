package controllers;

import controllers.dto.InboundAction;
import models.personages.Person;
import models.personages.enemies.EnemyFactory;
import models.personages.enemies.FireElemental;
import models.personages.heroes.Hero;
import models.personages.heroes.HeroFactory;
import play.cache.CacheApi;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.FightContext;
import services.TurnService;
import views.html.index;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    //todo covert to session cache
    @Inject
    private CacheApi cacheApi;
    @Inject
    private FormFactory formFactory;

    private TurnService turnService;

    public static final String fightStateKey = "fightState";

    @Inject
    public HomeController(TurnService turnService) {
        this.turnService = turnService;
    }

    public Result index() {
        return ok(index.render("Hello igor"));
    }


    public Result getPersons() {
        List<Person> persons = Person.find.where().ilike("name", "%igor%").findPagedList(0, 10).getList();
        return ok(toJson(persons));
    }

    public Result initGame() {
        Hero hero = HeroFactory.createGod("Igor");
        FireElemental fireElemental = EnemyFactory.createFireElemental();

        FightContext fightContext = new FightContext();
        fightContext.startFight(hero, fireElemental);
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
        turnService.doTurn(fightContext, inboundAction);
        cacheApi.set(fightStateKey, fightContext);
        return getCurrentState();
    }


}
