package spring.boot.persistence;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import spring.boot.model.Role;
import spring.boot.model.User;
import spring.boot.model.UserField;

import javax.annotation.PostConstruct;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by alex on 03.04.17.
 */
@Component
public class UserDao {

    @Autowired
    MongoTemplate mongoTemplate;



    public Optional<User> findByUsername(@NonNull String username) {
        return Optional.ofNullable
                (mongoTemplate.findOne
                        (Query.query(
                                where(UserField.USER_NAME.getField()).is(username)), User.class));
    }

    public void save(@NonNull User user) {
        mongoTemplate.save(user);
    }
}
