package homework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_KEY = "b32bf897f5f3f1b59cf82c39584b817f";
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private String serviceURL;

    public JsonNode getCurrentWeatherByCity(String location) throws JsonProcessingException {
        serviceURL = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;

        return objectMapper.readTree(restTemplate.getForObject(serviceURL, String.class));
    }

    public JsonNode getForecastWeatherByCity(String location) throws JsonProcessingException {
        serviceURL = "http://api.openweathermap.org/data/2.5/forecast?q=" + location + "&appid=" + API_KEY;

        return objectMapper.readTree(restTemplate.getForObject(serviceURL, String.class));
    }
}
