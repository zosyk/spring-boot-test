package spring.boot.service;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.model.SiteDto;
import spring.boot.model.StackOverflowWebSite;
import spring.boot.persistence.StackOverFlowSiteRepository;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by alex on 30.03.17.
 */
@Service
public class StackOverflowService {

    @Autowired
    private StackOverFlowSiteRepository repository;

    @Autowired
    private StackExchangeClient stackExchangeClient;


    public List<StackOverflowWebSite> findAll() {
        return stackExchangeClient.getSites().stream()
                .map(this::toStackOverflowWebSite)
                .filter(this::ignoreMeta)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(@NotNull StackOverflowWebSite stackOverflowWebSite) {
        return !stackOverflowWebSite.getId().contains("meta");
    }

    private StackOverflowWebSite toStackOverflowWebSite(SiteDto input) {

        return new StackOverflowWebSite(input.getSite_url().substring("http://".length(), input.getSite_url().length() - ".com".length()),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());

    }

//    public List<StackOverflowWebSite> findAll() {
//        return repository.findAll();
//    }

}
