package fr.gouv.interieur.dso.controller;

import fr.gouv.interieur.dso.models.Customer;
import fr.gouv.interieur.dso.models.Demo;
import fr.gouv.interieur.dso.repository.CustomerRepository;
import fr.gouv.interieur.dso.service.jdbc.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gouv.interieur.dso.service.dto.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseDto helloWorld() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("hello world !");
        responseDto.setStatus("ok");
        return responseDto;
    }

    @GetMapping("/postgres")
    public ResponseEntity<List<Demo>> getDemosList(){
        return new ResponseEntity<>(demoService.getListDemo(), HttpStatus.OK);
    }

    @GetMapping("/mongo")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
