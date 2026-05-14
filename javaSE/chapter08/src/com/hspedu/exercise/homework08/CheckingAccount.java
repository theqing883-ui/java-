package com.hspedu.exercise.homework08;

class CheckingAccount extends BankAccount {
    private double serFee = 1;

    public CheckingAccount(int balance) {
        super(balance);
    }

    public double getSerFee() {
        return serFee;
    }

    public void setSerFee(double serfee) {
        serFee = serfee;
    }

    public void deposit(double amount) {
        super.deposit(amount - serFee);
    }

    public void withdraw(double amount) {
        super.withdraw(amount + serFee);//相当于多取1元
    }
}