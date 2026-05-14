package com.hspedu.exercise.homework08;

public class Test {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(10);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.withdraw(9);
//        System.out.println(checkingAccount.getBalance());
        SavingAccount savingAccount = new SavingAccount(1000);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());

        // 定时器 月初调用利息程序
        savingAccount.earnMonthlyInterest();
        System.out.println(savingAccount.getBalance());

        savingAccount.withdraw(100);
        System.out.println(savingAccount.getBalance());


    }
}
