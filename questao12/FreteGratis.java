package questao12;

public class FreteGratis implements RegraFrete {
    public double aplicar(double valor, double km, double kg) {
        return valor > 100 ? 0 : valor;
    }
}
