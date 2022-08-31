package TimeUtil;

import java.time.Duration;

public class TimeFormatter {
    public static String timeFormat(long milli) {
        Duration d = Duration.ofMillis(milli);
        return String.format("Time taken: %d min. %d sec. %d ms.",
                d.toMinutesPart(),
                d.toSecondsPart(),
                d.toMillisPart());
    }
}
