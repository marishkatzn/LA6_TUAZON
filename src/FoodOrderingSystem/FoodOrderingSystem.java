package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JPanel FoodOrderingSystem;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    public FoodOrderingSystem(){
        int pPizza = 100;
        int pBurger = 80;
        int pFries = 65;
        int pSoftDrinks = 55;
        int pTea = 50;
        int pSundae = 40;

        btnOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                double totalPrice = 0;

                if (cPizza.isSelected()) totalPrice += pPizza;
                if (cBurger.isSelected()) totalPrice += pBurger;
                if (cFries.isSelected()) totalPrice += pFries;
                if (cSoftDrinks.isSelected()) totalPrice += pSoftDrinks;
                if (cTea.isSelected()) totalPrice += pTea;
                if (cSundae.isSelected()) totalPrice += pSundae;

                double discount = 0;

                if (rb5.isSelected()) {
                    discount = 0.05;
                } else if (rb10.isSelected()) {
                    discount = 0.10;
                } else if (rb15.isSelected()) {
                    discount = 0.15;
                }

                double discountAmount = totalPrice * discount;
                double finalPrice = totalPrice - discountAmount;

                JOptionPane.showMessageDialog(null, "The total price is Php" + (String.format(" %.2f", finalPrice)), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    public static void main(String[] args) {
        FoodOrderingSystem app = new FoodOrderingSystem();
        app.setTitle("Food Ordering System");
        app.setContentPane(app.FoodOrderingSystem);
        app.setSize(600,600);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}