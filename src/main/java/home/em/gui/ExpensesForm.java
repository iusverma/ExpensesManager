package home.em.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import home.em.base.Expenses;
import home.em.dal.ExpensesDAL;

public class ExpensesForm extends JFrame{
	private  JLabel lDetails;
	private  JTextField tDetails;
	private  JLabel lAmount;
	private  JTextField tAmount;
	private  JLabel lAdditionalDetails;
	private  JTextField tAdditionalDetails;
	private  JButton bSubmit;
	
	public void start() {
		setLayout(new GridLayout(5, 2));

		lDetails = new JLabel("Details");
		add(lDetails);
		tDetails =new JTextField(50);
		add(tDetails);

		lAmount = new JLabel("Amount");
		add(lAmount);
		tAmount =new JTextField(50);
		add(tAmount);

		lAdditionalDetails = new JLabel("Additional Details");
		add(lAdditionalDetails);
		tAdditionalDetails =new JTextField(50);
		add(tAdditionalDetails);
		
		bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitDetails(
						tDetails.getText(),
						tAmount.getText(),
						tAdditionalDetails.getText());
				resetForm();
			}
		});
		add(bSubmit);

		setSize(400, 200);
		setLocation(250, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private  void submitDetails(String details, String amount, String additionalDetails){
		Expenses exp = new Expenses();
		//exp.setDate((new Date()));
		exp.setDetails(details);
		exp.setExpenditure(new Double(amount));
		exp.setAdditionalDetails(additionalDetails);
		ExpensesDAL.insert(exp);
		
		// Print message for user
		String message = details + ":" 
						+ amount + ":" 
						+ additionalDetails
						+ ", submitted";
		System.out.println(message);
		//Message f = new Message(message);
		//f.start();	
	}
	
	private  void resetForm(){
		tDetails.setText("");
		tAmount.setText("");
		tAdditionalDetails.setText("");
	}
}
