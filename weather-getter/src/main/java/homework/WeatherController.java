package homework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    WeatherService weatherService = new WeatherService();

    @GetMapping("weather/current")
    public JsonNode getCurrentWeatherByCity(@RequestParam(value = "location", defaultValue = "Sofia") String location) throws JsonProcessingException {
        return weatherService.getCurrentWeatherByCity(location);
    }

    @GetMapping("weather/forecast")
    public JsonNode getForecastWeather(@RequestParam(value = "location", defaultValue = "Sofia") String location) throws JsonProcessingException {
        return weatherService.getForecastWeatherByCity(location);
    }
}
