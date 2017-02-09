package com.company.vizor101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 08.02.17.
 */
public class MineWindow extends JFrame {
    MainWindow mainWindow = new MainWindow();
    Counts counts = new Counts();
    Main main = new Main();

    public JLabel labelDayIncome = new JLabel("Текущая прибыль: " + main.getDayIncome() + " в день");
    public JLabel labelMineCount = new JLabel("Количество шахт: " + main.mineCount);
    public JLabel labelInfo = new JLabel("Информация");

    public JLabel labelBalance = new JLabel("Текущий баланс: " + main.getBalance());




    private JButton buttonAddMine = new JButton("Построить шахту за " + counts.getMineBuildCost() + " г");

    class buttonAddMineListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (main.getBalance() >= counts.getMineBuildCost()) {
                if (main.getMineCount() < main.getHeadLevel() * counts.getMaxMinPerHeadLevel()) {
                    main.setBalance(main.getBalance() - counts.getMineBuildCost());

                    main.setMineCount(main.getMineCount() + 1);

                    main.setDayIncome(main.getMineCount() * counts.getMineDayIncome());

                    labelInfo.setText("Шахта построена!");
                } else {
                    labelInfo.setText("Поднимите уровень штаба!");
                }
            } else {
                labelInfo.setText("Не хватает денег на постройку!");
            }

            labelMineCount.setText("Количество шахт: " + main.getMineCount());

            labelDayIncome.setText("Текущая прибыль: " + main.getDayIncome() + " в день");
            labelBalance.setText("Текущий баланс: " + main.getBalance());

            System.out.println(main.getDayIncome());


        }
    }

    public MineWindow() {


        super("Шахты");
        this.setBounds(150, 170, 270, 600);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 10, 5, 5));
        container.add(labelInfo);
        container.add(labelBalance);
        container.add(labelMineCount);
        container.add(labelDayIncome);
        container.add(buttonAddMine);
        buttonAddMine.addActionListener(new buttonAddMineListener());

        labelMineCount.setText("Количество шахт: " + main.getMineCount());

        labelDayIncome.setText("Текущая прибыль: " + main.getDayIncome() + " в день");
        labelBalance.setText("Текущий баланс: " + main.getBalance());




    }
}
