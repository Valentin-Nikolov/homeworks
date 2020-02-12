package homework.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LanguageTranslator {

    private static final String template = "\"%s\" translated from %s to %s is: %s";
    RestTemplate restTemplate;

    @GetMapping("lang/translate")
    public String translate(@RequestParam(value = "word", defaultValue = "") String word,
                      @RequestParam(value = "from", defaultValue = "en") String from,
                      @RequestParam(value = "to", defaultValue = "fr") String to) throws JsonProcessingException {

        String serviceURL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20200212T130939Z.26c39e2369bba410.7444f73c98ab3db2e3c989ea550e7ac7d0d51eaa" +
                "&text=" + word + "&lang=" + from + "-" + to;

        restTemplate = new RestTemplate();
        String translatedResponse = restTemplate.getForObject(serviceURL, String.class);

        JsonNode translatedText = new ObjectMapper().readTree(translatedResponse);

        return String.format(template, word, from, to, translatedText);
    }
}
