package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
@RemoteServiceRelativePath("rpc/auth")
public interface AuthService extends RemoteService {
	String retrievePartOfDay();

	boolean authentificated();

	String retrieveUsername();
}
