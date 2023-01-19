package ec.edu.espe.zuritaexamen.cliente.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "turno")
public class Turno {
    @Id
    private String _id;
    @Indexed(unique = true)

    private String cedula;
    private String nombre;
    private Integer numerTurno;
    private Integer numeroEscritorio;
    private Ejecutivo ejecutivo;
    private Date fechaGeneracion;
    private Date fechaInicioAtencion;
    private Date fechaFinAtencion;
    private Integer calificacion;

}
