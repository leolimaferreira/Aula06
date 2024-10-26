package com.example.aula06.model;

public class IngressoComum extends Ingresso{

    public IngressoComum(String codId, float valor) {
        super(codId, valor);
    }

    @Override
    public float valorFinal(double taxaConv) {
        return getValor() + (float)(getValor() * taxaConv);
    }

}
