package net.expensescalculator.util
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class JacksonDateTimeSerializer extends JsonSerializer<DateTime>{
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm:ss dd.MM.yyyy");

    @Override
    void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(formatter.print(value))
    }
}
