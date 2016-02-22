package client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
public interface AuthServiceAsync {
	void retrieveUsername(AsyncCallback<String> callback);

	void retrieveAuthorities(AsyncCallback<String> async);

	void authentificated(AsyncCallback<Boolean> async);

	void retrievePartOfDay(AsyncCallback<String> async);
}
