package com.edu.usbcali.gestion_restaurante.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venta")
public class Venta { // Cambiar a "Venta" con mayúscula inicial
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false, referencedColumnName = "id_sede")
    private Sede sede; // Cambiar a "Sede" con mayúscula inicial

    @ManyToOne
    @JoinColumn(name = "id_cajero", nullable = false, referencedColumnName = "id_empleado")
    private Empleado empleado; // Cambiar a "Empleado" con mayúscula inicial

    @Column(nullable = false, name = "fecha")
    private LocalDateTime fecha_venta;

    @Column(nullable = false, name = "total")
    private BigDecimal total_venta;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "metodo_pago")
    private MetodoPago metodo_pago;

    public enum MetodoPago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }
}
