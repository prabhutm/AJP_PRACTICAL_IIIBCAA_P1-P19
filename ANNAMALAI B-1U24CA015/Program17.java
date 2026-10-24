package com.example.test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/hello")
@RestController
public class Program17 {
@GetMapping
public String sayHello() {
return "Hello Java";
}}