package melindas;

public class MelindaSInl10Observation {
//	Instansvariabler:
	private int nr, tim, min;
	private double temp, vindhast, vindriktning;
//	Kontruktor:
	public MelindaSInl10Observation() {
	}
//	Setters och getters för instansvariablerna:
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public int getTim() {
		return tim;
	}
	public void setTim(int tim) {
		this.tim = tim;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getVindhast() {
		return vindhast;
	}
	public void setVindhast(double vindhast) {
		this.vindhast = vindhast;
	}
	public double getVindriktning() {
		return vindriktning;
	}
	public void setVindriktning(double vindriktning) {
		this.vindriktning = vindriktning;
	}
//	Metod som returnerar vilken riktning vinden kommer ifrån beroende på vilket gradantal som anges i vindriktningen.
	public String returnRiktning() {
		
		if (vindriktning >= 0 && vindriktning <= 11.25 || vindriktning > 348.75 && vindriktning <=360) {
			return "N"; 
		}
		else if (vindriktning > 11.25 && vindriktning <= 33.75) {
			return "NNO";
		}
		else if (vindriktning > 33.75 && vindriktning <= 56.25) {
			return "NO";
		}
		else if (vindriktning > 56.25 && vindriktning <= 78.75) {
			return "ONO";
		}
		else if (vindriktning > 78.75 && vindriktning <= 101.25) {
			return "Ö";
		}
		else if (vindriktning > 101.25 && vindriktning <= 123.75) {
			return "OSO";
		}
		else if (vindriktning > 123.75 && vindriktning <= 146.25) {
			return "SO";
		}
		else if (vindriktning > 146.25 && vindriktning <= 168.75) {
			return "SSO";
		}
		else if (vindriktning > 168.75 && vindriktning <= 191.25) {
			return "S";
		}
		else if (vindriktning > 191.25 && vindriktning <= 213.75) {
			return "SSV";
		}
		else if (vindriktning > 213.75 && vindriktning <= 236.25) {
			return "SV";
		}
		else if (vindriktning > 236.25 && vindriktning <= 258.75) {
			return "VSV";
		}
		else if (vindriktning > 258.75 && vindriktning <= 281.25) {
			return "V";
		}
		else if (vindriktning > 281.25 && vindriktning <= 303.75) {
			return "VNV";
		}
		else if (vindriktning > 303.75 && vindriktning <= 326.25) {
			return "NV";
		}
		else if (vindriktning > 326.25 && vindriktning <= 348.75) {
			return "NNV";
		}
		else {
			return "//Felaktigt gradanatal i vindriktningen//";
		}
	}
}
