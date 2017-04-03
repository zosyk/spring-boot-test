package spring.boot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by alex on 31.03.17.
 */
@Service
public class HealthService {

    private RestTemplate restTemplate = new RestTemplate();

    public String getHealth() {
        String url = "http://localhost:8080/health";
        return restTemplate.getForObject(url, String.class);
    }
}
