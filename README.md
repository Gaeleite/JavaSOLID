# JavaSOLID

Exercicios em Java sobre principios SOLID, interfaces, polimorfismo, injecao de dependencias e composicao de regras.

O projeto reune as questoes 09 a 12 em pastas separadas e possui uma classe principal para executar exemplos reais de todas elas.

## Estrutura

```text
questao09/
  Chefe.java
  Estagiario.java
  Funcionario.java
  PagadorDeFuncionario.java
  Pagavel.java

questao10/
  CalculadorDeEncargos.java
  EncargoPadrao.java
  Movimentacao.java
  SemEncargos.java

questao11/
  Arrojado.java
  Conservador.java
  Conta.java
  Investimento.java
  Moderado.java
  RealizadorDeInvestimentos.java

questao12/
  CalculadoraFrete.java
  CargaFragil.java
  CargaLeve.java
  CargaPesada.java
  EntregaExpressa.java
  EntregaNormal.java
  EntregaSuperExpressa.java
  FreteGratis.java
  PromocaoFidelidade.java
  RegiaoRural.java
  RegiaoUrbana.java
  RegraFrete.java
  ValorBase.java

testes/
  TesteAtividade.java
```

## Questao 09: pagamentos

O contrato `Pagavel` define duas operacoes: calcular o pagamento e depositar o valor.
`Funcionario`, `Chefe` e `Estagiario` implementam esse contrato com suas respectivas composicoes de pagamento.

`PagadorDeFuncionario` depende apenas da interface `Pagavel`. Assim, ele consegue pagar qualquer classe que siga esse contrato sem conhecer sua implementacao concreta.

### Principios aplicados

- **Polimorfismo:** cada tipo de pagavel calcula seu proprio pagamento.
- **Principio da substituicao de Liskov:** qualquer implementacao de `Pagavel` pode ser usada pelo pagador.
- **Inversao de dependencia:** `PagadorDeFuncionario` depende da abstracao `Pagavel`, nao das classes concretas.

## Questao 10: encargos

`CalculadorDeEncargos` e a estrategia usada para calcular encargos de uma movimentacao.

- `EncargoPadrao` calcula 1% do valor.
- `SemEncargos` retorna zero.
- `Movimentacao` recebe a estrategia pelo construtor e delega o calculo para ela.

Essa estrutura permite adicionar novas formas de calculo sem alterar `Movimentacao`, seguindo o principio aberto/fechado e o padrao Strategy.

## Questao 11: investimentos

`Investimento` define o contrato das estrategias de investimento.

- `Conservador` utiliza rendimento fixo de 0,8%.
- `Moderado` escolhe entre dois rendimentos.
- `Arrojado` escolhe entre tres faixas de rendimento.
- `Conta` encapsula o saldo e controla os depositos.
- `RealizadorDeInvestimentos` recebe uma estrategia e deposita 75% do rendimento calculado.

As classes `Moderado` e `Arrojado` recebem opcionalmente um `DoubleSupplier`. Isso separa a regra de investimento da fonte de aleatoriedade e permite testes deterministas.

## Questao 12: calculo de frete

`RegraFrete` representa uma regra que transforma o valor atual do frete.
`CalculadoraFrete` mantem uma lista de regras e aplica cada uma em sequencia.

Exemplos de regras:

- `ValorBase`: calcula o valor inicial usando quilometragem e peso.
- `RegiaoRural` e `RegiaoUrbana`: aplicam regras de regiao.
- `CargaFragil`, `CargaLeve` e `CargaPesada`: tratam o tipo de carga.
- `EntregaNormal`, `EntregaExpressa` e `EntregaSuperExpressa`: tratam a velocidade de entrega.
- `PromocaoFidelidade`: aplica desconto.
- `FreteGratis`: zera o frete quando a condicao promocional e atendida.

A calculadora trabalha com a interface `RegraFrete`, portanto novas regras podem ser adicionadas sem modificar seu algoritmo principal. Esse e um exemplo de extensibilidade, composicao e principio aberto/fechado.

## Classe de execucao

`testes.TesteAtividade` executa exemplos das quatro questoes:

1. Calcula e paga funcionario, chefe e estagiario.
2. Compara uma movimentacao com encargos e outra sem encargos.
3. Executa investimentos conservador, arrojado e moderado.
4. Calcula fretes urbano, rural e expresso.

## Compilacao

Requisitos:

- JDK 8 ou superior.
- Terminal com `javac` e `java` disponiveis no PATH.

No diretorio raiz do projeto, execute:

```bash
rmdir /s /q build
mkdir build
javac -Xlint:all -d build questao09\*.java questao10\*.java questao11\*.java questao12\*.java testes\TesteAtividade.java
```

No PowerShell, os comandos equivalentes sao:

```powershell
Remove-Item -Recurse -Force build -ErrorAction SilentlyContinue
New-Item -ItemType Directory build
javac -Xlint:all -d build questao09/*.java questao10/*.java questao11/*.java questao12/*.java testes/TesteAtividade.java
```

## Execucao

Depois da compilacao:

```bash
java -cp build testes.TesteAtividade
```

A saida apresenta os resultados das quatro questoes. Os valores das estrategias `Moderado` e `Arrojado` podem variar quando os construtores padrao sao usados, pois essas estrategias utilizam aleatoriedade.

## Decisoes de qualidade

- Cada pasta possui um pacote Java correspondente.
- As dependencias sao recebidas por construtor quando representam estrategias ou servicos.
- Campos que nao precisam mudar sao `final`.
- Entradas invalidas, como valores negativos, sao rejeitadas com `IllegalArgumentException`.
- Arquivos compilados nao sao versionados; essa regra esta em `.gitignore`.
- O codigo usa apenas a biblioteca padrao do Java.

## GitHub

Repositorio: [Gaeleite/JavaSOLID](https://github.com/Gaeleite/JavaSOLID.git)
