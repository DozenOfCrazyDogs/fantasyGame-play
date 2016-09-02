package configurations;

import com.google.inject.AbstractModule;
import services.TurnService;
import services.TurnServiceImpl;

/**
 * Created by Igor on 03.09.2016.
 */
public class GuiceBindings extends AbstractModule {
    @Override
    protected void configure() {
        bind(TurnService.class).to(TurnServiceImpl.class);
    }
}
