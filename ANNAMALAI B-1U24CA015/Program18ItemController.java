package com.example.itemsubmission.controller;
import com.example.itemsubmission.model.Item;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/items")
public class Program18ItemController {
@PostMapping
public String handleFormSubmit(@ModelAttribute Item item) {
return "Received Item: " + item.getItemId() + ", " + item.getItemName() + ", " +
item.getItemPrice();
}
}