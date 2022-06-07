package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City {
    @Id
    @Column(name="ıd")
    private int ıd;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    public City(){}

    public City(int ıd, String name, String surname) {
        this.ıd = ıd;
        this.name = name;
        this.surname = surname;
    }
}
