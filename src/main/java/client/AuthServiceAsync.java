package client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AuthService</code>.
 */
public interface AuthServiceAsync {
	void retrieveUsername(AsyncCallback<String> callback);

	void retrieveAuthorities(AsyncCallback<String> async);

	void authentificated(AsyncCallback<Boolean> async);

	void retrievePartOfDay(AsyncCallback<String> async);
}
