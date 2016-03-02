package client.binders;

import client.AuthService;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import com.googlecode.gwt.test.Mock;
import com.googlecode.gwt.test.utils.events.Browser;
import org.junit.Test;
import org.mockito.Mockito;

import static com.googlecode.gwt.test.assertions.GwtAssertions.assertThat;

/**
 * Created by maks(avto12@i.ua) on 02.03.2016.
 */
@GwtModule("HelloGWT")
public class bindersTest extends GwtTestWithMockito {

    @Mock
    private AuthService authService;

    @Test
    public void shouldGoToMainPage(){
        LoginViewImpl loginView=new LoginViewImpl();
        MainServiceViewImpl mainServiceView=new MainServiceViewImpl();

        Mockito.when(authService.authentificated()).thenReturn(true);
        Mockito.when(authService.retrievePartOfDay()).thenReturn("day");
        Mockito.when(authService.retrieveUsername()).thenReturn("Ivan");

        Browser.click(loginView.buttonSubmit);


        assertThat(mainServiceView).isAttached();
    }
}
