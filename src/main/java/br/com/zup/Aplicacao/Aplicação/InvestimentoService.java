package br.com.zup.Aplicacao.Aplicação;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {


    private List<InvestimentoDTO> resultadoDTOS = new ArrayList<>();

    //Método salvar investimento na lista
    public void salvarInvestimento(InvestimentoDTO investimentoDTO){
        calcularTotal(investimentoDTO.getValorPrevisto(), investimentoDTO.getPeriodoDeAplicacaoMeses(), investimentoDTO.getRisco());
        resultadoDTOS.add(investimentoDTO);
    }

    //Método de calcular valor rendido no invetimento em sua totalidade
    public double calcularTotal(double valorInvestido, int periodoDeAplicacaoMeses, Risco risco) {
        double meses = periodoDeAplicacaoMeses;
        double valorTotalDoLucro =  (valorInvestido * (risco.getTaxa()+1))*meses ;
        return valorTotalDoLucro;
    }

    //Método que mostra resultados dentro da lista de investimentos
     public List<InvestimentoDTO> retornarListaDeInvestimentos (){
        return resultadoDTOS;
     }







}
