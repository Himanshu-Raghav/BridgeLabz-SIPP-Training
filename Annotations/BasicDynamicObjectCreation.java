import java.lang.reflect.*;

class Student {
    String name;
    Student() {}
}

public class BasicDynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Student.class;
        Object obj = cls.getDeclaredConstructor().newInstance();
        System.out.println("Object created dynamically: " + obj.getClass().getName());
    }
}
