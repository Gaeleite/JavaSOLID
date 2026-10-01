package questao09;

public class Funcionario implements Pagavel {
    private double salario;
    private double bonus;

    public Funcionario(double salario, double bonus) {
        this.salario = salario;
        this.bonus = bonus;
    }

    public double calcularPagamento() {
        return salario + bonus;
    }

    public void depositarPagamento(double valor) {
        System.out.println(valor);
    }
}
