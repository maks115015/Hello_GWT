package client.binders;

import client.AuthService;
import client.AuthServiceAsync;
import client.i18n.MyMessage;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public class MainServiceViewImpl extends Composite implements MainServiceView{

    @UiTemplate("MainServiceViewImpl.ui.xml")
    interface MainServiceUiBinder extends UiBinder<Widget, MainServiceViewImpl> {
    }

    private MyMessage myMessage=GWT.create(MyMessage.class);

    private static MainServiceUiBinder ourUiBinder = GWT.create(MainServiceUiBinder.class);
    private final AuthServiceAsync authService = GWT
            .create(AuthService.class);

    private Presenter presenter;

    @UiField(provided = true)
    final MainViewResources res;


    public MainServiceViewImpl() {
        this.res = GWT.create(MainViewResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));

    }



    @UiField
    HTMLPanel mainPanel;

    @UiField
    Label userName;

    @UiField
    Label partOfDay;

    @UiField
    Anchor logout;

    @UiHandler("mainPanel")
    void onAttach(AttachEvent event){
        authService.retrievePartOfDay(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                partOfDay.setText("Error");
            }

            @Override
            public void onSuccess(String result) {
                partOfDay.setText(myMessage.getString(result));
            }
        });
        authService.retrieveUsername(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                    userName.setText(caught.getMessage());
            }

            @Override
            public void onSuccess(String result) {
                userName.setText(result+".");
            }
        });

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}