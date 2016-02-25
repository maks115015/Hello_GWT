package client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class AppActivityMapper implements ActivityMapper{
    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        Log.info("you go to "+place.toString());
        if (place instanceof HelloPlace)
            return new HelloActivity(clientFactory);
        else if (place instanceof MainPlace){
           return new MainActivity(clientFactory);
        }
        return null;
    }
}
