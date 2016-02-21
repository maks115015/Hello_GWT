package client.binders;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Created by maks(avto12@i.ua) on 21.02.2016.
 */
public interface StyleResources extends ClientBundle  {
    /**
     * Sample CssResource.
     */
    public interface MyCss extends CssResource {
        String blackText();

        String redText();

        String loginButton();

        String box();

        String background();
    }

    @Source("UiStyles.css")
    MyCss style();

}
