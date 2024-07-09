package fr.gouv.interieur.dso.repository;

import fr.gouv.interieur.dso.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    public List<Customer> findAll();

}
