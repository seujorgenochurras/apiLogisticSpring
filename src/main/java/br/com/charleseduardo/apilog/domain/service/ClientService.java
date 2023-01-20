package br.com.charleseduardo.apilog.domain.service;

import br.com.charleseduardo.apilog.domain.exception.DomainException;
import br.com.charleseduardo.apilog.domain.model.Client;
import br.com.charleseduardo.apilog.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExist -> !clientExist.equals(client));

        if (emailInUse){
            throw new DomainException("This email appears as existing in our system.");
        }
        return clientRepository.save(client);
    }
    @Transactional
    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
