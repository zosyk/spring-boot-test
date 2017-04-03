package spring.boot.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by alex on 03.04.17.
 */
public enum Role implements GrantedAuthority {
    USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
