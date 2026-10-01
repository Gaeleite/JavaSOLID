package questao09;

public class Chefe implements Pagavel {
    private double salarioBase;
    private double bonificacoes;

    public Chefe(double salarioBase, double bonificacoes) {
        this.salarioBase = salarioBase;
        this.bonificacoes = bonificacoes;
    }

    public double calcularPagamento() {
        return salarioBase + bonificacoes;
    }

    public void depositarPagamento(double valor) {
        System.out.println(valor);
    }
}
