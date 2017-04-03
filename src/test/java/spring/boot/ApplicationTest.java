package spring.boot;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

import static org.junit.Assert.*;

/**
 * Created by alex on 03.04.17.
 */
public class ApplicationTest {
    @Test
    public void configureGlobal() throws Exception {

        String auth = "dXNlcjpwYXNzd29yZA==";   // basic - identificator

        System.out.println(new String(Base64.getDecoder().decode(auth)).equals("user:password"));
        System.out.println(new BCryptPasswordEncoder().encode("password"));

    }

}