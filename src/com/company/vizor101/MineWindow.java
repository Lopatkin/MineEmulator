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
    String mineList;
    String printMineList;
    String mineListStart = "<html>";
    String mineListEnd = "</html>";


    public JLabel labelDayIncome = new JLabel("Текущая прибыль: " + main.getDayIncome() + " в день");
    public JLabel labelMineCount = new JLabel("Количество шахт: " + main.mineCount);
    public JLabel labelInfo = new JLabel("Информация");
    public JLabel labelBalance = new JLabel("Текущий баланс: " + main.getBalance());
    public JLabel labelMineList = new JLabel(mineList);

    public JList printList = new JList(main.mines);

    private JButton buttonAddMine = new JButton("Построить шахту за " + counts.getMineBuildCost() + " г");

    class buttonAddMineListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            if (main.getBalance() >= counts.getMineBuildCost()) {
                if (main.getMineCount() < main.getHeadLevel() * counts.getMaxMinPerHeadLevel()) {
                    main.setBalance(main.getBalance() - counts.getMineBuildCost());

                    main.setMineCount(main.getMineCount() + 1);

                    main.setDayIncome(main.getMineCount() * counts.getMineDayIncome());

                    labelInfo.setText("Шахта построена!");

                    for (int i = 0; i < main.mines.length; i++) {

                        if (main.mines[i].getMineLevel() == 0) {
                            main.mines[i].setNum(i);
                            main.mines[i].setMineLevel(1);
                            main.mines[i].setMineType("Дерево");
                            main.mines[i].setMineName("Деревянная шахта");

                            mineList += main.mines[i].getNum() + ". " + main.mines[i].getMineName() + " " + main.mines[i].getMineLevel() + " уровня" + "<br>";
                            break;
                        }
                    }
                } else {
                    labelInfo.setText("Поднимите уровень штаба!");
                }
            } else {
                labelInfo.setText("Не хватает денег на постройку!");
            }

            labelMineCount.setText("Количество шахт: " + main.getMineCount());
            labelDayIncome.setText("Текущая прибыль: " + main.getDayIncome() + " в день");
            labelBalance.setText("Текущий баланс: " + main.getBalance());

            printMineList = mineListStart + mineList + mineListEnd;

            labelMineList.setText(printMineList);
        }
    }


    public void printMines(){

        for (int i = 0; i < main.mines.length; i++) {
            if (main.mines[i].getMineLevel() > 0 ){
                mineList += main.mines[i].getNum() + ". " + main.mines[i].getMineName() + " " + main.mines[i].getMineLevel() + " уровня" + "<br>";
            }

        }

        printMineList = mineListStart + mineList + mineListEnd;

        labelMineList.setText(printMineList);


    }


    public MineWindow() {

        super("Шахты");
        this.setBounds(150, 170, 270, 1000);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(15,10,5,5));
        container.add(labelInfo);
        container.add(labelBalance);
        container.add(labelMineCount);
        container.add(labelDayIncome);
        container.add(buttonAddMine);
        container.add(labelMineList);
        //container.add(printList);
        buttonAddMine.addActionListener(new buttonAddMineListener());




        labelMineCount.setText("Количество шахт: " + main.getMineCount());
        labelDayIncome.setText("Текущая прибыль: " + main.getDayIncome() + " в день");
        labelBalance.setText("Текущий баланс: " + main.getBalance());
        mineList = "";
        labelMineList.setText(mineList);

        printMines();
    }
}