package br.com.zup.Aplicacao.Aplicação.service;

import br.com.zup.Aplicacao.Aplicação.ValorBaixoParaRiscoALtoException;
import br.com.zup.Aplicacao.Aplicação.enums.Risco;
import br.com.zup.Aplicacao.Aplicação.dto.InvestimentoDTO;
import br.com.zup.Aplicacao.Aplicação.dto.ResultadoInvestimentoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {


    private List<InvestimentoDTO> resultadoDTOS = new ArrayList<>();

    //Método salvar investimento na lista
    public ResultadoInvestimentoDTO salvarInvestimento(InvestimentoDTO investimentoDTO){
        double total = calcularTotal(investimentoDTO.getValorInvestido(), investimentoDTO.getPeriodoDeAplicacaoMeses(), investimentoDTO.getRisco());
        double lucros = calcularLucro(investimentoDTO.getValorInvestido(),total);

        verificarValorERisco(investimentoDTO);  //Validação para investimentoaltoRisco
        ResultadoInvestimentoDTO resultadoInvestimentoDTO = new ResultadoInvestimentoDTO();
        resultadoInvestimentoDTO.setValorInvestido(investimentoDTO.getValorInvestido());
        resultadoInvestimentoDTO.setValorTotal(total);
        resultadoInvestimentoDTO.setValorTotalDoLucro(lucros);

        resultadoDTOS.add(investimentoDTO);
        return resultadoInvestimentoDTO ;
    }

    private void verificarValorERisco(InvestimentoDTO investimentoDTO){
        if(investimentoDTO.getRisco() == Risco.ALTO && investimentoDTO.getValorInvestido() <5000){
            throw new ValorBaixoParaRiscoALtoException("Valor muito baixo para risco alto");
        }
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

     //Método que calcula o lucro
    public double calcularLucro (double valorInvestido, double valorTotalDoLucro){
        double lucro = valorTotalDoLucro - valorInvestido;
        return lucro;
    }

   //Método que retorna todo o calculo
    public ResultadoInvestimentoDTO resultadoInvestimentoDTO (){
        ResultadoInvestimentoDTO resultadoInvestimentoDTO = new ResultadoInvestimentoDTO();
        return resultadoInvestimentoDTO;
    }







}
