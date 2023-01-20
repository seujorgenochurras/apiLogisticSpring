package br.com.charleseduardo.apilog.api.controller;

import br.com.charleseduardo.apilog.domain.model.Client;
import br.com.charleseduardo.apilog.domain.repository.ClientRepository;
import br.com.charleseduardo.apilog.domain.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;
    private ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        super();
        this.clientRepository = clientRepository;
        this.clientService = clientService;
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
        return clientService.save(client);

    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient( @PathVariable Long clientId, @Valid @RequestBody Client client){
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientService.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}"
    )
    public ResponseEntity<Void> removeClient(@PathVariable Long clientId){
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        clientService.delete(clientId);

        return ResponseEntity.noContent().build();
    }
}
