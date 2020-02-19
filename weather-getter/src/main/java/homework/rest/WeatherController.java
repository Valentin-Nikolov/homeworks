package homework.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import homework.services.impl.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public JsonNode getCurrentWeatherByCity(@RequestParam(value = "location", defaultValue = "Sofia") String location) throws JsonProcessingException {
        return weatherService.getCurrentWeatherByCity(location);
    }


    @GetMapping("/forecast")
    public JsonNode getForecastWeather(@RequestParam(value = "location", defaultValue = "Sofia") String location) throws JsonProcessingException {
        return weatherService.getForecastWeatherByCity(location);
    }
}
