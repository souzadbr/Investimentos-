package br.com.zup.Aplicacao.Aplicação;

public class ResultadoInvestimentoDTO {
    private double valorInvestido;
    private double valorTotalDoLucro;
    private  double valorTotal;

    public ResultadoInvestimentoDTO() {
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getValorTotalDoLucro() {
        return valorTotalDoLucro;
    }

    public void setValorTotalDoLucro(double valorTotalDoLucro) {
        this.valorTotalDoLucro = valorTotalDoLucro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
