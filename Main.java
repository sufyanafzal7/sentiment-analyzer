import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine().toLowerCase();

        if (input.contains("good") || input.contains("happy") || input.contains("great")) {
            System.out.println("Sentiment: Positive");
        } else if (input.contains("bad") || input.contains("sad") || input.contains("terrible")) {
            System.out.println("Sentiment: Negative");
        } else {
            System.out.println("Sentiment: Neutral");
        }
    }
}
