package spring.boot.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.boot.model.StackOverflowWebSite;

import java.util.List;

/**
 * Created by alex on 30.03.17.
 */
@Repository
public interface StackOverFlowSiteRepository extends MongoRepository<StackOverflowWebSite, String> {

    List<StackOverflowWebSite> findByWebsite(String website);

}
