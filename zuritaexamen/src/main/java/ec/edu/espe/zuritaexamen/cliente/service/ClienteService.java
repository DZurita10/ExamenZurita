package ec.edu.espe.zuritaexamen.cliente.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.zuritaexamen.cliente.controller.dto.response.ClienteRS;
import ec.edu.espe.zuritaexamen.cliente.model.Cliente;
import ec.edu.espe.zuritaexamen.cliente.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteRS getCliente(String cedula) {
        try {
            Cliente cliente = clienteRepository.findByCedula(cedula);
            ClienteRS clienteRS = new ClienteRS();
            clienteRS.setNombre(cliente.getNombre());
            clienteRS.setApellido(cliente.getApellido());
            clienteRS.setCedula(cliente.getCedula());
            clienteRS.setDireccion(cliente.getDireccion());
            clienteRS.setTelefono(cliente.getTelefono());
            clienteRS.setCorreo(cliente.getCorreo());
            clienteRS.setCuentas(cliente.getCuentas());
            
            return clienteRS;

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;

        }
    }
}
