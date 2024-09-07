import java.util.Scanner;

public class SistemaBancario {

    static class ContaBancaria {
        private String nome;
        private String tipoConta;
        private double saldo;

        public ContaBancaria(String nome, String tipoConta, double saldoInicial) {
            this.nome = nome;
            this.tipoConta = tipoConta;
            this.saldo = saldoInicial;
        }

        public void consultarSaldo() {
            System.out.printf("Seu saldo atual é: R$ %.2f%n", saldo);
        }

        public void transferirValor(double valor) {
            if (valor > saldo) {
                System.out.println("Saldo insuficiente para realizar a transferência.");
            } else {
                saldo -= valor;
                System.out.printf("Transferência de R$ %.2f realizada com sucesso!%n", valor);
            }
        }

        public void receberValor(double valor) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
        }

        public void exibirCabecalho() {
            System.out.println("********************");
            System.out.println("Cliente: " + nome);
            System.out.println("Tipo de Conta: " + tipoConta);
            System.out.printf("Saldo Inicial: R$ %.2f%n", saldo);
            System.out.println("********************");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria("João Silva", "Corrente", 1500.00);
        conta.exibirCabecalho();

        int opcao;
        do {
            System.out.println("********************");
            System.out.println("** Digite sua opção **");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Transferir valor");
            System.out.println("3 - Receber valor");
            System.out.println("4 - Sair");
            System.out.println("********************");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor a ser transferido: R$ ");
                    double valorTransferencia = scanner.nextDouble();
                    conta.transferirValor(valorTransferencia);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser recebido: R$ ");
                    double valorRecebido = scanner.nextDouble();
                    conta.receberValor(valorRecebido);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        scanner.close();
    }
}
