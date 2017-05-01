package expensesmanager;

import org.hibernate.Session;

import home.em.base.Expenses;
import home.em.util.HibernateUtil;

public class ExpensesTest {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (XML mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Expenses expenses = new Expenses();
		expenses.setDate(getCurrentDate());
		expenses.setDetails("Mall stuff");
		expenses.setExpenditure(30.9);
		expenses.setAdditionalDetails("AMEX");

		session.save(expenses);
		session.getTransaction().commit();

		System.out.println("Done");
		
//		Query query = session.createQuery("from Stock where stockCode = :code ");
//		query.setParameter("code", "4717");
//		List list = query.list();
//		
//		for(Object obj: list){
//			Stock st = (Stock)obj;
//			System.out.print(st.getStockCode() +", ");
//			System.out.print(st.getStockName() +", ");
//			System.out.print(st.getStockDetail() +", ");
//			System.out.println(st.getStockId());
//		}
	}
	
	private static long getCurrentDate(){
		return 1493550887;
	}
}
