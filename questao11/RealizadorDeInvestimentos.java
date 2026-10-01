public class RealizadorDeInvestimentos {
    private Investimento investimento;

    public RealizadorDeInvestimentos(Investimento investimento) {
        this.investimento = investimento;
    }

    public void realiza(Conta conta) {
        conta.deposita(investimento.calcula(conta) * 0.75);
    }
}
