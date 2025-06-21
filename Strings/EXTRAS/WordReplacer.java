import java.util.Scanner;

public class WordReplacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter replacement word: ");
        String newWord = sc.nextLine();
        String modified = sentence.replace(oldWord, newWord);
        System.out.println("Modified Sentence: " + modified);
    }
}
