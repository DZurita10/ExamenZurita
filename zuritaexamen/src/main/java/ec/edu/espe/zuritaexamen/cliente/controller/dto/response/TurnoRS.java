package ec.edu.espe.zuritaexamen.cliente.controller.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnoRS implements Serializable{
    private String nombre;
    private Integer numeroTurno;
    private Integer numeroEscritorio;    
}
