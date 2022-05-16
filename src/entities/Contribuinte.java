package entities;

public abstract class Contribuinte {
	protected String name;
	protected Double anualIncome;
	
	public Contribuinte() {
	}

	public Contribuinte(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getanualIncome() {
		return anualIncome;
	}

	public void setanualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	public abstract double impostoPago();

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(": $ ");
		builder.append(String.format("%.2f", this.impostoPago()));
		return builder.toString();
	}
	
	
}
