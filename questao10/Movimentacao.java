package questao10;

import java.util.Objects;

public class Movimentacao {
    private final double valor;
    private final CalculadorDeEncargos calculador;

    public Movimentacao(double valor, CalculadorDeEncargos calculador) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor da movimentacao nao pode ser negativo");
        }
        this.valor = valor;
        this.calculador = Objects.requireNonNull(calculador);
    }

    public double getEncargos() {
        return calculador.calcular(valor);
    }
}
