package client;

import client.binders.LoginView;
import client.binders.MainServiceView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public interface ClientFactory {
    EventBus getEventBus();
    PlaceController getPlaceController();
    LoginView getLoginView();
    MainServiceView getMainSeviceView();
}
