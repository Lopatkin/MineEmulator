package com.company.vizor101;


public class Main {

    public static int Balance;
    public static int mineCount;
    public static int dayIncome;
    public static int headLevel;

    public int getHeadLevel() {
        return headLevel;
    }

    public void setHeadLevel(int headLevel) {
        this.headLevel = headLevel;
    }

    public void setDayIncome(int dayIncome) {
        this.dayIncome = dayIncome;
    }

    public int getDayIncome() {
        return dayIncome;
    }

    public int getMineCount() {

        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getBalance() {
        return Balance;
    }

    public static void main(String[] args) {

        Balance = 100;
        headLevel = 1;

        //NextDay.NextDay();
        //SimpleGUI app = new SimpleGUI();
        // app.setVisible(true);

        MainWindow app = new MainWindow();
        app.setVisible(true);


    }


}
