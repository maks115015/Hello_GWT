package client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthRPCServiceAsync {
    void authentifiacate(String name, String Password, AsyncCallback<Void> async);
}
