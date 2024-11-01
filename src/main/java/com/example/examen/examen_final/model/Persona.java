package com.example.examen.examen_final.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_id_gen")
    @SequenceGenerator(name = "persona_id_gen", sequenceName = "persona_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "direccion", nullable = false)
    private String direccion;

}