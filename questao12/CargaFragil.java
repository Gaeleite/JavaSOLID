public class CargaFragil implements RegraFrete {
    public double aplicar(double valor, double km, double kg) {
        return (valor + 15) * 1.05;
    }
}
