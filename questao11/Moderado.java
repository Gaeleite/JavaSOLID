package questao11;

import java.util.Objects;
import java.util.function.DoubleSupplier;

public class Moderado implements Investimento {
    private static final double PROBABILIDADE_DE_ALTO_RENDIMENTO = 0.5;
    private static final double ALTO_RENDIMENTO = 0.025;
    private static final double BAIXO_RENDIMENTO = 0.007;

    private final DoubleSupplier geradorDeProbabilidade;

    public Moderado() {
        this(new java.util.Random()::nextDouble);
    }

    public Moderado(DoubleSupplier geradorDeProbabilidade) {
        this.geradorDeProbabilidade = Objects.requireNonNull(geradorDeProbabilidade);
    }

    public double calcula(Conta conta) {
        double rendimento = geradorDeProbabilidade.getAsDouble() < PROBABILIDADE_DE_ALTO_RENDIMENTO
                ? ALTO_RENDIMENTO
                : BAIXO_RENDIMENTO;
        return conta.getSaldo() * rendimento;
    }
}
