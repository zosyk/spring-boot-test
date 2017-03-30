package spring.boot.web;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import spring.boot.Application;
import spring.boot.model.StackOverflowWebSite;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

/**
 * Created by alex on 30.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class StackOverFlowControllerIntegrationTest {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void before() {
        mongoTemplate.dropCollection(StackOverflowWebSite.class);
        mongoTemplate.save(new StackOverflowWebSite("stackoverflow", "http:stackoverflow.com", "http://duananhalotus.com/upload/album/0904234.jpg", "title1", "descr 1"));
        mongoTemplate.save(new StackOverflowWebSite("stackoverflow1", "http:stackoverflow.com", "http://duananhalotus.com/upload/album/0904234.jpg", "title2", "descr 2"));
    }

    @Test
    public void getListOfProviders() {

        ResponseEntity<List<StackOverflowWebSite>> responseEntity = restTemplate.exchange("http://localhost:8080/api/stackoverflow", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<StackOverflowWebSite>>() {
                });

        List<StackOverflowWebSite> actualList = responseEntity.getBody();

        assertThat(actualList.size(), is(2));

        ImmutableList<String> listIds = actualList.stream().map(stackOverflowWebSite -> stackOverflowWebSite.getId()).collect(collectingAndThen(toList(), ImmutableList::copyOf));

        assertThat(listIds, containsInAnyOrder("stackoverflow", "stackoverflow1"));
    }

}