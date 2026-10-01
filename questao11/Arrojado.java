import java.util.Random;

public class Arrojado implements Investimento {
    public double calcula(Conta conta) {
        double x = new Random().nextDouble();
        if (x < 0.2) return conta.getSaldo() * 0.05;
        if (x < 0.5) return conta.getSaldo() * 0.03;
        return conta.getSaldo() * 0.006;
    }
}
