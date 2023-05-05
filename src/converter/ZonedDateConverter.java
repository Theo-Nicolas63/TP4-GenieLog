package converter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.Instant;

public class ZonedDateConverter {

    public static ZonedDateTime DateToZonedDateTime(Date date, ZoneId zoneId) {

        if (date == null) {
            throw new IllegalArgumentException("Date ne peut pas être null");
        }

        Instant instant = date.toInstant();

        return ZonedDateTime.ofInstant(instant, zoneId);
    }
}