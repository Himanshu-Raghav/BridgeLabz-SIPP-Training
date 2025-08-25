import java.util.function.Consumer;

public class SmartHomeLighting {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = (location) -> System.out.println("Lights ON in " + location + " due to motion");
        Consumer<String> timeTrigger = (time) -> System.out.println("Lights set to warm mode at " + time);
        Consumer<String> voiceTrigger = (command) -> System.out.println("Executing light command: " + command);

        motionTrigger.accept("Living Room");
        timeTrigger.accept("7:00 PM");
        voiceTrigger.accept("Turn off bedroom lights");
    }
}