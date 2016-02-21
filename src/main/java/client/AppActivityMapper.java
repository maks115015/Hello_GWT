package client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class AppActivityMapper implements ActivityMapper{
    private ClientFactory clientFactory;
    private final AuthServiceAsync authService;
    private boolean auth;

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public AppActivityMapper(ClientFactory clientFactory,AuthServiceAsync authService) {
        super();
        this.clientFactory = clientFactory;
        this.authService=authService;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HelloPlace)
            return new HelloActivity(clientFactory);
        else if (place instanceof MainPlace){
           return new MainActivity(clientFactory);
        }
        return null;
    }
}
