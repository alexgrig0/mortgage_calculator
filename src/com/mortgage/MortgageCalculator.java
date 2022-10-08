package com.mortgage;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        double balance = (double) principal * (Math.pow((double) (1.0F + monthlyInterest), (double) numberOfPayments) - Math.pow((double) (1.0F + monthlyInterest), (double) numberOfPaymentsMade)) / (Math.pow((double) (1.0F + monthlyInterest), (double) numberOfPayments) - 1.0);
        return balance;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        double mortgage = (double) principal * (double) monthlyInterest * Math.pow((double) (1.0F + monthlyInterest), (double) numberOfPayments) / (Math.pow((double) (1.0F + monthlyInterest), (double) numberOfPayments) - 1.0);
        return mortgage;
    }
    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for(short month = 1; month <= balances.length; ++month)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

}
