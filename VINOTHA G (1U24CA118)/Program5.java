import java.util.HashMap;

public class Program5 {

    public static void main(String[] args) {

        String inputString = "HELLO THERE";

        HashMap<Character, Integer> charCountMap =
                countCharacters(inputString);

        printCharacterCount(charCountMap);
    }

    public static HashMap<Character, Integer> countCharacters(String inputString) {

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {

            char c = inputString.charAt(i);

            if (Character.isLetter(c)) {

                c = Character.toUpperCase(c);

                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } 
                else {
                    charCountMap.put(c, 1);
                }
            }
        }

        return charCountMap;
    }

    public static void printCharacterCount(
            HashMap<Character, Integer> charCountMap) {

        for (char c : charCountMap.keySet()) {
            System.out.println(c + ":" + charCountMap.get(c));
        }
    }
}