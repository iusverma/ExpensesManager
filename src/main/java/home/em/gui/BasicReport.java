package home.em.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import home.em.base.Expenses;
import home.em.dal.ExpensesDAL;
import home.em.util.Utils;

public class BasicReport extends JFrame{
	List<Expenses> items;
	
	private void prepareDate(){
		//items = ExpensesDAL.findAll();
	}
	
	public void generateReport(){
		setLayout(new GridLayout(1, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] columnNames = {"DATE",
                "DETAILS",
                "EXPENDITURE",
                "ADDITIONAL DETAILS"};
		final JTable table = new JTable(getData(), columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
	    this.add(scrollPane, BorderLayout.CENTER);
	    this.setSize(500, 500);
	    this.setLocation(50,50);
	    this.setVisible(true);
	}
	
	private Object[][] getData(){
		items = ExpensesDAL.findAll();
		int totalRowsToDisplay = items.size()+1;
		String [][] data = new String[totalRowsToDisplay][4];
		int count = 0;
		Double totalExpenditure = new Double(0.0);
		for(Expenses e: items){
			if(e.getDate()!=null){
				data[count][0] = Utils.covertLongToDateStr(e.getDate());
				data[count][1] = e.getDetails();
				data[count][2] = e.getExpenditure().toString();
				data[count][3] = e.getAdditionalDetails();
				totalExpenditure += e.getExpenditure();
				count++;
			}
		}
		if(items.size()>0){		
			data[count][0] = "";
			data[count][1] = "Total till date";
			data[count][2] = totalExpenditure.toString();
			data[count][3] = "";
		}
		System.out.println("Total Expenditure: "+totalExpenditure);
		return data;
	}
}