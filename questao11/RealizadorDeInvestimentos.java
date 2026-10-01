package questao11;

public class RealizadorDeInvestimentos {
    private static final double PERCENTUAL_DE_RENDIMENTO_DEPOSITADO = 0.75;

    private final Investimento investimento;

    public RealizadorDeInvestimentos(Investimento investimento) {
        this.investimento = java.util.Objects.requireNonNull(investimento);
    }

    public void realiza(Conta conta) {
        conta.deposita(investimento.calcula(conta) * PERCENTUAL_DE_RENDIMENTO_DEPOSITADO);
    }
}
