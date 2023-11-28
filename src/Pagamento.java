import java.util.Scanner;

public class Pagamento {
    
    private static final double DEBIT_CARD_FEE = 0.02;
    private static final double CREDIT_CARD_FEE = 0.05;
    
    public void pagarCorrida(double valor) {
        
        Scanner scanner = new Scanner(System.in);
        double rideCost = (valor); // Custo da corrida
        
        System.out.println("Forma de pagamento: (1) cartão de débito, (2) cartão de crédito");
        int paymentOption = scanner.nextInt();
        
        if (paymentOption == 1) {
            System.out.println("Insira o número do cartão de débito:");
            String cardNumber = scanner.next();
            System.out.println("Insira o código de segurança:");
            int securityCode = scanner.nextInt();
            System.out.println("Insira o valor disponível na conta:");
            double accountBalance = scanner.nextDouble();
            
            double totalCost = rideCost * (1 + DEBIT_CARD_FEE);
            
            if (totalCost > accountBalance) {
                System.out.println("Saldo insuficiente. Pagamento não autorizado.");
            } else {
                double newBalance = accountBalance - totalCost;
                
                String valorFormatado = String.format("R$ %.2f", newBalance);
                System.out.println("Pagamento efetuado com sucesso. Novo saldo: " + valorFormatado);
                

            }
        } else if (paymentOption == 2) {
            System.out.println("Insira o número do cartão de crédito:");
            String cardNumber = scanner.next();
            System.out.println("Insira a data de expiração (MM/YY):");
            String expirationDate = scanner.next();
            System.out.println("Insira o código de segurança:");
            int securityCode = scanner.nextInt();
            System.out.println("Insira o valor da fatura atual:");
            double currentBalance = scanner.nextDouble();
            
            double totalCost = rideCost * (1 + CREDIT_CARD_FEE);
            double newBalance = currentBalance + totalCost;

            String valorFormatado = String.format("R$ %.2f", newBalance);
            System.out.println("Pagamento efetuado com sucesso. Novo saldo: " + valorFormatado);

        } else {
            System.out.println("Opção de pagamento inválida.");
        }
        
        scanner.close();
    }
}