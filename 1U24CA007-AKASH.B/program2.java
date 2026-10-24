// Practical 2: Exception handling

class ExceptionA extends Exception {
    public ExceptionA(String message) {
        super(message);
    }
}

// ExceptionB inherits from ExceptionA
class ExceptionB extends ExceptionA {
    public ExceptionB(String message) {
        super(message);
    }
}

public class program2 {
    public static void main(String[] args) {
        try {
            throw new ExceptionA("This is ExceptionA");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            throw new ExceptionB("This is ExceptionB");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            throw new java.io.IOException("This is an IOException");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            String nullString = null;
            System.out.println(nullString.length());
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
