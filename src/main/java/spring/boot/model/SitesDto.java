package spring.boot.model;

import java.util.List;

/**
 * Created by alex on 30.03.17.
 */
public class SitesDto {

    private List<SiteDto> items;

    public SitesDto() {}

    public List<SiteDto> getItems() {
        return items;
    }

    public void setItems(List<SiteDto> items) {
        this.items = items;
    }
}
