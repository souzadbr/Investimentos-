package br.com.zup.Aplicacao.Aplicação;

public enum Risco {

    ALTO (0.25),
    MÉDIO(0.15),
    BAIXO(0.05);

    private double taxa;

    Risco (double taxa){
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

}
