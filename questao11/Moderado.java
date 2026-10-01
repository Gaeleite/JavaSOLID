import java.util.Random;

public class Moderado implements Investimento {
    public double calcula(Conta conta) {
        return new Random().nextDouble() < 0.5 ? conta.getSaldo() * 0.025 : conta.getSaldo() * 0.007;
    }
}
