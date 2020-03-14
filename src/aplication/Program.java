package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		/*
		o erxercico é pegar uma reserva, e depois atualizar a reserva,
		respeitando duas regras:
		- alterações das reservas só podem ocorrer para datas futuras
		- a data de saida deve ser maior que a data de entrada
		
		#3 soluçao- boa (tratando as excessoes  com try-cacth
		e delegando a responsabilidade para a classe Reservation
		*/
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt();
			scan.nextLine();// consumir a quebra de linha
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(scan.nextLine());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(scan.nextLine());
			
			
			Reservation res = new  Reservation(roomNumber, checkIn, checkOut);
			System.out.println(res);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.nextLine());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.nextLine());
			
			res.updateDates(checkIn, checkOut);
			
			System.out.println(res);
		}catch(ParseException e) {
			System.out.println("invalide data format");
		}catch(DomainException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			/*podemos ainda para nao quebrar o programa usar
			*a super classe RunTimeException para tratar todas
			as excessoes desse tipo(em tempo de execucao*/
			System.out.println("Unexpected error");
		}finally {
			scan.close();
		}
	}
}
