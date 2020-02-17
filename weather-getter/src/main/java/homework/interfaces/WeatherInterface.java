package homework.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface WeatherInterface {

    public JsonNode getCurrentWeatherByCity(String location) throws JsonProcessingException;

    public JsonNode getForecastWeatherByCity(String location) throws JsonProcessingException;
}
