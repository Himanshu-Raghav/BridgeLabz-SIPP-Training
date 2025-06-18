public class NullPointerDemo {
    
    public static void generateNullPointer() {
        String text = null;
        
        System.out.println(text.length());
<<<<<<< HEAD:Strings /Strings/NullPointerDemo.java
    }   
=======
    }

   
>>>>>>> 3432d985465bb1a35e973a31f226f071c2136dc4:Strings/NullPointer.java
    public static void handleNullPointer() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
<<<<<<< HEAD:Strings /Strings/NullPointerDemo.java
=======
      
>>>>>>> 3432d985465bb1a35e973a31f226f071c2136dc4:Strings/NullPointer.java
        System.out.println("Demonstrating NullPointerException handling:");
        handleNullPointer();
    }
}
