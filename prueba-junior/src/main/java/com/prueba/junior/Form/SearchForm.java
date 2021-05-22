package com.prueba.junior.Form;

import CustomValidator.Numeric;

import javax.validation.constraints.NotNull;

public class SearchForm {

    @Numeric
    @NotNull(message = "El elemento es requerido")
    private String id;

    public SearchForm(){ }

    public SearchForm(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
