package home.em.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainForm extends JPanel{
	
	public MainForm(){
		super(new GridLayout(1,1));
	}

	private JComponent prepareTabs(){		
		JTabbedPane mainForm = new JTabbedPane();
	
		JComponent panel1 = makeTextPanel("Expenses");
		mainForm.add("Expenses",panel1);
		
		JComponent panel2 = makeTextPanel("Reports");
		mainForm.add("Reports",panel2);
		
		mainForm.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(mainForm);
		
		return mainForm;
	}
			
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        System.out.println("Creating tab for: "+text);
        if(text.equalsIgnoreCase("Expenses")){
	        ExpensesForm ef = new ExpensesForm();
	        panel.add(ef.getContentPane());
        }else{
	        BasicReport br = new BasicReport();
	        panel.add(br.getContentPane());
        }
        return panel;
    }
	
	public void init(){
		JFrame frame = new JFrame("MainForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(prepareTabs(),BorderLayout.CENTER);
		frame.pack();
		frame.setSize(1600, 900);
		frame.setVisible(true);
	}
	
}
