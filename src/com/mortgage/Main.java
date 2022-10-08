package com.mortgage;//

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal: ", 1000.0, 1000000.0);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1.0, 30.0);
        byte years = (byte)((int) Console.readNumber("Period (Years): ", 1.0, 30.0));

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
