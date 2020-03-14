package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/*
		o erxercico é pegar uma reserva, e depois atualizar a reserva,
		respeitando duas regras:
		- alterações das reservas só podem ocorrer para datas futuras
		- a data de saida deve ser maior que a data de entrada
		
		#2 soluçao- ruim (tratando as excessoes  sem try-cacth
		porem delegando a responsabilidade para a classe Reservation
		*/
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = scan.nextInt();
		scan.nextLine();// consumir a quebra de linha
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(scan.nextLine());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(scan.nextLine());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in resevation: check-out date munst be after check-in date");
		} else {
			Reservation res = new  Reservation(roomNumber, checkIn, checkOut);
			System.out.println(res);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.nextLine());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.nextLine());
			
			String error = res.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println(error);
			}else {
				System.out.println(res);
			}
		}
		scan.close();
	}
}
