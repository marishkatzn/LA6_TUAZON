package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {

    private JCheckBox cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae;
    private JRadioButton rb5, rb10, rb15, rbNone;
    private JButton btnOrder;

    public FoodOrderingSystem() {
        setTitle("Food Ordering System");

        // Initialize components
        cPizza = new JCheckBox("Pizza Php 100");
        cBurger = new JCheckBox("Burger Php 80");
        cFries = new JCheckBox("Fries Php 65");
        cSoftDrinks = new JCheckBox("Soft Drinks Php 55");
        cTea = new JCheckBox("Tea Php 50");
        cSundae = new JCheckBox("Sundae Php 40");

        rbNone = new JRadioButton("None", true); // Default selected
        rb5 = new JRadioButton("5% Off");
        rb10 = new JRadioButton("10% Off");
        rb15 = new JRadioButton("15% Off");

        btnOrder = new JButton("Order");

        // Group radio buttons for discount options
        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(rbNone);
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);

        // Set layout
        setLayout(new BorderLayout());

        // Panel for food checkboxes
        JPanel foodPanel = new JPanel(new GridLayout(6, 1));
        foodPanel.setBorder(BorderFactory.createTitledBorder("Foods"));
        foodPanel.add(cPizza);
        foodPanel.add(cBurger);
        foodPanel.add(cFries);
        foodPanel.add(cSoftDrinks);
        foodPanel.add(cTea);
        foodPanel.add(cSundae);

        // Panel for discount radio buttons
        JPanel discountPanel = new JPanel(new GridLayout(4, 1));
        discountPanel.setBorder(BorderFactory.createTitledBorder("Discounts"));
        discountPanel.add(rbNone);
        discountPanel.add(rb5);
        discountPanel.add(rb10);
        discountPanel.add(rb15);

        // Panel for the order button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnOrder);

        // Add panels to the frame
        add(foodPanel, BorderLayout.WEST);
        add(discountPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add ActionListener to the Order button
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = calculateTotal();
                double discount = calculateDiscount(total);
                double finalPrice = total - discount;

                JOptionPane.showMessageDialog(
                        null,
                        String.format("The total price is Php %.2f", finalPrice),
                        "Order Total",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Finalize frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to calculate the total cost based on selected food items
    private double calculateTotal() {
        double total = 0;
        if (cPizza.isSelected()) total += 100;
        if (cBurger.isSelected()) total += 80;
        if (cFries.isSelected()) total += 65;
        if (cSoftDrinks.isSelected()) total += 55;
        if (cTea.isSelected()) total += 50;
        if (cSundae.isSelected()) total += 40;
        return total;
    }

    // Method to calculate the discount based on selected discount option
    private double calculateDiscount(double total) {
        if (rb5.isSelected()) return total * 0.05;
        else if (rb10.isSelected()) return total * 0.10;
        else if (rb15.isSelected()) return total * 0.15;
        return 0;
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
