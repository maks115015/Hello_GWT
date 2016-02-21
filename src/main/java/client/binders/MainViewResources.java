package client.binders;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Created by maks(avto12@i.ua) on 21.02.2016.
 */
public interface MainViewResources extends ClientBundle{


    public interface MainViewCss extends CssResource {

    String messageLabels();

    String logoutAnchor();
    }

    @ClientBundle.Source("MainView.css")
    MainViewCss style();
}
