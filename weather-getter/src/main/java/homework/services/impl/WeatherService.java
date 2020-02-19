package homework.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework.services.WeatherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class WeatherService implements WeatherInterface {

    private static final String API_KEY = "b32bf897f5f3f1b59cf82c39584b817f";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    private String serviceURL;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Override
    public JsonNode getCurrentWeatherByCity(String location) throws JsonProcessingException {
        serviceURL = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;

        return objectMapper.readTree(Objects.requireNonNull(restTemplate.getForObject(serviceURL, String.class)));
    }

    @Override
    public JsonNode getForecastWeatherByCity(String location) throws JsonProcessingException {
        serviceURL = "http://api.openweathermap.org/data/2.5/forecast?q=" + location + "&appid=" + API_KEY;

        return objectMapper.readTree(Objects.requireNonNull(restTemplate.getForObject(serviceURL, String.class)));
    }
}
