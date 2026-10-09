// Practical 18: HTML form data sent using a REST API (Spring Boot)
//
// Spring Boot project (Maven) with the "Spring Web" dependency.
// Put the following file in src/main/resources/static/index.html:
//
//   <!DOCTYPE html>
//   <html>
//   <head><title>Item Submission Form</title></head>
//   <body>
//     <h2>Item Submission Form</h2>
//     <form action="/api/items" method="post">
//       Item ID:<br>    <input type="text"   name="itemId"><br><br>
//       Item Name:<br>  <input type="text"   name="itemName"><br><br>
//       Item Price:<br> <input type="number" step="0.01" name="itemPrice"><br><br>
//       <input type="submit" value="Submit">
//     </form>
//   </body>
//   </html>
//
// Run the main method, then open:  http://localhost:8080/index.html
package com.example.itemsubmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class program18 {   // ItemSubmissionAppApplication

    public static void main(String[] args) {
        SpringApplication.run(program18.class, args);
    }

    // Model class (Item.java)
    public static class Item {
        private String itemId;
        private String itemName;
        private double itemPrice;

        public String getItemId() { return itemId; }
        public void setItemId(String itemId) { this.itemId = itemId; }

        public String getItemName() { return itemName; }
        public void setItemName(String itemName) { this.itemName = itemName; }

        public double getItemPrice() { return itemPrice; }
        public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
    }

    // REST controller (ItemController.java)
    @RestController
    @RequestMapping("/api/items")
    public static class ItemController {

        @PostMapping
        public String handleFormSubmit(@ModelAttribute Item item) {
            return "Received Item: " + item.getItemId() + ", "
                    + item.getItemName() + ", " + item.getItemPrice();
        }
    }
}
