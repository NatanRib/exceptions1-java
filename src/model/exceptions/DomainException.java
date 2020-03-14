package model.exceptions;

public class DomainException extends Exception{
	/*essa é a excessao personalizada, apenas vamos passar
	 * uma msg para a super classe
	 */
	
	private static final long serialVersionUID = 1L;
	// essa classe por herdar de exception precisa de um ID
	
	public DomainException(String msg) {
		super(msg);
	}
}
