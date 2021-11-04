package br.com.zup.Aplicacao.Aplicação;

public enum Risco {

    ALTO (0.025),
    MÉDIO(0.015),
    BAIXO(0.005);

    private double taxa;

    Risco (double taxa){
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

}
