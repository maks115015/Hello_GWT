package client.binders;

import client.AuthService;
import client.AuthServiceAsync;
import client.MainPlace;
import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
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
    TextBox userName;
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
            Log.info("try to login with username: " + userName.getText());
            loginForm.setMethod("POST");
            loginForm.setAction("/j_spring_security_check.action");
            loginForm.submit();
            loginForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
                @Override
                public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                    authService.authentificated(new AsyncCallback<Boolean>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            completionLabel1.setText("Server Error");
                            Log.error("Server Error: " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(Boolean result) {
                            if (result){
                                Log.warn("Login success - " + userName.getText());
                                presenter.goTo(new MainPlace());
                            }
                            else{
                                Log.info("Invalid credentials, username:" + userName.getText()+" password:"+password.getText());
                                completionLabel1.setText("Неправильные учетные данные");}
                        }
                    });
                }
            });
    }

    @UiHandler("userName")
    void handleLoginKeyboardKey(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            Log.info("Try to submit credentials by Enter");
            buttonSubmit.click();
        }
    }

    @UiHandler("password")
    void handlePasswordKeyboardKey(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            Log.info("Try to submit credentials by Enter");
            buttonSubmit.click();
        }
    }
}