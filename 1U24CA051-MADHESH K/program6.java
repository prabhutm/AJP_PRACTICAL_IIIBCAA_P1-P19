// Practical 6: Revised linked list - copy of a list in reverse order
import java.util.LinkedList;

public class program6 {
    public static void main(String[] args) {
        LinkedList<Character> originalList = new LinkedList<>();
        for (char c = 'A'; c <= 'J'; c++) {
            originalList.add(c);
        }

        System.out.println("Original LinkedList:");
        for (char c : originalList) {
            System.out.print(c + " ");
        }
        System.out.println();

        LinkedList<Character> reversedList = new LinkedList<>();
        // Copy the elements from the first list to the second list in reverse order
        for (int i = originalList.size() - 1; i >= 0; i--) {
            reversedList.add(originalList.get(i));
        }

        System.out.println("Reversed LinkedList:");
        for (char c : reversedList) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
