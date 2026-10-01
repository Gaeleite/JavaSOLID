package questao12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculadoraFrete {
    private final List<RegraFrete> regras = new ArrayList<>();

    public void adicionarRegra(RegraFrete regra) {
        regras.add(Objects.requireNonNull(regra));
    }

    public double calcular(double km, double kg) {
        if (km < 0 || kg < 0) {
            throw new IllegalArgumentException("Distancia e peso nao podem ser negativos");
        }
        double valor = 0;
        for (RegraFrete regra : regras) {
            valor = regra.aplicar(valor, km, kg);
        }
        return valor;
    }
}
