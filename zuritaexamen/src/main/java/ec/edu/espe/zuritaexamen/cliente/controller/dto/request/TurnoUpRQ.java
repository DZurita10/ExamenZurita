package ec.edu.espe.zuritaexamen.cliente.controller.dto.request;

import java.util.Date;

import ec.edu.espe.zuritaexamen.cliente.model.Ejecutivo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnoUpRQ {
    private String cedula;
    private Date fechaInicioAtencion;
    private Date fechaFinAtencion;
    private Integer calificacion;
    private Ejecutivo ejecutivo;

}
