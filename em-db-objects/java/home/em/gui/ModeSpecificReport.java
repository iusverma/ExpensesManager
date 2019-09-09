package home.em.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import home.em.base.Expenses;
import home.em.dal.ExpensesDAL;
import home.em.util.Utils;

public class ModeSpecificReport extends BasicReport{
	private String mode;
	
	public ModeSpecificReport(String mode){
		this.mode = mode;
	}

	protected Object[][] getData(){
		items = ExpensesDAL.findWithMode(mode);
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
