package vn.edu.ptit;

public class Rule {
	private String code;
	private String name;
	private double creditPrice;
	
	public Rule(String code, String name, double creditPrice) {
		this.code = code;
		this.name = name;
		this.creditPrice = creditPrice;
	}

	public Rule() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCreditPrice() {
		return creditPrice;
	}

	public void setCreditPrice(double creditPrice) {
		this.creditPrice = creditPrice;
	}

}
