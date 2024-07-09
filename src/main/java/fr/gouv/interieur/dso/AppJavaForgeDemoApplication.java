package fr.gouv.interieur.dso;

import fr.gouv.interieur.dso.models.Customer;
import fr.gouv.interieur.dso.models.Demo;
import fr.gouv.interieur.dso.repository.CustomerRepository;
import fr.gouv.interieur.dso.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppJavaForgeDemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DemoRepository demoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppJavaForgeDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();
		customerRepository.save(new Customer("Zakari", "Karahacane"));
		Demo demo = new Demo();
		demo.setName("Zakari ;)");
		demoRepository.equals(demo);
		System.out.println("created $$$$");

	}
}
