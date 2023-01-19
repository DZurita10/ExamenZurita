package ec.edu.espe.zuritaexamen.cliente.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import ec.edu.espe.zuritaexamen.cliente.controller.dto.request.TurnoRQ;
import ec.edu.espe.zuritaexamen.cliente.controller.dto.request.TurnoUpRQ;
import ec.edu.espe.zuritaexamen.cliente.controller.dto.response.TurnoRS;
import ec.edu.espe.zuritaexamen.cliente.model.Cliente;
import ec.edu.espe.zuritaexamen.cliente.model.Ejecutivo;
import ec.edu.espe.zuritaexamen.cliente.model.Turno;
import ec.edu.espe.zuritaexamen.cliente.repository.ClienteRepository;
import ec.edu.espe.zuritaexamen.cliente.repository.EjecutivoRepository;
import ec.edu.espe.zuritaexamen.cliente.repository.TurnoRepository;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;
    private final EjecutivoRepository ejecutivoRepository;

    public TurnoService(TurnoRepository turnoRepository, ClienteRepository clienteRepository,
            EjecutivoRepository ejecutivoRepository) {
        this.turnoRepository = turnoRepository;
        this.clienteRepository = clienteRepository;
        this.ejecutivoRepository = ejecutivoRepository;
    }

    public TurnoRS saveTurno(TurnoRQ turnoRQ) {

        try {
            Cliente cliente = clienteRepository.findByCedula(turnoRQ.getCedula());
            Ejecutivo ejecutivo = ejecutivoRepository.findByEstado("INC");
            Turno searchTurno = turnoRepository.findByNumerTurno(-1);


            Turno turno = new Turno();
            turno.setCedula(turnoRQ.getCedula());
            turno.setNombre(cliente.getNombre() + " " + cliente.getApellido());
            turno.setFechaGeneracion(new Date());
            turno.setNumerTurno(searchTurno.getNumerTurno() + 1);
            turno.setEjecutivo(ejecutivo.getNombreEjecutivo());
            turno.setCodigoEjecutivo(ejecutivo.getCodigoEjecutivo());
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

    public void updateTurno(String cedula, TurnoUpRQ turnoRQ) {
        Turno turno = turnoRepository.findByCedula(cedula);
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
