package client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
@WithTokenizers({HelloPlace.Tokenizer.class, MainPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
