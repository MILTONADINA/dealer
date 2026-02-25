package dealerPD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import dealerDAO.CarDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "salesperson")

public class SalesPerson implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id //signifies the primary key
  @Column(name = "sales_person_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long salesPersonID;

  @Column(name = "name", nullable = false,length = 50)
  private String name;
  
  @Column(name = "position", nullable = false,length = 50)
  private String position;
  
  @OneToMany(mappedBy="salesPerson",targetEntity=Car.class,
			fetch=FetchType.EAGER)
  private Collection<Car> cars;
  
  @ManyToOne(optional=false)
  @JoinColumn(name="dealer_id",referencedColumnName="dealer_id")
  private Dealer dealer;

  public SalesPerson(){
      
   }
  
  public SalesPerson( String name, String position) {
    this();
    this.setName(name);
    this.setPosition(position);
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public Collection<Car> getCars() {
    return cars;
  }
  
  public long getSalesPersonID() {
		return salesPersonID;
	}

  public void setSalesPersonID(long salesPersonID) {
	this.salesPersonID = salesPersonID;
	}
	
  public Dealer getDealer() {
	return dealer;
	}

  public void setDealer(Dealer dealer) {
		this.dealer = dealer;
  	}


  public void addCar(Car car) {
	car.setSalesPerson(this);
    CarDAO.addCar(car);
  }
  
  public void removeCar(Car car)
  {
    CarDAO.removeCar(car);
  }
  
  public boolean isOkToRemove() {
    if (getCars().size() == 0) return true; else return false;
  }
  
  public String toString() {
    return getName()+ " "+getPosition();
  }
}
