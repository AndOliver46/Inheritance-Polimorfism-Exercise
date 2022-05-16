package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> contribuintesList = new ArrayList<>();;
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=0; i < n; i++) {	
			System.out.print("\nTax payer #" + (i+1) + " data: \n");
			System.out.print("Individual or company [i/c] ? ");
			char type = sc.next().charAt(0);
			
			if(type == 'i') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Healty expenditures: ");
				double healtyExpenditures = sc.nextDouble();
				
				Contribuinte contribuinte = new PessoaFisica(name, anualIncome, healtyExpenditures);
				contribuintesList.add(contribuinte);
			}else if(type == 'c'){
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Number of employees: ");
				int numFunc = sc.nextInt();
				
				Contribuinte contribuinte = new PessoaJuridica(name, anualIncome, numFunc);
				contribuintesList.add(contribuinte);
			}
		}
		
		System.out.println("\nTAXES PAID: \n");
		double taxesPaid = 0;
		for (Contribuinte x : contribuintesList) {
			System.out.println(x);
			taxesPaid += x.impostoPago();
		}
		System.out.println("\nTOTAL TAXES: " + String.format("%.2f", taxesPaid));
		
		sc.close();
	}

}
