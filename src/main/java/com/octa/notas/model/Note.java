package com.octa.notas.model;


import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String importancia;

    public Note() {
        //constructor vacio obligatorio para JPA
    }

    public Note(String titulo, String descripcion, String importancia) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importancia = importancia;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String color) {
        this.importancia = importancia;
    }
}
