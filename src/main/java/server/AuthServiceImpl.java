package server;

import client.AuthService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import server.utils.TimeUtil;
import server.utils.TimeUtilImpl;

import java.time.LocalTime;
/**
 * Created by maks(avto12@i.ua) on 16.02.2016.
 */
@SuppressWarnings("serial")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

	static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    TimeUtil timeUtil=new TimeUtilImpl();

    @Override
    @Secured("ROLE_USER")
    public String retrievePartOfDay(){
        return timeUtil.getPartOfDay(LocalTime.now());
    }

    @Override
    public String retrieveAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().toString();
    }

	@Override
	public boolean authentificated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.warn("Roles is : {}", authentication.getAuthorities().toString());
        if (authentication.getName().equals("anonymousUser")){
            return false;}
        else return true;

	}

	@Override
    @Secured("ROLE_USER")
	public String retrieveUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.warn("authentificated user is : {}", authentication.getName());
        if (authentication.getName().equals("anonymousUser")) {
            return "Not logged in";
        } else {
            return authentication.getName();
        }

    }
}
