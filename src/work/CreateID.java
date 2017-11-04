package work;
/**
 * Ovde ide opis 
 * @author Nemanja
 */
public class CreateID {
	private static int id = 0;
	public static int getNewID(){
		return id++;
	}
}
