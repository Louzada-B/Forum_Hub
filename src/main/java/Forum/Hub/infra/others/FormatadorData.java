package Forum.Hub.infra.others;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatadorData {
    public static String formatarData(LocalDateTime data) {
        var padrao = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", new Locale("pt", "BR"));
        return data.format(padrao);
    }
}
