package client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class MainPlace extends Place {
    private String token="main";

    public String getToken() {
        return token;
    }

    public MainPlace() {
    }

    @Prefix("MainPlace")
    public static class Tokenizer implements PlaceTokenizer<MainPlace> {
        @Override
        public String getToken(MainPlace place) {
            return place.getToken();
        }

        @Override
        public MainPlace getPlace(String token) {
            return new MainPlace();
        }
    }
}
