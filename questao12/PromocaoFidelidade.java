public class PromocaoFidelidade implements RegraFrete {
    public double aplicar(double valor, double km, double kg) {
        return valor * 0.90;
    }
}
