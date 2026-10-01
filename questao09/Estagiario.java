public class Estagiario implements Pagavel {
    private double bolsa;
    private double auxilios;

    public Estagiario(double bolsa, double auxilios) {
        this.bolsa = bolsa;
        this.auxilios = auxilios;
    }

    public double calcularPagamento() {
        return bolsa + auxilios;
    }

    public void depositarPagamento(double valor) {
        System.out.println(valor);
    }
}
