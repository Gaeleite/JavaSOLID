import java.util.ArrayList;
import java.util.List;

public class CalculadoraFrete {
    private final List<RegraFrete> regras = new ArrayList<>();

    public void adicionarRegra(RegraFrete regra) {
        regras.add(regra);
    }

    public double calcular(double km, double kg) {
        double valor = 0;
        for (RegraFrete regra : regras) {
            valor = regra.aplicar(valor, km, kg);
        }
        return valor;
    }
}
