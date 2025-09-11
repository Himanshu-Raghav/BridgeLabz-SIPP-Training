import java.lang.reflect.*;

class Person {
    private int age;
}

public class BasicAccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.set(p, 25);

        System.out.println("Age via Reflection: " + field.get(p));
    }
}
