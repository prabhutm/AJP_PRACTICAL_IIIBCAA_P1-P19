// Practical 13: HTML form + JavaScript validation
// (first/last name: alphabets only, age: 18 to 50)
//
// The original practical is an HTML/JavaScript page, so this Java program
// serves that page using the JDK's built-in HTTP server (no extra libraries).
//   Run:   java program13.java
//   Open:  http://localhost:8080/index.html
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class program13 {

    private static final String HTML = """
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Registration</title>
<script>
function validateForm() {
    const firstName = document.forms["registrationForm"]["firstName"].value;
    const lastName = document.forms["registrationForm"]["lastName"].value;
    const age = document.forms["registrationForm"]["age"].value;

    const nameRegex = /^[A-Za-z]+$/;

    if (!nameRegex.test(firstName)) {
        alert("First name must contain only alphabets.");
        return false;
    }
    if (!nameRegex.test(lastName)) {
        alert("Last name must contain only alphabets.");
        return false;
    }
    if (age < 18 || age > 50) {
        alert("Age must be between 18 and 50.");
        return false;
    }
    alert("Successfully Registered");
    return true;
}
</script>
</head>
<body>
<h2>Student Registration Form</h2>
<form name="registrationForm" onsubmit="return validateForm()">
    <label for="firstName">First Name:</label><br>
    <input type="text" id="firstName" name="firstName"><br><br>

    <label for="lastName">Last Name:</label><br>
    <input type="text" id="lastName" name="lastName"><br><br>

    <label for="age">Age:</label><br>
    <input type="number" id="age" name="age"><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
""";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            byte[] body = HTML.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
        System.out.println("Open http://localhost:8080/index.html in your browser (Ctrl+C to stop).");
    }
}
