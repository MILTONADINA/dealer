package dealerDAO;

import java.util.List;
import dealerPD.Dealer;
import jakarta.persistence.*;
public class DealerDAO {

	public static void addDealer(Dealer Dealer)
	{
		emDAO.getEM().persist(Dealer);
	}
		
	public static void saveDealer(Dealer Dealer) {
		emDAO.getEM().persist(Dealer);
		
	}

	public static List<Dealer> listDealer()
	{ 
		TypedQuery<Dealer> query = emDAO.getEM().createQuery(
				"SELECT dealer FROM dealer dealer", Dealer.class);
		return query.getResultList();
	}

	public static Dealer findDealerById(int id)
	{
		Dealer Dealer = emDAO.getEM().find(Dealer.class, new Integer(id));
		return Dealer;
	}
	
	public static void removeDealer(Dealer Dealer)
	{
		emDAO.getEM().remove(Dealer);
	}
}
