// Sentence.java
import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Object> elements = new ArrayList<>();

    /**
     * Конструктор, який розбиває речення на слова та пунктуаційні знаки.
     * @param sentence Речення.
     */
    public Sentence(String sentence) {
        String[] tokens = sentence.split(" ");
        for (String token : tokens) {
            if (token.matches("[a-zA-Zа-яА-Яіїєґ]+")) { // Додано підтримку українських літер
                elements.add(new Word(token));
            } else if (token.matches("[.,!?;]")) {
                elements.add(new Punctuation(token.charAt(0)));
            }
        }
    }

    /**
     * Отримати список елементів речення.
     * @return Список елементів.
     */
    public List<Object> getElements() {
        return elements;
    }

    /**
     * Отримати список слів у реченні.
     * @return Список слів.
     */
    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add(((Word) element).toString().toLowerCase()); // Ігнорування регістру
            }
        }
        return words;
    }
}
