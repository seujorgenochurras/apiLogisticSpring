package br.com.charleseduardo.apilog.api.controller;

import br.com.charleseduardo.apilog.domain.model.Client;
import br.com.charleseduardo.apilog.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public List<Client> list(){
        return clientRepository.findAll();
    }
@GetMapping("/clients/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId){
        Optional<Client> client = clientRepository.findById(clientId);

        if(client.isPresent()){

            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();

    }
}
