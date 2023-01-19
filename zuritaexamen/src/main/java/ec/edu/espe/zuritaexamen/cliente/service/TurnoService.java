package ec.edu.espe.zuritaexamen.cliente.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import ec.edu.espe.zuritaexamen.cliente.controller.dto.request.TurnoRQ;
import ec.edu.espe.zuritaexamen.cliente.controller.dto.request.TurnoUpRQ;
import ec.edu.espe.zuritaexamen.cliente.controller.dto.response.TurnoRS;
import ec.edu.espe.zuritaexamen.cliente.model.Cliente;
import ec.edu.espe.zuritaexamen.cliente.model.Turno;
import ec.edu.espe.zuritaexamen.cliente.repository.ClienteRepository;
import ec.edu.espe.zuritaexamen.cliente.repository.TurnoRepository;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;

    public TurnoService(TurnoRepository turnoRepository, ClienteRepository clienteRepository) {
        this.turnoRepository = turnoRepository;
        this.clienteRepository = clienteRepository;
    }

    public TurnoRS saveTurno(TurnoRQ cedula) {

        try {
            int numeroTurno = (int) (Math.random() * 10 + 1);
            int numeroEscritorio = (int) (Math.random() * 10 + 1);

            Cliente cliente = clienteRepository.findByCedula(cedula.getCedula());
            Turno turno = new Turno();
            turno.setCedula(cedula.getCedula());
            turno.setNombre(cliente.getNombre() + " " + cliente.getApellido());
            turno.setNumerTurno(numeroTurno);
            turno.setNumeroEscritorio(numeroEscritorio);
            turno.setFechaGeneracion(new Date());
            turnoRepository.save(turno);
            TurnoRS turnoRS = new TurnoRS();
            turnoRS.setNombre(turno.getNombre());
            turnoRS.setNumeroTurno(turno.getNumerTurno());
            turnoRS.setNumeroEscritorio(turno.getNumeroEscritorio());
            return turnoRS;
        } catch (Exception e) {
            throw e;
        }

    }

    public void updateTurno(TurnoUpRQ turnoRQ) {
        Turno turno = turnoRepository.findByCedula(turnoRQ.getCedula());
        turno.setFechaInicioAtencion(new Date());
        turno.setFechaFinAtencion(new Date());
        turno.setCalificacion(turnoRQ.getCalificacion());
        turno.setEjecutivo(turnoRQ.getEjecutivo());
        turnoRepository.save(turno);
    }

    public TurnoRS getTurnoByCedula(String cedula) {
        try {
            Turno turno = turnoRepository.findByCedula(cedula);
            TurnoRS turnoRS = new TurnoRS();
            turnoRS.setNombre(turno.getNombre());
            turnoRS.setNumeroTurno(turno.getNumerTurno());
            turnoRS.setNumeroEscritorio(turno.getNumeroEscritorio());

            return turnoRS;
        } catch (Exception e) {
            throw e;
        }
    }

    public TurnoRS getTurnoById(Integer numeroTurno) {
        try {
            Turno turno = turnoRepository.findByNumerTurno(numeroTurno);
            TurnoRS turnoRS = new TurnoRS();
            turnoRS.setNombre(turno.getNombre());
            turnoRS.setNumeroTurno(turno.getNumerTurno());
            turnoRS.setNumeroEscritorio(turno.getNumeroEscritorio());

            return turnoRS;
        } catch (Exception e) {
            throw e;
        }
    }

    public TurnoRS getTurnoByName(String nombre) {
        try {
            Turno turno = turnoRepository.findByNombre(nombre);
            TurnoRS turnoRS = new TurnoRS();
            turnoRS.setNombre(turno.getNombre());
            turnoRS.setNumeroTurno(turno.getNumerTurno());
            turnoRS.setNumeroEscritorio(turno.getNumeroEscritorio());

            return turnoRS;
        } catch (Exception e) {
            throw e;
        }
    }

}
