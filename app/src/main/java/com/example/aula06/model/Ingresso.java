/*
 *@author:<Leonardo Lima 1110482423021>
 */
package com.example.aula06.model;

public abstract class Ingresso {
    private String codId;
    private float valor;

    public Ingresso(String codId, float valor) {
        this.codId = codId;
        this.valor = valor;
    }

    public abstract float valorFinal(double taxaConv);

    public String getCodId() {
        return codId;
    }

    public void setCodId(String codId) {
        this.codId = codId;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
