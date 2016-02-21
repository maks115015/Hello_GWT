package client.binders;


import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created for JavaStudy.ru on 21.11.2015.
 */
public interface LoginView extends IsWidget{

    public interface Presenter {
        void goTo(Place place);
    }

    public void setPresenter(Presenter presenter);
}
