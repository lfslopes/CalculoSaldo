import java.util.Scanner;

public class CalculoSaldo {
    public static final String SALDO_FORMATO = "\\d+(.)\\d{2}|\\d+";
    public static final String MOVIMENTACAO_FORMATO = "(\\d+(.)\\d{2}|\\d+|-\\d+(.)\\d{2}|-\\d+)";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu saldo: ");
        String saldoString = scanner.nextLine();
        if (!saldoString.matches(SALDO_FORMATO)) {
            throw new SaldoException("Saldo inválido");
        }
        double saldo = Double.parseDouble(saldoString);
        System.out.print("Digite em sequência suas três últimas movimentações: ");
        String[] Strmovimentacoes = scanner.nextLine().split(" ");
        if (Strmovimentacoes.length != 3) {
            throw new SaldoException("São necessária exatamente 3 movimentações");
        }
        for (String movimentacao : Strmovimentacoes) {
            if (!movimentacao.matches(MOVIMENTACAO_FORMATO)) {
                throw new SaldoException("Movimentações inválidas.");
            }
        }
        double [] movimentacoes = new double[Strmovimentacoes.length];
        for (int i = 0; i < Strmovimentacoes.length; i++) {
            movimentacoes[i] = Double.parseDouble(Strmovimentacoes[i]);
        }
        double saldoFinal = calcularSaldo(saldo, movimentacoes);

        System.out.printf("Saldo final: %.2f", saldoFinal);
    }
    public static double calcularSaldo(double saldo, double[] movimentacoes) throws SaldoException{
        double resultado = saldo;
        for (double movimentacao : movimentacoes)
            resultado += movimentacao;

        return resultado;
    }
}
