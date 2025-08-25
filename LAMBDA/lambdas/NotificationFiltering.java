import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String toString() {
        return type + ": " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient needs immediate attention"),
            new Alert("Normal", "Daily health report available"),
            new Alert("Reminder", "Medicine time")
        );

        Predicate<Alert> criticalFilter = alert -> alert.type.equals("Critical");

        alerts.stream().filter(criticalFilter).forEach(System.out::println);
    }
}