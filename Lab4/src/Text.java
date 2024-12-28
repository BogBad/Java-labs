// Text.java
import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences = new ArrayList<>();

    /**
     * Конструктор, який розбиває текст на речення.
     * @param text Вхідний текст.
     */
    public Text(String text) {
        String[] sentenceArray = text.split("[.!?]");
        for (String sentence : sentenceArray) {
            String trimmedSentence = sentence.trim();
            if (!trimmedSentence.isEmpty()) {
                sentences.add(new Sentence(trimmedSentence));
            }
        }
    }

    /**
     * Отримати список речень.
     * @return Список речень.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }
}
