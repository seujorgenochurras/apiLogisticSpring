package br.com.charleseduardo.apilog.api.controller;

import br.com.charleseduardo.apilog.domain.model.Delivery;
import br.com.charleseduardo.apilog.domain.service.RequestDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private RequestDeliveryService requestDeliveryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody Delivery delivery){
        return requestDeliveryService.request(delivery);
    }

    public DeliveryController(RequestDeliveryService requestDeliveryService) {
        this.requestDeliveryService = requestDeliveryService;
    }
}
