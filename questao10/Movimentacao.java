public class Movimentacao {
    private double valor;
    private CalculadorDeEncargos calculador;

    public Movimentacao(double valor, CalculadorDeEncargos calculador) {
        this.valor = valor;
        this.calculador = calculador;
    }

    public double getEncargos() {
        return calculador.calcular(valor);
    }
}
