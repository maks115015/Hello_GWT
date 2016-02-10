package server;

import client.AuthRPCService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import server.exceptions.ClientSideBadCredentialsException;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by maks(avto12@i.ua) on 10.02.2016.
 */
public class AuthRPCServiceImpl extends RemoteServiceServlet implements AuthRPCService {
    @Inject
    DaoAuthenticationProvider daoAuthenticationProvider;


    @Override
    public void authentifiacate(String name, String password) {
        User user = new User(name, password, true, true, true, true, new ArrayList<GrantedAuthority>());
        Authentication auth = new UsernamePasswordAuthenticationToken(user, password,
                new ArrayList<GrantedAuthority>());
        try {
            auth = this.daoAuthenticationProvider.authenticate(auth);
        } catch (BadCredentialsException e) {
            throw new ClientSideBadCredentialsException(e.getMessage());
        }
        SecurityContext sc = new SecurityContextImpl();
        sc.setAuthentication(auth);

        SecurityContextHolder.setContext(sc);
    }
}
