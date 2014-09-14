package net.expensescalculator.util
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

@Service
class StringToDateTimeConverter implements Converter<String,DateTime> {
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/ss HH:mm");

    @Override
    DateTime convert(String source) {
        return formatter.parseDateTime(source)
    }
}
