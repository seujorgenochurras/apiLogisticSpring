package br.com.charleseduardo.apilog.api.controller;

import br.com.charleseduardo.apilog.domain.model.Client;
import br.com.charleseduardo.apilog.domain.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@Valid @RequestBody Client client){
        return clientRepository.save(client);

    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient( @PathVariable Long clientId, @Valid @RequestBody Client client){
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        client = clientRepository.save(client);
        client.setId(clientId);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}"
    )
    public ResponseEntity<Void> removeClient(@PathVariable Long clientId){
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        clientRepository.deleteById(clientId);

        return ResponseEntity.noContent().build();
    }
}
