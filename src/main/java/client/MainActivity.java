package client;

import client.binders.MainServiceView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class MainActivity extends AbstractActivity implements MainServiceView.Presenter {

    private ClientFactory clientFactory;


    public MainActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }


    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        MainServiceView mainServiceView = clientFactory.getMainSeviceView();
        mainServiceView.setPresenter(this);
        containerWidget.setWidget(mainServiceView.asWidget());
    }


    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
