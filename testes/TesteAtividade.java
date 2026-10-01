package testes;

import questao09.Chefe;
import questao09.Estagiario;
import questao09.Funcionario;
import questao09.PagadorDeFuncionario;
import questao10.EncargoPadrao;
import questao10.Movimentacao;
import questao10.SemEncargos;
import questao11.Arrojado;
import questao11.Conservador;
import questao11.Conta;
import questao11.Moderado;
import questao11.RealizadorDeInvestimentos;
import questao12.CargaFragil;
import questao12.CargaLeve;
import questao12.CalculadoraFrete;
import questao12.EntregaExpressa;
import questao12.FreteGratis;
import questao12.RegiaoRural;
import questao12.RegiaoUrbana;
import questao12.ValorBase;

public class TesteAtividade {
    public static void main(String[] args) {
        System.out.println("=== QUESTAO 09 ===");
        testarQuestao09();

        System.out.println("\n=== QUESTAO 10 ===");
        testarQuestao10();

        System.out.println("\n=== QUESTAO 11 ===");
        testarQuestao11();

        System.out.println("\n=== QUESTAO 12 ===");
        testarQuestao12();
    }

    private static void testarQuestao09() {
        PagadorDeFuncionario pagador = new PagadorDeFuncionario();
        Funcionario funcionario = new Funcionario(2500.0, 500.0);
        Chefe chefe = new Chefe(5000.0, 1200.0);
        Estagiario estagiario = new Estagiario(1200.0, 300.0);

        System.out.println("Funcionario: " + funcionario.calcularPagamento());
        System.out.println("Chefe: " + chefe.calcularPagamento());
        System.out.println("Estagiario: " + estagiario.calcularPagamento());

        pagador.pagar(funcionario);
        pagador.pagar(chefe);
        pagador.pagar(estagiario);
    }

    private static void testarQuestao10() {
        Movimentacao comEncargo = new Movimentacao(1000.0, new EncargoPadrao());
        Movimentacao semEncargo = new Movimentacao(1000.0, new SemEncargos());

        System.out.println("Com encargos: " + comEncargo.getEncargos());
        System.out.println("Sem encargos: " + semEncargo.getEncargos());
    }

    private static void testarQuestao11() {
        Conta conta = new Conta(1000.0);
        RealizadorDeInvestimentos realizador1 = new RealizadorDeInvestimentos(new Conservador());
        realizador1.realiza(conta);
        System.out.println("Saldo após conservador: " + conta.getSaldo());

        Conta conta2 = new Conta(1000.0);
        RealizadorDeInvestimentos realizador2 = new RealizadorDeInvestimentos(new Arrojado());
        realizador2.realiza(conta2);
        System.out.println("Saldo após arrojado: " + conta2.getSaldo());

        Conta conta3 = new Conta(1000.0);
        RealizadorDeInvestimentos realizador3 = new RealizadorDeInvestimentos(new Moderado());
        realizador3.realiza(conta3);
        System.out.println("Saldo após moderado: " + conta3.getSaldo());
    }

    private static void testarQuestao12() {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        calculadora.adicionarRegra(new ValorBase());
        calculadora.adicionarRegra(new RegiaoUrbana());
        calculadora.adicionarRegra(new FreteGratis());
        System.out.println("Frete urbano: " + calculadora.calcular(120.0, 5.0));

        CalculadoraFrete rural = new CalculadoraFrete();
        rural.adicionarRegra(new ValorBase());
        rural.adicionarRegra(new RegiaoRural());
        rural.adicionarRegra(new CargaFragil());
        System.out.println("Frete rural + fragil: " + rural.calcular(120.0, 5.0));

        CalculadoraFrete expressa = new CalculadoraFrete();
        expressa.adicionarRegra(new ValorBase());
        expressa.adicionarRegra(new EntregaExpressa());
        expressa.adicionarRegra(new CargaLeve());
        System.out.println("Frete expresso com carga leve: " + expressa.calcular(120.0, 5.0));
    }
}

