package com.usa.ciclo3.retociclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase Quadbike
 *
 * @author CamiloRodriguez
 */
@Entity
@Table(name="quadbike")
public class Quadbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Atributos de la clase Quadbike
     */
    private Integer id;
    private String  name;
    private String  brand;
    private Integer year;
    private String  description;

    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties("quadbikes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Reservation> reservations;

    /**
     * Método get Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método set ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Método get Name
     */
    public String getName() {
        return name;
    }

    /**
     * Método set Name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método get Brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Método set Brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * Método get Year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Método set Year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * Método get Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método set Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método get Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Método set Category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Método get Messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Método set Messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Método get Reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Método set Reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
