package home.em.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import home.em.base.Expenses;
import home.em.dal.ExpensesDAL;
import home.em.util.Utils;

public class BasicReport extends JFrame {
	List<Expenses> items;
	private JButton bSubmit;
	private JTable table;

	public BasicReport() {
		System.out.println("Beta 1.0, Only current month data is displayed!!!");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bSubmit = new JButton("Submit");
		bSubmit.setSize(150, 50);
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateReport();
			}
		});
		add(bSubmit);
		// Following code is when unit testing is done
		// this.setSize(1024, 768);
		// this.setLocation(25,25);
		// this.setVisible(true);
		// generateReport();
		revalidate();
		repaint();
	}

	public void generateReport() {
		String[] columnNames = { "DATE", "DETAILS", "EXPENDITURE", "ADDITIONAL DETAILS" };
		table = new JTable(getData(), columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setVisible(true);
	}

	protected Object[][] getData() {
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);
		System.out.println("Current Month is: " +Integer.toString(currentMonth));
		items = ExpensesDAL.findAllAfterDate(currentMonth);
		int totalRowsToDisplay = items.size() + 1;
		String[][] data = new String[totalRowsToDisplay][4];
		int count = 0;
		Double totalExpenditure = new Double(0.0);
		for (Expenses e : items) {
			if (e.getDate() != null) {
				data[count][0] = Utils.covertLongToDateStr(e.getDate());
				data[count][1] = e.getDetails();
				data[count][2] = e.getExpenditure().toString();
				data[count][3] = e.getAdditionalDetails();
				totalExpenditure += e.getExpenditure();
				count++;
			}
		}
		if (items.size() > 0) {
			data[count][0] = "";
			data[count][1] = "Total till date";
			data[count][2] = totalExpenditure.toString();
			data[count][3] = "";
		}
		System.out.println("Total Expenditure: " + totalExpenditure);
		return data;
	}
}
