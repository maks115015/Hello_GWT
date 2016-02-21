package client.binders;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public interface MainServiceView extends IsWidget {

    public interface Presenter {
        void goTo(Place place);
    }
    public void setPresenter(Presenter presenter);

}
