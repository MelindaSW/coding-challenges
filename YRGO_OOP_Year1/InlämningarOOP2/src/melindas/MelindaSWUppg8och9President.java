package melindas;

public class MelindaSWUppg8och9President {

	private String president;
	private int year;
	
	public MelindaSWUppg8och9President(String president, int year) {
		this.president = president;
		this.year = year;
	}
	
	public String getPresident() {

		return president;
	}
	
	public int getYear() {

		return year;
	}
	
	@Override
	public String toString() {

		return getPresident() + " " + getYear();
	}
}
