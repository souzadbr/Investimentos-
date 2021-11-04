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
    @ResponseStatus (HttpStatus.CREATED)
    public void salvarInvestimento(@RequestBody @Valid InvestimentoDTO investimentoDTO){
        investimentoService.salvarInvestimento(investimentoDTO);
    }

    @GetMapping
    public List<InvestimentoDTO> verificarSimulação(ResultadoInvestimentoDTO resultadoInvestimentoDTO){
        return investimentoService.retornarListaDeInvestimentos();
    }




}
