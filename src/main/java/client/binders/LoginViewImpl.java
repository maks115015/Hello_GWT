package client.binders;

import client.AuthService;
import client.AuthServiceAsync;
import client.MainPlace;
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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class LoginViewImpl extends Composite implements LoginView {
    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);


    @UiTemplate("LoginViewImpl.ui.xml")
    interface LoginUiBinder extends UiBinder<Widget, LoginViewImpl> {
    }

    @UiField(provided = true)
    final StyleResources res;

    private final AuthServiceAsync authService = GWT
            .create(AuthService.class);


    public LoginViewImpl() {
        this.res = GWT.create(StyleResources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }


    @UiField
    FormPanel loginForm;
    @UiField
    TextBox password;
    @UiField
    TextBox useName;
    @UiField
    Label completionLabel1;
    @UiField
    Label completionLabel2;
    @UiField
    Button buttonSubmit;

    private Presenter presenter;

    private Boolean tooShort = false;



    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("buttonSubmit")
    void doClickSubmit(ClickEvent event) {
        if (tooShort) {
            Window.alert("Login or Password is too short!");
        } else {
            loginForm.setMethod("POST");
            loginForm.setAction("/hellogwt/j_spring_security_check.action");
            loginForm.submit();
            loginForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
                @Override
                public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                    authService.authentificated(new AsyncCallback<Boolean>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            completionLabel1.setText("System Error");
                        }

                        @Override
                        public void onSuccess(Boolean result) {
                            if (result) presenter.goTo(new MainPlace());
                            else completionLabel1.setText("Неправильные учетные данные");
                        }
                    });
                }
            });
        }
    }

    @UiHandler("useName")
    void handleLoginChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 2) {
            completionLabel1.setText("Login too short (Size must be > 2)");
            tooShort = true;
        } else {
            tooShort = false;
            completionLabel1.setText("");
        }
    }
    @UiHandler("useName")
    void handleLoginKeyboardKey(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            Window.alert("Sumbit by Enter!");
        }
    }
    @UiHandler("password")
    void handlePasswordKeyboardKey(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            Window.alert("Sumbit by Enter!");
        }
    }

    @UiHandler("password")
    void handlePasswordChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 2) {
            tooShort = true;
            completionLabel2.setText("Password too short (Size must be > 2)");
        } else {
            tooShort = false;
            completionLabel2.setText("");
        }
    }

}