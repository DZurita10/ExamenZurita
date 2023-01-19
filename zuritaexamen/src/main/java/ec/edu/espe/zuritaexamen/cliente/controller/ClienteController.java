package ec.edu.espe.zuritaexamen.cliente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.zuritaexamen.cliente.controller.dto.response.ClienteRS;
import ec.edu.espe.zuritaexamen.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @ResponseBody
    @RequestMapping(value = "/cedula", method = RequestMethod.GET)
    public ClienteRS findByName(String cedula) {
        return clienteService.getCliente(cedula);        
    }

}
