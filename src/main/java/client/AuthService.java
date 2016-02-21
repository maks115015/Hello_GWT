package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("rpc/auth")
public interface AuthService extends RemoteService {
	String retrievePartOfDay();

	String retrieveAuthorities();

	boolean authentificated();

	String retrieveUsername();
}
