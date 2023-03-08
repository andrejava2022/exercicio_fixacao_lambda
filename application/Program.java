package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	
	public static void main(String[]args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			List<Employee> list = new ArrayList<>();
			String line = br.readLine();
			
			while(line != null) {
				String[]fields = line.split(",");
				list.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f",salary)+":");
			
			List<String> emails = list.stream()
							.filter(p -> p.getSalary()> salary)
							.map(p -> p.getEmail())
							.sorted(comp)
							.collect(Collectors.toList());
 
			emails.forEach(System.out::println);
			
			Double salarys = list.stream()
					     .filter(p -> p.getName().charAt(0) == 'A')
					     .map(p -> p.getSalary())
					     .reduce(0.0, (x,y) -> x+y);
					    
			System.out.println("Sum of salary of people whose name starts with 'A': "  +
			                    String.format("%.2f",salarys));
	       
					     
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
/*
 Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.
Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.
Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'.
Veja exemplo na próxima página
*/
