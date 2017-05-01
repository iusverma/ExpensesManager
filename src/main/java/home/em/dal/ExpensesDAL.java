package home.em.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import home.em.base.Expenses;
import home.em.util.HibernateUtil;
import home.em.util.Utils;

public class ExpensesDAL {
	public static void insert(Expenses exp){
		System.out.println("[ExpensesDAL.insert] Inserting Expenses details in db");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Expenses expenses = new Expenses();
		expenses.setDate(Utils.getCurrentDate());
		expenses.setDetails(exp.getDetails());
		expenses.setExpenditure(exp.getExpenditure());
		expenses.setAdditionalDetails(exp.getAdditionalDetails());

		session.save(expenses);
		session.getTransaction().commit();

		System.out.println("Done");
	}

	public static List<Expenses> findAll(){
		System.out.println("[ExpensesDAL.findAll] Reading all db entires for EXPENSES table.");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Expenses");
		List<Expenses> list = new ArrayList<Expenses>(query.list());
		return list;
	}
}
