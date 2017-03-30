package spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.model.StackOverflowWebSite;
import spring.boot.persistence.StackOverFlowSiteRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 30.03.17.
 */
@Service
public class StackOverflowService {

    @Autowired
    private StackOverFlowSiteRepository repository;

    private static List<StackOverflowWebSite> items = new ArrayList<>();

    static {
        items.add(new StackOverflowWebSite("stackoverflow", "http:stackoverflow.com", "http://duananhalotus.com/upload/album/0904234.jpg", "title1", "descr 1"));
        items.add(new StackOverflowWebSite("stackoverflow1", "http:stackoverflow.com", "http://duananhalotus.com/upload/album/0904234.jpg", "title2", "descr 2"));
    }

    public List<StackOverflowWebSite> findAll() {

        return repository.findAll();
    }

//    @PostConstruct
//    private void init() {
//        repository.save(items);
//    }
}
