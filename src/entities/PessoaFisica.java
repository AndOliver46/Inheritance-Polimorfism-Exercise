package entities;

public final class PessoaFisica extends Contribuinte {
	private Double healtyExpenditures;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String name, Double anualIncome, Double healtyExpenditures) {
		super(name, anualIncome);
		this.healtyExpenditures = healtyExpenditures;
	}

	public Double gethealtyExpenditures() {
		return healtyExpenditures;
	}

	public void sethealtyExpenditures(Double healtyExpenditures) {
		this.healtyExpenditures = healtyExpenditures;
	}

	@Override
	public double impostoPago() {
		double sum = 0;
		
		if(super.getanualIncome() < (double)20000) {
			sum = super.getanualIncome() * 15/100;
		}else{
			sum = super.getanualIncome() * 25/100;	
		}
		
		if(this.healtyExpenditures > 0) {
			sum -= this.healtyExpenditures * 50/100;
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(": $ ");
		builder.append(String.format("%.2f", impostoPago()));
		return builder.toString();
	}	
	

	
}
