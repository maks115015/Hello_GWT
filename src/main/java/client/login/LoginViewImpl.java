package client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class LoginViewImpl extends Composite implements LoginView {
    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

    /*
    * @UiTemplate is not mandatory but allows multiple XML templates
    * to be used for the same widget.
    * Default file loaded will be <class-name>.ui.xml
    */
    @UiTemplate("LoginViewImpl.ui.xml")
    interface LoginUiBinder extends UiBinder<Widget, LoginViewImpl> {
    }

    @UiField(provided = true)
    final LoginResources res;

    public LoginViewImpl() {
        this.res = GWT.create(LoginResources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    TextBox loginBox;
    @UiField
    TextBox passwordBox;
    @UiField
    Label completionLabel1;
    @UiField
    Label completionLabel2;
    @UiField
    Button buttonSubmit;

    private Boolean tooShort = false;

    /*
    * Method name is not relevant, the binding is done according to the class
    * of the parameter.
    */
    @UiHandler("buttonSubmit")
    void doClickSubmit(ClickEvent event) {
        if (tooShort) {
            Window.alert("LoginViewImpl or Password is too short!");
        } else {
           Window.alert("Submit!");
        }
    }

    @UiHandler("loginBox")
    void handleLoginChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 2) {
            completionLabel1.setText("LoginViewImpl too short (Size must be > 2)");
            tooShort = true;
        } else {
            tooShort = false;
            completionLabel1.setText("");
        }
    }
    @UiHandler("loginBox" )
    void handleLoginKeyboardKey(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            Window.alert("Sumbit by Enter!");
        }
    }
    @UiHandler("passwordBox" )
    void handlePasswordKeyboardKey(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            Window.alert("Sumbit by Enter!");
        }
    }

    @UiHandler("passwordBox")
    void handlePasswordChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 2) {
            tooShort = true;
            completionLabel2.setText("Password too short (Size must be > 2)");
        } else {
            tooShort = false;
            completionLabel2.setText("");
        }
    }

    @Override
    public HasText getUserInputBox() {
        return loginBox;
    }

    @Override
    public HasText getPassInputBox() {
        return passwordBox;
    }

    public Label getCompletionLabel1() {
        return completionLabel1;
    }
}