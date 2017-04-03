package spring.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by alex on 30.03.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoPosition {

    private double latitude;
    private double longitude;
}
