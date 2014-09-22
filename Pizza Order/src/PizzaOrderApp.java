import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

import java.text.NumberFormat;

public class PizzaOrderApp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPrice;
	double small = 6.99;
	double medium = 8.99;
	double large = 10.99;
	double meats = 1.49;
	double vegtables = 0.99;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaOrderApp frame = new PizzaOrderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PizzaOrderApp() {
		setTitle("Pizza Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(new BevelBorder(
				BevelBorder.LOWERED, null, null, null, null), "Size",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		layeredPane.setBounds(44, 11, 325, 72);
		contentPane.add(layeredPane);

		JPanel panel = new JPanel();
		panel.setBounds(31, 24, 263, 23);
		layeredPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnSmall = new JRadioButton("Small");
		rdbtnSmall.setBounds(0, 0, 67, 23);
		panel.add(rdbtnSmall);

		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setBounds(98, 0, 93, 23);
		panel.add(rdbtnMedium);

		JRadioButton rdbtnLarge = new JRadioButton("Large");
		rdbtnLarge.setBounds(196, 0, 67, 23);
		panel.add(rdbtnLarge);

		ButtonGroup groupSize = new ButtonGroup();
		groupSize.add(rdbtnSmall);
		groupSize.add(rdbtnMedium);
		groupSize.add(rdbtnLarge);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(new BevelBorder(
				BevelBorder.LOWERED, null, null, null, null), "Toppings",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		layeredPane_1.setBounds(44, 94, 325, 150);
		contentPane.add(layeredPane_1);

		JCheckBox chckbxSausage = new JCheckBox("Sausage");
		chckbxSausage.setBounds(8, 20, 97, 23);
		layeredPane_1.add(chckbxSausage);

		JCheckBox chckbxPepperoni = new JCheckBox("Pepperoni");
		chckbxPepperoni.setBounds(8, 63, 97, 23);
		layeredPane_1.add(chckbxPepperoni);

		JCheckBox chckbxSalami = new JCheckBox("Salami");
		chckbxSalami.setBounds(8, 106, 97, 23);
		layeredPane_1.add(chckbxSalami);

		JCheckBox chckbxOlives = new JCheckBox("Olives");
		chckbxOlives.setBounds(186, 20, 97, 23);
		layeredPane_1.add(chckbxOlives);

		JCheckBox chckbxMushrooms = new JCheckBox("Mushrooms");
		chckbxMushrooms.setBounds(186, 63, 97, 23);
		layeredPane_1.add(chckbxMushrooms);

		JCheckBox chckbxAnchovies = new JCheckBox("Anchovies");
		chckbxAnchovies.setBounds(186, 106, 97, 23);
		layeredPane_1.add(chckbxAnchovies);

		JLabel label = new JLabel("Price");
		label.setBounds(24, 270, 92, 22);
		contentPane.add(label);

		textFieldPrice = new JTextField();
		textFieldPrice.setEditable(false);
		textFieldPrice.setBounds(66, 271, 114, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setMnemonic('c');
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberFormat currency = NumberFormat.getCurrencyInstance();
				double sizePrice = 0;
				double meatIng = 0;
				double vegIng = 0;
				if (rdbtnSmall.isSelected()) {
					sizePrice = small;

				}
				if (rdbtnMedium.isSelected()) {
					sizePrice = medium;

				}
				if (rdbtnLarge.isSelected()) {
					sizePrice = large;

				}
				if (chckbxSausage.isSelected()) {
					meatIng += meats;
				}
				if (chckbxSalami.isSelected()) {
					meatIng += meats;
				}
				if (chckbxPepperoni.isSelected()) {
					meatIng += meats;
				}
				if (chckbxMushrooms.isSelected()) {
					vegIng += vegtables;
				}
				if (chckbxOlives.isSelected()) {
					vegIng += vegtables;
				}
				if (chckbxAnchovies.isSelected()) {
					vegIng += vegtables;
				}

				textFieldPrice.setText(currency.format(sizePrice + meatIng
						+ vegIng));
			}
		});
		btnCalculate.setBounds(196, 329, 89, 23);
		contentPane.add(btnCalculate);

		JButton btnExit = new JButton("Exit");
		btnExit.setMnemonic('x');
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(295, 329, 89, 23);
		contentPane.add(btnExit);
	}
}
