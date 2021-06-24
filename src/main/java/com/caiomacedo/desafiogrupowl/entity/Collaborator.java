package com.caiomacedo.desafiogrupowl.entity;

import javax.persistence.Entity;

@Entity
public class Collaborator extends BaseEntity {

    private String name;
    private String cpf;

    public Collaborator() {
    }

    public Collaborator(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
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
}
