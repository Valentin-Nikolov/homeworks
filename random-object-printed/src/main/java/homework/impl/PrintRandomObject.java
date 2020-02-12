package homework.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class PrintRandomObject {

    public static void main(String[] args) throws JsonProcessingException {
        //Here some random object sample
        RandomObj[] internalRandy = new RandomObj[1];
        internalRandy[0] = new RandomObj();
        internalRandy[0].setName("Internal Object");
        internalRandy[0].setArrInts(new int[] {1, 5});

        RandomObj randy = new RandomObj("Outer Object", 0.05, new int[] {3, 12, 57}, internalRandy);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(randy);

        System.out.print(json);
    }
}
