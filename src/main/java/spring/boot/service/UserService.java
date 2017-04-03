package spring.boot.service;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.boot.model.Role;
import spring.boot.model.User;
import spring.boot.persistence.UserDao;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by alex on 03.04.17.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @PostConstruct
    public void init() {

        userDao.findByUsername("user").ifPresent(user -> {
            user.setPassword(new BCryptPasswordEncoder().encode("password"));
            userDao.save(user);
        });

//        if(!userDao.findByUsername("user").isPresent()) {
//
//            User user = User.builder()
//                    .username("user")
//                    .password("user123")
//                    .authorities(ImmutableList.of(Role.USER))
//                    .accountNonExpired(true)
//                    .accountNonLocked(true)
//                    .credentialsNonExpired(true)
//                    .enabled(true)
//                    .build();
//
//            userDao.save(user);
//        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("could not found user"));

    }
}
