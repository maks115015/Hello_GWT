package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by maks(avto12@i.ua) on 10.02.2016.
 */
@RemoteServiceRelativePath("login")
public interface AuthRPCService extends RemoteService {
    void authentifiacate(String name, String Password);
}
