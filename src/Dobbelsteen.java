class Dobbelsteen {
	int werpen(int beginCode) { 				//methode voor diceroll
		int dice = (int) (Math.random() * 6 + 1);
		return dice;
	}
	

	String vervolgWerpen(String code) {
		if (code.contains("0")) {					 // eerst in de terug gekomen code controleren hoeveel 0's er voor komen. Deze
			char zoeken = '0'; 						// moeten opnieuw gegooid worden.
			int count = 0;
			
			for (int i = 0; i < code.length(); i++) { // telt aantal 0 en slaat dit getal op in count
				if (code.charAt(i) == zoeken) {
					count++;
				} else {
				break;
				}
			}
			
			for (int i = 0; i <= count; i++) { // gaat voor het aantal count de dobbelstenen opnieuw gooien
				int dice = (int) ((Math.random() * 6 + 1));
			}
		}
		return code;
	}
}