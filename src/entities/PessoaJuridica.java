package entities;

public final class PessoaJuridica extends Contribuinte {
	private Integer numFunc;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String name, Double anualIncome, Integer numFunc) {
		super(name, anualIncome);
		this.numFunc = numFunc;
	}

	public Integer getNumFunc() {
		return numFunc;
	}

	public void setNumFunc(Integer numFunc) {
		this.numFunc = numFunc;
	}

	@Override
	public double impostoPago() {
		double sum = 0;
		
		if(this.numFunc <= (int)10) {
			sum = anualIncome * 16/100;
		}else {
			sum = anualIncome * 14/100;
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(": $ ");
		builder.append(String.format("%.2f", this.impostoPago()));
		return builder.toString();
	}	
}
