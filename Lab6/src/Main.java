
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Main {
    public static void main(String[] args) {
        try {
            DoublyLinkedList<String> list1 = new DoublyLinkedList<>();
            list1.add("First");
            list1.add("Second");
            list1.add("Third");
            list1.printList();

            DoublyLinkedList<String> list2 = new DoublyLinkedList<>("Solo");
            list2.printList();

            Collection<String> collection = java.util.Arrays.asList("Apple", "Banana", "Cherry");
            DoublyLinkedList<String> list3 = new DoublyLinkedList<>(collection);
            list3.printList();

            System.out.println("Removed: " + list1.remove());
            list1.printList();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}