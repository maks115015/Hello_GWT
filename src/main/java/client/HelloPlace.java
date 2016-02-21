package client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class HelloPlace extends Place {
    private String token ="login";

    public HelloPlace() {
    }

    public String getToken() {
        return token;
    }

    public static class Tokenizer implements PlaceTokenizer<HelloPlace> {
        @Override
        public String getToken(HelloPlace place) {
            return place.getToken();
        }

        @Override
        public HelloPlace getPlace(String token) {
            return new HelloPlace();
        }
    }
}
