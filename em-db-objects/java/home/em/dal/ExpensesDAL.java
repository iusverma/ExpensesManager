package home.em.dal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	public static List<Expenses> findWithMode(String mode){
		System.out.println("[ExpensesDAL.findAll] Reading all db entires for EXPENSES table.");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Expenses where additional_details = :additional_details");
		query.setParameter("additional_details", mode);
		List<Expenses> list = new ArrayList<Expenses>(query.list());
		return list;
	}

	public static List<Expenses> findAllAfterDate(int month){
		System.out.println("[ExpensesDAL.findAll] Reading monthly db entires for EXPENSES table.");
		long date = getMonthsStartDateAndTime(month);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Expenses where date > :date");
		query.setParameter("date", date);
		List<Expenses> list = new ArrayList<Expenses>(query.list());
		return list;
	}

	public static long getMonthsStartDateAndTime(int month){
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		@SuppressWarnings("deprecation")
		Date d = new Date((currentYear-1900), month,1);
		System.out.println("Time for first day of " +month+" is " +d.getTime());
		System.out.println("In readable format is is " +d.toString());
		return d.getTime();
	}
}
