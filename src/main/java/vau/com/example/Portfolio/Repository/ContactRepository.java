package vau.com.example.Portfolio.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import vau.com.example.Portfolio.Model.Contact;

public interface ContactRepository extends MongoRepository<Contact,String> {
}
