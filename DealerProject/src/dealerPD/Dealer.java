package dealerPD;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import dealerDAO.CarDAO;
import dealerDAO.SalesPersonDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "dealer")

public class Dealer  implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id //signifies the primary key
  @Column(name = "dealer_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long dealerID;

  @Column(name = "name", nullable = false,length = 50)
  private String name;
  
  @Column(name = "address", nullable = false,length = 50)
  private String address;
  
  @Column(name = "city", nullable = false,length = 50)
  private String city;
  
  @Column(name = "state", nullable = false,length = 2)
  private String state;
  
  @Column(name = "zip", nullable = false,length = 10)
  private String zip;
  
  @OneToMany(mappedBy="dealer",targetEntity=Car.class,
			fetch=FetchType.EAGER)
	private Collection<Car> cars;
  
  @OneToMany(mappedBy="dealer",targetEntity=SalesPerson.class,
			fetch=FetchType.EAGER)
	private Collection<SalesPerson> salesPersons;
  
  public Dealer() {
    
  }
  
  public Dealer(String name, String address, String city, String state, String zip)
  {
    this();
    this.setName(name);
    this.setAddress(address);
    this.setCity(city);
    this.setState(state);
    this.setZip(zip);
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getZip() {
    return zip;
  }
  public void setZip(String zip) {
    this.zip = zip;
  }
  public Collection<Car> getCars() {
    return cars;
  }
  
  public Collection<SalesPerson> getSalesPersons() {
    return salesPersons;
  }
  
  public long getDealerID() {
		return dealerID;
	}

	public void setDealerID(long dealerID) {
		this.dealerID = dealerID;
	}
  
  public void addCar(Car car) 
  {
	car.setDealer(this);
    CarDAO.addCar(car);  
    }
  
  public void removeCar(Car car)
  {
    CarDAO.removeCar(car);
  }
  
  public void addSalesPerson(SalesPerson salesPerson)
  {
    salesPerson.setDealer(this);
    SalesPersonDAO.addsalesPerson(salesPerson);
  }
  public void removeSalesPerson(SalesPerson salesPerson)
  
  {
    SalesPersonDAO.removesalesPerson(salesPerson);
  }
  
  public int getCarForSaleCount() {
    int count = 0;
    if(getCars() == null) return count;
    for (Car car : getCars()) {
      if (car.getDateSold() == null) count =count+1;
    }
    return count;
     
  }
  
  public int getCarsSoldThisMonth() {
    int count = 0;
    for (Car car : getCars()) {
      if ((car.getDateSold().getMonth()== LocalDate.now().getMonth()) &&
              (car.getDateSold().getYear() == LocalDate.now().getYear())) count =count+1;
    }
    return count;
  }
  
    public BigDecimal getDollarsSoldThisMonth() {
      BigDecimal amount = new BigDecimal("0.00");
      for (Car car : getCars()) {
        if ((car.getDateSold().getMonth()== LocalDate.now().getMonth()) &&
                (car.getDateSold().getYear() == LocalDate.now().getYear())) 
                  amount = amount.add(car.getPrice());
      }
      return amount;
     
  }
  
  public String toString() {
    return getName();
  }
}
