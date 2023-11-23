package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.println("Data do Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy) ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reserva = new Reservas(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.println("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e ){
			System.out.println("Formato da data invalido");
		}
		catch (DomainException e) {
			System.out.println("Erro em reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro não esperado! ");
		}
		
		sc.close();
	}

}
