package client;

import client.binders.LoginView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class HelloActivity extends AbstractActivity implements LoginView.Presenter {
    // Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN
    private ClientFactory clientFactory;


    public HelloActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        LoginView loginView = clientFactory.getLoginView();
        loginView.setPresenter(this);
        containerWidget.setWidget(loginView.asWidget());
    }

    /**
     * Ask user before stopping this activity
     */
    /*@Override
    public String mayStop() {
        return "Please hold on. This activity is stopping.";
    }*/

    /**
     * Navigate to a new Place in the browser
     */
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}

