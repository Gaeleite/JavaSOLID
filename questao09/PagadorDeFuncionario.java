package questao09;

public class PagadorDeFuncionario {
    public void pagar(Pagavel p) {
        double valor = p.calcularPagamento();
        p.depositarPagamento(valor);
    }
}
