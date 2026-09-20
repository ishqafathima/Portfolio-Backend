package vau.com.example.Portfolio.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vau.com.example.Portfolio.Model.Contact;
import vau.com.example.Portfolio.Service.ContactService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://127.0.0.1:5173"
})
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> submitContact(
            @RequestBody Contact contact) {

        contactService.saveContact(contact);

        return ResponseEntity.ok("Message sent successfully!");
    }
}