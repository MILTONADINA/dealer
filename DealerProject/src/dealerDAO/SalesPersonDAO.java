package dealerDAO;

import java.util.List;
import dealerPD.SalesPerson;
import jakarta.persistence.*;
public class SalesPersonDAO {

	public static void addsalesPerson(SalesPerson salesPerson)
	{
		emDAO.getEM().persist(salesPerson);
	}
		
	public static void savesalesPerson(SalesPerson salesPerson) {
		emDAO.getEM().persist(salesPerson);
		
	}

	public static List<SalesPerson> listsalesPerson()
	{
		TypedQuery<SalesPerson> query = emDAO.getEM().createQuery(
				"SELECT salesPerson FROM salesPerson salesPerson", SalesPerson.class);
		return query.getResultList();
	}

	public static SalesPerson findsalesPersonById(int id)
	{
		SalesPerson salesPerson = emDAO.getEM().find(SalesPerson.class, new Integer(id));
		return salesPerson;
	}
	
	public static void removesalesPerson(SalesPerson salesPerson)
	{
		emDAO.getEM().remove(salesPerson);
	}
}
