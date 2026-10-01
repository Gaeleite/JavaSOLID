package questao11;

import java.util.Objects;
import java.util.function.DoubleSupplier;

public class Arrojado implements Investimento {
    private static final double PRIMEIRA_FAIXA = 0.2;
    private static final double SEGUNDA_FAIXA = 0.5;
    private static final double PRIMEIRO_RENDIMENTO = 0.05;
    private static final double SEGUNDO_RENDIMENTO = 0.03;
    private static final double TERCEIRO_RENDIMENTO = 0.006;

    private final DoubleSupplier geradorDeProbabilidade;

    public Arrojado() {
        this(new java.util.Random()::nextDouble);
    }

    public Arrojado(DoubleSupplier geradorDeProbabilidade) {
        this.geradorDeProbabilidade = Objects.requireNonNull(geradorDeProbabilidade);
    }

    public double calcula(Conta conta) {
        double probabilidade = geradorDeProbabilidade.getAsDouble();
        if (probabilidade < PRIMEIRA_FAIXA) {
            return conta.getSaldo() * PRIMEIRO_RENDIMENTO;
        }
        if (probabilidade < SEGUNDA_FAIXA) {
            return conta.getSaldo() * SEGUNDO_RENDIMENTO;
        }
        return conta.getSaldo() * TERCEIRO_RENDIMENTO;
    }
}
