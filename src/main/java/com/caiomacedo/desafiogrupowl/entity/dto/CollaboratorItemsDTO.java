package com.caiomacedo.desafiogrupowl.entity.dto;

public class CollaboratorItemsDTO {

    private String fullName;
    private String cpf;
    private String name;

    public CollaboratorItemsDTO(String fullName, String cpf, String name) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
