package spring.boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by alex on 30.03.17.
 */

@Document

public class StackOverflowWebSite {

    @Id
    private String id;

    @Field
    private String website;
    private String iconImageUrl;
    private String title;
    private String description;

    public StackOverflowWebSite() {
    }

    public StackOverflowWebSite(String id, String website, String iconImageUrl, String title, String description) {
        this.id = id;
        this.website = website;
        this.iconImageUrl = iconImageUrl;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getWebsite() {
        return website;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
