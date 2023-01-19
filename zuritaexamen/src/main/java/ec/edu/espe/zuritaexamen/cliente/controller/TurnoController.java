package ec.edu.espe.zuritaexamen.cliente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.zuritaexamen.cliente.controller.dto.request.TurnoRQ;
import ec.edu.espe.zuritaexamen.cliente.controller.dto.request.TurnoUpRQ;
import ec.edu.espe.zuritaexamen.cliente.service.TurnoService;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }
    
    @ResponseBody
    @RequestMapping(value = "/cliente-turno", method = RequestMethod.POST)
    public void saveTurno(TurnoRQ cedula) {
        this.turnoService.saveTurno(cedula);
    }

    @ResponseBody
    @RequestMapping(value = "/cliente-turno/{cedula}", method = RequestMethod.PUT)
    public void updateTurno(String cedula, TurnoUpRQ turnoRQ) {
        this.turnoService.updateTurno(cedula, turnoRQ);
    }

    @ResponseBody
    @RequestMapping(value = "/cliente-turno/{cedula}", method = RequestMethod.GET)
    public void getTurnoByCedula(String cedula) {
        this.turnoService.getTurnoByCedula(cedula);
    }

    @ResponseBody
    @RequestMapping(value = "/cliente-turno/{nombre}", method = RequestMethod.GET)
    public void getTurnoByNombre(String nombre) {
        this.turnoService.getTurnoByName(nombre);
    }

    @ResponseBody
    @RequestMapping(value = "/cliente-turno/{numero}", method = RequestMethod.GET)
    public void getTurnoByNumero(Integer numero) {
        this.turnoService.getTurnoById(numero);
    }
}
