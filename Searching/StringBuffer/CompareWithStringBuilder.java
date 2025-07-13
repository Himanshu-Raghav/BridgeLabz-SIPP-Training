
public class CompareWithStringBuilder {
    public static void main(String[] args) {
        int count = 1000000;
        long startTime, endTime;

        StringBuffer sbuff = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            sbuff.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        StringBuilder sbuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            sbuilder.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
    }
}
