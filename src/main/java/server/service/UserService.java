package server.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import server.entity.User;
import server.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.*;

/**
 * Created by maks(avto12@i.ua) on 06.02.2016.
 */
@Service("userService")
public class UserService implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(UserService.class);

    EntityManager manager = HibernateUtil.getEm();


    @Override
    public UserDetails loadUserByUsername(String login) throws NoResultException {
        logger.info("Username in userService layer is: {}", login);
        final User u =  (User)manager.createQuery("SELECT u FROM User u  WHERE u.login=?1").setParameter(1, login).getSingleResult();
        logger.info("User from BD is: {}", u.toString());
        if (u == null) {
            throw new UsernameNotFoundException("User " + login + " is not found");
        }
        return new UserDetails() {
            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return AuthorityUtils.createAuthorityList("ROLE_USER");
            }

            @Override
            public String getPassword() {
                return u.getPassword();
            }

            @Override
            public String getUsername() {
                return u.getName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

}
