package spring_boot_and_java_erudio.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formattedGender;

        if ("Male".equalsIgnoreCase(gender) || "M".equalsIgnoreCase(gender)) {
            formattedGender = "M";
        } else if ("Female".equalsIgnoreCase(gender) || "F".equalsIgnoreCase(gender)) {
            formattedGender = "F";
        } else {
            formattedGender = gender;
        }

        jsonGenerator.writeString(formattedGender);
    }
}