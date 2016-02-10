package client.login;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Created by Nick on 06.11.2015.
 */
public interface LoginResources extends ClientBundle  {
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

    @Source("Login.css")
    MyCss style();

}
