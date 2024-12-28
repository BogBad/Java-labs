// TextAnalyzer.java
import java.util.List;
import java.util.Scanner;

public class TextAnalyzer {

    /**
     * Метод для запуску аналізу тексту.
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введіть текст:");
            String inputText = scanner.nextLine();

            String cleanedText = cleanText(inputText);
            String uniqueWord = findUniqueWordInFirstSentence(cleanedText);

            if (uniqueWord != null) {
                System.out.println("Перше слово, якого немає в наступних реченнях: " + uniqueWord);
            } else {
                System.out.println("Не знайдено слова, яке було б лише у першому реченні.");
            }
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Метод для очищення пробілів і табуляцій у тексті.
     * @param text Вхідний текст.
     * @return Очищений текст.
     */
    private String cleanText(String text) {
        return text.replaceAll("[\\t\\s]+", " ").trim();
    }

    /**
     * Метод для пошуку слова в першому реченні, яке не зустрічається в наступних.
     * @param text Очищений текст.
     * @return Перше таке слово або null, якщо не знайдено.
     */
    private String findUniqueWordInFirstSentence(String text) {
        Text parsedText = new Text(text);
        List<Sentence> sentences = parsedText.getSentences();

        if (sentences.isEmpty()) {
            return null;
        }

        Sentence firstSentence = sentences.get(0);
        List<String> firstSentenceWords = extractWords(firstSentence);

        for (String word : firstSentenceWords) {
            boolean isUnique = true;
            for (int i = 1; i < sentences.size(); i++) {
                Sentence currentSentence = sentences.get(i);
                List<String> currentSentenceWords = extractWords(currentSentence);
                if (currentSentenceWords.contains(word)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return word;
            }
        }
        return null; // Якщо не знайдено
    }

    /**
     * Метод для екстракції слів з речення.
     * @param sentence Речення.
     * @return Список слів.
     */
    private List<String> extractWords(Sentence sentence) {
        return sentence.getWords();
    }
}
