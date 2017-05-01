package expensesmanager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import home.em.base.Expenses;
import home.em.dal.ExpensesDAL;
import home.em.util.HibernateUtil;
import home.em.util.Utils;

public class ExpensesTest {
	public static void main(String[] args) {
		List list = ExpensesDAL.findAll();
		for(Object obj: list){
			Expenses exp = (Expenses)obj;
			System.out.print("{");
			System.out.print(exp.getDetails() +", ");
			System.out.print(exp.getExpenditure() +", ");
			System.out.print(exp.getAdditionalDetails() +", ");
			System.out.print(Utils.covertLongToDateStr(exp.getDate()));
			System.out.print("}");
			System.out.println();
		}
	}
}
