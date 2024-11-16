package com.edu.usbcali.gestion_restaurante.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sedes")
public class Sede { // Nombre de la clase en mayúscula
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sede;

    @Column(nullable = false, name = "nombre", length = 100)
    private String nombre_sede;

    @Column(nullable = false, name = "ubicacion", length = 100)
    private String direccion_sede;

    @Column(nullable = false, name = "fecha_apertura")
    private LocalDateTime fecha_apertura;

    @Column(nullable = false, name = "telefono_contacto", length = 10)
    private String telefono_contacto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo" ,  columnDefinition = "VARCHAR(20)")
    private TipoSede tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", columnDefinition = "VARCHAR(20)")
    private Estado estado;

    public enum TipoSede {
        Propia, Franquicia
    }

    public enum Estado {
        Operativa,Mantenimiento, Cerrada
    }
}
