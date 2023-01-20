package br.com.charleseduardo.apilog.api.controller;

import br.com.charleseduardo.apilog.domain.model.Client;
import br.com.charleseduardo.apilog.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> list(){
        return clientRepository.findAll();
    }
@GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId){
       return clientRepository.findById(clientId)
               .map(client -> ResponseEntity.ok(client))
               .orElse(ResponseEntity.notFound().build());
    }
}
