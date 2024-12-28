// Word.java
import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Letter> letters = new ArrayList<>();

    /**
     * Конструктор, який розбиває слово на букви.
     * @param word Слово.
     */
    public Word(String word) {
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Отримати символ слова.
     * @return Символ.
     */
    public char getCharacter(int index) {
        if (index >= 0 && index < letters.size()) {
            return letters.get(index).getCharacter();
        }
        throw new IndexOutOfBoundsException("Індекс виходить за межі слова.");
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter());
        }
        return word.toString();
    }
}
