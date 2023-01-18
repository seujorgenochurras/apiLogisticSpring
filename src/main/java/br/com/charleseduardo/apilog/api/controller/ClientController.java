package br.com.charleseduardo.apilog.api.controller;

import br.com.charleseduardo.apilog.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {
    @GetMapping("/clients")
    public List<Client> list(){

        var client1 = new Client( 1L ,"Charles Eduardo Mello Guimaraes", "charlesEMG@gmail.com", "46 999-8354");
        var client2 = new Client( 2L ,"Eduarda Fonseca", "eduardaFonseca@hotmail.com", "46 999-8353");

        return Arrays.asList(client1, client2);
    }
}
