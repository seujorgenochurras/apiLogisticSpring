package br.com.charleseduardo.apilog.domain.service;


import br.com.charleseduardo.apilog.domain.exception.DomainException;
import br.com.charleseduardo.apilog.domain.model.Client;
import br.com.charleseduardo.apilog.domain.model.Delivery;
import br.com.charleseduardo.apilog.domain.model.StatusDelivery;
import br.com.charleseduardo.apilog.domain.repository.ClientRepository;
import br.com.charleseduardo.apilog.domain.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RequestDeliveryService{
    @Autowired
    private ClientService clientService;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery request(Delivery delivery){
        Client client = clientService.serchClient(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setDateOrder(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }

    public RequestDeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
}
