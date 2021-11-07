package br.com.zup.Aplicacao.Aplicação.enums;

public enum Risco {

    ALTO (0.025),
    MEDIO(0.015),
    BAIXO(0.005);

    private double taxa;

    Risco (double taxa){
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

}
