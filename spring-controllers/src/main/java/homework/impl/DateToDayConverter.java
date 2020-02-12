package homework.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class DateToDayConverter {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @GetMapping("date/day-of-week")
    public String getDayOfWeek(@RequestParam(value = "date", defaultValue = "01.01.1970") String date) {
        return LocalDate.parse(date, dtf).getDayOfWeek().toString();
    }
}
