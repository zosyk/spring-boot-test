package spring.boot.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.model.GeoPosition;
import spring.boot.model.StackOverflowWebSite;
import spring.boot.model.Suggestion;
import spring.boot.service.StackOverflowService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 30.03.17.
 */
@Controller
@RequestMapping("/api")
public class StackOverFlowController {

    @Autowired
    StackOverflowService stackOverflowService;

    @RequestMapping("/sites")
    public String helloWorld() {

        return "sites";
    }

    @RequestMapping("/stackoverflow")
    @ResponseBody
    public List<StackOverflowWebSite> getListOfProviders(/*HttpServletResponse response*/) {
//        response.addHeader("Access-Control-Allow-Origin", "*");

        return stackOverflowService.findAll();
    }

    @RequestMapping("/berlin")
    @ResponseBody
    public List<Suggestion> getSuggestion() {
        List<Suggestion> list = new ArrayList<>();
        list.add(Suggestion.builder()
                .id(376217)
                .key("ber-key")
                .name("Berlin")
                .fullName("Berlin, Germany")
                .iataAirportCode(null)
                .type("location")
                .country("Germany")
                .geoPosition(new GeoPosition(52.52437, 13.41053))
                .locationId(8384)
                .inEurope(true)
                .countryId(56)
                .countryCode("DE")
                .coreCountry(true)
                .distance(12538)
                .names(ImmutableMap.of("pt", "Berlim", "ru", "Берлин", "it", "Berlino"))
                .alternativeNames(ImmutableMap.of("is", "Berlín", "fi", "Berliini", "zh", "柏林"))
                .build());

        return list;
    }
}
