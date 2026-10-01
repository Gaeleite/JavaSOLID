package questao12;

public class ValorBase implements RegraFrete {
    public double aplicar(double valor, double km, double kg) {
        return km * 1.20 + kg * 0.50;
    }
}
