package com.caiomacedo.desafiogrupowl.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Collaborator extends BaseEntity {

    private String name;
    private String cpf;

    @OneToMany
    private List<Item> items;

    public Collaborator() {
    }

    public Collaborator(String name, String cpf, List<Item> items) {
        this.name = name;
        this.cpf = cpf;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
