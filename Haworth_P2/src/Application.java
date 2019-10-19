public class Application {

    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        SavingsAccount.modifyInterestRate(.04);
        saver1.setSavingAccount("saver1", 2000.00);
        saver2.setSavingAccount("saver2", 3000.00);



        System.out.printf("\nMonthly balance for %s.\n", saver1.getSaverName());

        for(int i = 1; i < 13; ++i){
            System.out.printf("Month %2d : $", i);
            saver1.modifySavingBalance(saver1.calculateMonthlyInterest());
            System.out.printf("%.2f\n",saver1.getSavingBalance());
        }

        System.out.println("\n-------------------------------");

        System.out.printf("\nMonthly balance for %s.\n", saver2.getSaverName());
        for(int i = 1; i < 13; ++i){
            System.out.printf("Month %2d : $", i);
            saver2.modifySavingBalance(saver2.calculateMonthlyInterest());
            System.out.printf("%.2f\n",saver2.getSavingBalance());
        }

        SavingsAccount.modifyInterestRate(.05);
        saver1.modifySavingBalance(saver1.calculateMonthlyInterest());
        saver2.modifySavingBalance(saver2.calculateMonthlyInterest());

        System.out.printf("\n\nBalance after next month of %.2f interest.", saver1.getAnnualInterestRate());
        System.out.printf("\n%s: $%.2f",saver1.getSaverName(),saver1.getSavingBalance());
        System.out.printf("\n%s: $%.2f",saver2.getSaverName(), saver2.getSavingBalance());
    }
}
