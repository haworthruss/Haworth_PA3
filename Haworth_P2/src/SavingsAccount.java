public class SavingsAccount {
    static private double annualInterestRate;
    private double savingBalance;
    private String name;

    public double calculateMonthlyInterest (){
        return (this.savingBalance * annualInterestRate ) / 12;
    }
    public static void modifyInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate;
    }
    public double getAnnualInterestRate (){
        return  annualInterestRate;
    }

    public void setSavingAccount(String saverName, double savingBalance){
        this.savingBalance = savingBalance;
        this.name = saverName;
    }
    public void setSavingBalance(double savingBalance){
         this.savingBalance = savingBalance;
    }
    public String getSaverName(){
        return this.name;
    }

    public void modifySavingBalance(double amountAdded){
        this.savingBalance = this.savingBalance + amountAdded;
    }
    public double getSavingBalance() {
        return this.savingBalance;
    }
}
