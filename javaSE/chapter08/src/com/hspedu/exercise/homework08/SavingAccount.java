package com.hspedu.exercise.homework08;


public class SavingAccount extends BankAccount {
    private double rate = 0.01;
    private int count = 3;

    public SavingAccount(double balance) {
        super(balance);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }

    public void earnMonthlyInterest() {
        //每个月初或者月末统计利息并将count重置
        count = 3;//
        super.setBalance(super.getBalance() + super.getBalance() * rate);

    }
}
