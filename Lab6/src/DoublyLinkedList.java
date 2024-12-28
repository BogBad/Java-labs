import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Клас для опису елемента двозв'язного списку.
 * @param <T> Тип елемента.
 */
class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Інтерфейс для операцій з колекцією.
 * @param <T> Тип елемента.
 */
interface ListOperations<T> {
    void add(T element);
    T remove();
    boolean isEmpty();
    int size();
    Iterator<T> iterator();
}


/**
 * Реалізація двозв'язного списку.
 * @param <T> Тип елемента.
 */
public class DoublyLinkedList<T> implements ListOperations<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Порожній конструктор
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Конструктор, в який передається 1 об'єкт типу T
    public DoublyLinkedList(T firstElement) {
        Node<T> newNode = new Node<>(firstElement);
        this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }

    // Конструктор, в який передається стандартна колекція
    public DoublyLinkedList(Collection<T> collection) {
        for (T element : collection) {
            add(element);
        }
    }

    /**
     * Додає елемент в кінець списку.
     * @param element елемент, який потрібно додати.
     */
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Видаляє елемент з початку списку та повертає його.
     * @return елемент, який був видалений.
     * @throws NoSuchElementException якщо список порожній.
     */
    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список порожній.");
        }

        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // Якщо список став порожнім
        }
        size--;
        return data;
    }

    /**
     * Перевіряє, чи список порожній.
     * @return true, якщо список порожній, false - якщо ні.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Повертає кількість елементів у списку.
     * @return кількість елементів.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Повертає ітератор для проходження по елементах списку.
     * @return ітератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    /**
     * Виводить вміст списку.
     */
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
