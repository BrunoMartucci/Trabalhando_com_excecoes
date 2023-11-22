package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.println("Data do Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (dd/MM/yyyy) ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.print("Data do Check-in nao pode ser mais que a do Check-out!");
		}
		else {
			Reservas reserva = new Reservas(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.println("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: Para realizar a atualização a reserva precisa ser futura! ");
			}
			else if ( !checkOut.after(checkIn)) {
				System.out.println("Data do Check-in nao pode ser mais que a do Check-out! ");
			}
			else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
			
			
		}
		
		
		sc.close();
	}

}
