package PrimaryService;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	private Integer id;
	private double convFactor;

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getConvFactor() {
		return convFactor;
	}

	public void setConvFactor(double convFactor) {
		this.convFactor = convFactor;
	}

	public Currency(Integer id, double convFactor) {
		super();
		this.id = id;
		this.convFactor = convFactor;
	}

	
}
