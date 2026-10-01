package questao12;

public class CargaPesada implements RegraFrete {
    public double aplicar(double valor, double km, double kg) {
        return valor + kg * 0.30;
    }
}
