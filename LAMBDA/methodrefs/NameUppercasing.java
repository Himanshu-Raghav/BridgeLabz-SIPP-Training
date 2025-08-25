import java.util.*;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}