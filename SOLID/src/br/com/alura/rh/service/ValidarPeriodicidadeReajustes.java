package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidarPeriodicidadeReajustes implements ValidacaoReajuste{

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, LocalDate.now());
        if (mesesDesdeUltimoReajuste < 6){
            throw new ValidacaoException("O intervalo de Reajustes deve ser superior a 6 Meses!");
        }
    }
}
