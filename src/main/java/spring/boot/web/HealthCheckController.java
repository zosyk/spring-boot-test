package spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.service.HealthService;

/**
 * Created by alex on 31.03.17.
 */
@RestController
public class HealthCheckController {

    @Autowired
    HealthService healthService;

    @Retryable(maxAttempts = 2, value = RuntimeException.class, backoff = @Backoff(delay = 2000, multiplier = 2))
    @RequestMapping("/checkHealth")
    public String checkStatus() {
        return healthService.getHealth();
    }

    @Recover
    public String recover() {
        return "not ok";
    }
}
