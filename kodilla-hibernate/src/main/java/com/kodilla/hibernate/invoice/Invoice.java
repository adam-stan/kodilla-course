package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    private int id;
    private String number;
    private List<Item> items;

    public Invoice() {
    }

    public Invoice(String number) {
        this.number = number;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}