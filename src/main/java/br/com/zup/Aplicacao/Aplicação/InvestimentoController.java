package br.com.zup.Aplicacao.Aplicação;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {


    @Autowired
    private InvestimentoService investimentoService;

    @PutMapping
    public ResultadoInvestimentoDTO salvarInvestimento(@RequestBody @Valid InvestimentoDTO investimentoDTO){
      ResultadoInvestimentoDTO resultadoInvestimentoDTO =  investimentoService.salvarInvestimento(investimentoDTO);
        return resultadoInvestimentoDTO;
    }

    @GetMapping
    public List<InvestimentoDTO> verificarSimulação(ResultadoInvestimentoDTO resultadoInvestimentoDTO){
        return investimentoService.retornarListaDeInvestimentos();
    }


}



