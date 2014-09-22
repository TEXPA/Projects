


import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;



public class TeamLineUp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldplayer1;
	private JTextField textFieldplayer2;
	private JTextField textFieldplayer3;
	private JTextField textFieldplayer4;
	private JTextField textFieldplayer5;
	private JTextField textFieldplayer6;
	private JTextField textFieldplayer7;
	private JTextField textFieldplayer8;
	private JTextField textFieldplayer9;
	private JTextField txtTeamname;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamLineUp frame = new TeamLineUp();
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
	public TeamLineUp() {
		setTitle("Lineup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTeamInformation = new JLabel("Team Information");
		lblTeamInformation.setBounds(32, 11, 111, 14);
		contentPane.add(lblTeamInformation);

		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setBounds(20, 51, 89, 14);
		contentPane.add(lblTeamName);

		JRadioButton rdbtnHome = new JRadioButton("Home");
		rdbtnHome.setBounds(237, 48, 67, 14);
		contentPane.add(rdbtnHome);

		JRadioButton rdbtnVisitor = new JRadioButton("Visitor");
		rdbtnVisitor.setBounds(325, 48, 109, 14);
		contentPane.add(rdbtnVisitor);
		
		ButtonGroup gameLocation = new ButtonGroup();
		gameLocation.add(rdbtnHome);
		gameLocation.add(rdbtnVisitor);
		

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 414, 2);
		contentPane.add(separator);

		JLabel label = new JLabel("1:");
		label.setBounds(20, 106, 17, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("2:");
		label_1.setBounds(20, 146, 17, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("3:");
		label_2.setBounds(20, 186, 17, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("4:");
		label_3.setBounds(20, 226, 17, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("5:");
		label_4.setBounds(20, 266, 17, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("6:");
		label_5.setBounds(20, 306, 17, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("7:");
		label_6.setBounds(20, 346, 17, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("8:");
		label_7.setBounds(20, 386, 17, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("9:");
		label_8.setBounds(20, 426, 17, 14);
		contentPane.add(label_8);

		textFieldplayer1 = new JTextField();
		textFieldplayer1.setBounds(46, 103, 143, 20);
		contentPane.add(textFieldplayer1);
		textFieldplayer1.setColumns(10);

		textFieldplayer2 = new JTextField();
		textFieldplayer2.setColumns(10);
		textFieldplayer2.setBounds(46, 143, 143, 20);
		contentPane.add(textFieldplayer2);

		textFieldplayer3 = new JTextField();
		textFieldplayer3.setColumns(10);
		textFieldplayer3.setBounds(46, 183, 143, 20);
		contentPane.add(textFieldplayer3);

		textFieldplayer4 = new JTextField();
		textFieldplayer4.setColumns(10);
		textFieldplayer4.setBounds(46, 223, 143, 20);
		contentPane.add(textFieldplayer4);

		textFieldplayer5 = new JTextField();
		textFieldplayer5.setColumns(10);
		textFieldplayer5.setBounds(46, 263, 143, 20);
		contentPane.add(textFieldplayer5);

		textFieldplayer6 = new JTextField();
		textFieldplayer6.setColumns(10);
		textFieldplayer6.setBounds(46, 303, 143, 20);
		contentPane.add(textFieldplayer6);

		textFieldplayer7 = new JTextField();
		textFieldplayer7.setColumns(10);
		textFieldplayer7.setBounds(46, 343, 143, 20);
		contentPane.add(textFieldplayer7);

		textFieldplayer8 = new JTextField();
		textFieldplayer8.setColumns(10);
		textFieldplayer8.setBounds(46, 383, 143, 20);
		contentPane.add(textFieldplayer8);

		textFieldplayer9 = new JTextField();
		textFieldplayer9.setColumns(10);
		textFieldplayer9.setBounds(46, 423, 143, 20);
		contentPane.add(textFieldplayer9);

		String[] positions = {"Center Field", "Left Field", "Right Field",
				"Pitcher", "Catcher", "First Base", "Second Base",
				"Third Base", "Short Stop"};
		
		
		JComboBox comboBoxplayer1 = new JComboBox(positions);
		comboBoxplayer1.setBounds(270, 103, 143, 20);
		contentPane.add(comboBoxplayer1);
		
	  	JComboBox comboBoxplayer2 = new JComboBox(positions);
		comboBoxplayer2.setBounds(270, 143, 143, 20);
		contentPane.add(comboBoxplayer2);
		
		JComboBox comboBoxplayer3 = new JComboBox(positions);
		comboBoxplayer3.setBounds(270, 183, 143, 20);
		contentPane.add(comboBoxplayer3);

		JComboBox comboBoxplayer4 = new JComboBox(positions);
		comboBoxplayer4.setBounds(270, 223, 143, 20);
		contentPane.add(comboBoxplayer4);

		JComboBox comboBoxplayer5 = new JComboBox(positions);
		comboBoxplayer5.setBounds(270, 263, 143, 20);
		contentPane.add(comboBoxplayer5);

		JComboBox comboBoxplayer6 = new JComboBox(positions);
		comboBoxplayer6.setBounds(270, 303, 143, 20);
		contentPane.add(comboBoxplayer6);

		JComboBox comboBoxplayer7 = new JComboBox(positions);
		comboBoxplayer7.setBounds(270, 343, 143, 20);
		contentPane.add(comboBoxplayer7);

		JComboBox comboBoxplayer8 = new JComboBox(positions);
		comboBoxplayer8.setBounds(270, 383, 143, 20);
		contentPane.add(comboBoxplayer8);

		JComboBox comboBoxplayer9 = new JComboBox(positions);
		comboBoxplayer9.setBounds(270, 423, 143, 20);
		contentPane.add(comboBoxplayer9);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


String lineup = (" Team : "+txtTeamname.getText() + "  " +  "\n\n" +
				textFieldplayer1.getText() + ", "
						+ comboBoxplayer1.getSelectedItem() + "\n"
						+ textFieldplayer2.getText() + ", "
						+ comboBoxplayer2.getSelectedItem() + "\n"
						+ textFieldplayer3.getText() + ", "
						+ comboBoxplayer3.getSelectedItem() + "\n"
						+ textFieldplayer4.getText() + ", "
						+ comboBoxplayer4.getSelectedItem() + "\n"
						+ textFieldplayer5.getText() + ", "
						+ comboBoxplayer5.getSelectedItem() + "\n"
						+ textFieldplayer6.getText() + ", "
						+ comboBoxplayer6.getSelectedItem() + "\n"
						+ textFieldplayer7.getText() + ", "
						+ comboBoxplayer7.getSelectedItem() + "\n"
						+ textFieldplayer8.getText() + ", "
						+ comboBoxplayer8.getSelectedItem() + "\n"
						+ textFieldplayer9.getText() + ", "
						+ comboBoxplayer9.getSelectedItem() + "\n");

				if (isValidData()) {

					JOptionPane.showMessageDialog(null, lineup, "Roster",
							JOptionPane.PLAIN_MESSAGE);

				}
			}
		});
		btnNewButton.setBounds(182, 486, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(300, 486, 89, 23);
		contentPane.add(btnNewButton_1);

		txtTeamname = new JTextField();
		txtTeamname.setBounds(106, 48, 125, 20);
		contentPane.add(txtTeamname);
		txtTeamname.setColumns(10);

	}

	private boolean isValidData() {
		SwingValidator sv = new SwingValidator();
		return

		sv.isPresent(txtTeamname, "Team Name")
				&& sv.isPresent(textFieldplayer1, "Name Player 1")
				&& sv.isPresent(textFieldplayer2, "Name Player 2")
				&& sv.isPresent(textFieldplayer3, "Name Player 3")
				&& sv.isPresent(textFieldplayer4, "Name Player 4")
				&& sv.isPresent(textFieldplayer5, "Name Player 5")
				&& sv.isPresent(textFieldplayer6, "Name Player 6")
				&& sv.isPresent(textFieldplayer7, "Name Player 7")
				&& sv.isPresent(textFieldplayer8, "Name Player 8")
				&& sv.isPresent(textFieldplayer9, "Name Player 9");

	}
}
