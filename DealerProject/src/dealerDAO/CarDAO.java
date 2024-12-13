package dealerDAO;

import java.util.List;
import dealerPD.Car;
import jakarta.persistence.*;
public class CarDAO {

	public static void addCar(Car Car)
	{
		emDAO.getEM().persist(Car);
	}
		
	public static void saveCar(Car Car) {
		emDAO.getEM().persist(Car);
		
	}

	public static List<Car> listCar()
	{
		TypedQuery<Car> query = emDAO.getEM().createQuery(
				"SELECT car FROM car car", Car.class);
		return query.getResultList();
	}

	public static Car findCarById(int id)
	{
		Car Car = emDAO.getEM().find(Car.class, new Integer(id));
		return Car;
	}
	
	public static void removeCar(Car Car)
	{
		emDAO.getEM().remove(Car);
	}
}
