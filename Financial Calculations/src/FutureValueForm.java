

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.text.NumberFormat;

public class FutureValueForm extends JFrame {

	private JTextField getMonthlyPayment;
	private JTextField getInterestRate;
	private JTextField getNumberOfYears;
	private JTextField resultFutureValue;
	private JButton btnExit;
	private JLabel lblMonthlyPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FutureValueForm frame = new FutureValueForm();
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
	public FutureValueForm() {
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setTitle("Future Value Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 514, 339);
		JPanel contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0,
				0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMonthlyPayment = new JLabel("Monthly Payment:");
		lblMonthlyPayment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonthlyPayment.setPreferredSize(new Dimension(100, 14));
		lblMonthlyPayment.setBounds(48, 43, 181, 25);
		contentPane.add(lblMonthlyPayment);

		JLabel lblYearlyInterestRate = new JLabel("Yearly Interest Rate:");
		lblYearlyInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYearlyInterestRate.setPreferredSize(new Dimension(100, 14));
		lblYearlyInterestRate.setBounds(48, 83, 181, 25);
		contentPane.add(lblYearlyInterestRate);

		JLabel lblNumberOfYears = new JLabel("Number of Years:");
		lblNumberOfYears.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberOfYears.setPreferredSize(new Dimension(100, 14));
		lblNumberOfYears.setBounds(48, 125, 181, 25);
		contentPane.add(lblNumberOfYears);

		JLabel lblFutureValue = new JLabel("Future Value:");
		lblFutureValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFutureValue.setPreferredSize(new Dimension(100, 14));
		lblFutureValue.setBounds(48, 173, 181, 25);
		contentPane.add(lblFutureValue);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(isValidData()){
				double p =  Double.parseDouble(getMonthlyPayment.getText());
				
				
				
				
				double r = Double.parseDouble(getInterestRate.getText());
				int y = Integer.parseInt(getNumberOfYears.getText());
				double futureValue = FinancialCalculations
						.calculateFutureValue(p, r, y);
				NumberFormat currency = NumberFormat.getCurrencyInstance();

				resultFutureValue.setText(currency.format(futureValue));
				}
			}
		});
		btnCalculate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalculate.setBounds(197, 233, 110, 30);
		contentPane.add(btnCalculate);

		btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(341, 233, 110, 30);
		contentPane.add(btnExit);

		getMonthlyPayment = new JTextField();
		getMonthlyPayment.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getMonthlyPayment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
		});
		getMonthlyPayment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getMonthlyPayment.setBounds(239, 43, 212, 25);
		contentPane.add(getMonthlyPayment);
		getMonthlyPayment.setColumns(10);

		getInterestRate = new JTextField();
		getInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getInterestRate.setColumns(10);
		getInterestRate.setBounds(239, 83, 212, 25);
		contentPane.add(getInterestRate);

		getNumberOfYears = new JTextField();
		getNumberOfYears.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getNumberOfYears.setColumns(10);
		getNumberOfYears.setBounds(239, 125, 212, 25);
		contentPane.add(getNumberOfYears);

		resultFutureValue = new JTextField();
		resultFutureValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resultFutureValue.setEditable(false);
		resultFutureValue.setColumns(10);
		resultFutureValue.setBounds(239, 173, 212, 25);
		contentPane.add(resultFutureValue);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				getMonthlyPayment, getInterestRate, getNumberOfYears,
				btnCalculate, btnExit }));
	}
	private boolean isValidData(){
		SwingValidator sv = new SwingValidator();
		return
				sv.isPresent(getMonthlyPayment, "Monthly Investment")&&
				sv.isDouble(getMonthlyPayment, "Monthly Investment")&&
				sv.isPresent(getInterestRate, "Interest Rate")&&
				sv.isDouble(getInterestRate, "Interest Rate")&&
				sv.isPresent(getNumberOfYears, "Number of Years")&&
				sv.isInteger(getNumberOfYears, "Number of Years");
	}
}
