package questao11;

public class Conta {
    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do deposito nao pode ser negativo");
        }
        saldo += valor;
    }
}
