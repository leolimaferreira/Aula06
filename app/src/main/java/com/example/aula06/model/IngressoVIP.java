/*
 *@author:<Leonardo Lima 1110482423021>
 */
package com.example.aula06.model;

public class IngressoVIP extends Ingresso{
    private String funcao;

    public IngressoVIP(String codId, float valor) {
        super(codId, valor);
    }

    @Override
    public float valorFinal(double taxaConv) {
        return getValor() + (float)(getValor() * taxaConv) + (float) (getValor() * 0.18);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
