package client;

import client.binders.LoginView;
import client.binders.LoginViewImpl;
import client.binders.MainServiceView;
import client.binders.MainServiceViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;


/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class ClientFactoryImpl implements ClientFactory {

    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final LoginViewImpl loginView = new LoginViewImpl();
    private final MainServiceViewImpl mainServiceView = new MainServiceViewImpl();


    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public LoginView getLoginView() {
        return loginView;
    }

    @Override
    public MainServiceView getMainSeviceView() {
        return mainServiceView;
    }
}
