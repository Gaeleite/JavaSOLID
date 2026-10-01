package questao12;

public class RegiaoRural implements RegraFrete {
    public double aplicar(double valor, double km, double kg) {
        return valor + km * 0.40;
    }
}
