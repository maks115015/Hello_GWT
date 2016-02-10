package server.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import server.entity.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by maks(avto12@i.ua) on 06.02.2016.
 */
@Service("userService")
public class UserService implements UserDetailsService {

    EntityManager manager = HibernateUtil.getEm();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u =  (User)manager.createQuery("SELECT u FROM User u  WHERE u.name=?1").setParameter(1, username).getSingleResult();
        ArrayList<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (u == null) {
            throw new UsernameNotFoundException("User " + username + " is not found");
        }
        return new UserDetails() {
            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return authorities;
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
