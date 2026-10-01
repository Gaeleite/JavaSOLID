package questao11;

public class Conservador implements Investimento {
    private static final double RENDIMENTO = 0.008;

    public double calcula(Conta conta) {
        return conta.getSaldo() * RENDIMENTO;
    }
}
