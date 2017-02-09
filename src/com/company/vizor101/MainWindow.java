package com.company.vizor101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {


    Counts counts = new Counts();
    Main main = new Main();

    public int dayCount;


    public int headUpdateCost = 1000;

    public JLabel labelInfo = new JLabel("Информация");
    public JLabel labelDayIncome = new JLabel("Текущая прибыль: ");


    public JLabel labelBalance = new JLabel("Текущий баланс: " + main.getBalance());


    private JLabel emptyLabel = new JLabel("");
    private JButton buttonNextDay = new JButton("НОВЫЙ ДЕНЬ");
    private JButton buttonUpgradeHead = new JButton("Апгрейднуть штаб за " + headUpdateCost + " г");
    private JButton buttonMineWindow = new JButton("Шахты");


    public JLabel labelHeadLevel = new JLabel("Уровень штаба " + main.getHeadLevel());


    public JLabel labelDayCount = new JLabel("Текущий день: ");

    public JLabel labelMineInfo = new JLabel("Каждая шахта приносит " + counts.getMineDayIncome() + " золота в день.");

    class buttonNextDayActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            if (main.getMineCount() > 0)
//                main.setBalance(main.getMineCount() * counts.getMineDayIncome());

            main.setBalance(main.getBalance() + main.getDayIncome());

            labelBalance.setText("Текущий баланс: " + main.getBalance());

            main.setDayIncome(main.getMineCount() * counts.getMineDayIncome());
            labelDayCount.setText("Текущий день: " + dayCount);
            labelDayIncome.setText("Текущая прибыль: " + main.getDayIncome() + " в день");
            labelInfo.setText("Новый день настал!");


            dayCount++;

        }
    }

    class buttonUpgradeHeadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (main.getBalance() < headUpdateCost) {
                labelInfo.setText("Не хватает денег для апгрейда штаба!");
            } else {
                main.setBalance(main.getBalance() - headUpdateCost);
                main.setHeadLevel(main.getHeadLevel() + 1);
                labelInfo.setText("Штаб апгрейднут до " + main.getHeadLevel() + "уровня");
                labelBalance.setText("Текущий баланс: " + main.getBalance());
                labelHeadLevel.setText("Уровень штаба " + main.getHeadLevel());
            }
        }
    }

    class buttonMineWindowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            MineWindow app = new MineWindow();
            app.setVisible(true);
        }


    }


    public MainWindow() {
        super("Эмулятор шахт");
        this.setBounds(100, 100, 500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(25, 30, 3, 3));


        container.add(labelInfo);
        container.add(labelHeadLevel);
        container.add(labelBalance);
        container.add(labelDayIncome);

        container.add(labelMineInfo);
        container.add(buttonMineWindow);
        container.add(buttonUpgradeHead);


        container.add(labelDayCount);
        container.add(buttonNextDay);


        buttonNextDay.addActionListener(new buttonNextDayActionListener());
        buttonMineWindow.addActionListener(new buttonMineWindowListener());
        buttonUpgradeHead.addActionListener(new buttonUpgradeHeadListener());

    }


}
