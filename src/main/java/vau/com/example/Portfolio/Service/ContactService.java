package vau.com.example.Portfolio.Service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import vau.com.example.Portfolio.Model.Contact;
import vau.com.example.Portfolio.Repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final JavaMailSender mailSender;

    public ContactService(
            ContactRepository contactRepository,
            JavaMailSender mailSender) {

        this.contactRepository = contactRepository;
        this.mailSender = mailSender;
    }

    public Contact saveContact(Contact contact) {

        System.out.println("MAIL_USERNAME exists: " +
                (System.getenv("MAIL_USERNAME") != null));

        System.out.println("MAIL_PASSWORD exists: " +
                (System.getenv("MAIL_PASSWORD") != null));

        // Save message to MongoDB
        Contact savedContact = contactRepository.save(contact);

        // Send email to admin
        sendEmail(contact);

        return savedContact;
    }

    private void sendEmail(Contact contact) {

        SimpleMailMessage email = new SimpleMailMessage();

        // YOUR email address
        email.setTo("ishqafathima34@gmail.com");

        email.setSubject(
                "New Portfolio Contact: " + contact.getSubject()
        );

        email.setText(
                "You received a new message from your portfolio.\n\n" +
                        "Name: " + contact.getName() + "\n" +
                        "Email: " + contact.getEmail() + "\n" +
                        "Subject: " + contact.getSubject() + "\n\n" +
                        "Message:\n" +
                        contact.getMessage()
        );

        mailSender.send(email);
    }
}

