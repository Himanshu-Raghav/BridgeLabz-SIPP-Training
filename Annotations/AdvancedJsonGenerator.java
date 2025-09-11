import java.lang.reflect.*;

class Employee {
    String name = "Bob";
    int salary = 5000;
}

public class AdvancedJsonGenerator {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sb.append("\"").append(fields[i].getName()).append("\":\"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Employee emp = new Employee();
        System.out.println("JSON: " + toJson(emp));
    }
}
