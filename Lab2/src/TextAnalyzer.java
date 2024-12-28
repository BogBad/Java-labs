import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextAnalyzer {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введіть текст:");
            String inputText = scanner.nextLine();

            String result = findUniqueWord(inputText);
            if (result != null) {
                System.out.println("Перше слово, якого немає в наступних реченнях: " + result.toLowerCase());
            } else {
                System.out.println("Не знайдено слова, яке було б лише у першому реченні.");
            }
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private String findUniqueWord(String text) {
        String[] sentences = text.split("[.!?]\\s*");
        if (sentences.length < 2) {
            return null;
        }

        String[] firstSentenceWords = sentences[0].split("\\s+");

        Set<String> remainingWords = new HashSet<>();
        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");
            for (String word : words) {
                String cleanedWord = word.replaceAll("[^a-zA-Zа-яА-Яіїєґ']", "").toLowerCase();
                if (!cleanedWord.isEmpty()) {
                    remainingWords.add(cleanedWord);
                }
            }
        }


        for (String word : firstSentenceWords) {

            String cleanedWord = word.replaceAll("[^a-zA-Zа-яА-Яіїєґ']", "").toLowerCase();
            if (!cleanedWord.isEmpty() && !remainingWords.contains(cleanedWord)) {
                return cleanedWord;
            }
        }

        return null;
    }
}
