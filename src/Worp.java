class Worp {
	
	int uitslag(int gevuldeCode) {  //deze methode zet code om in een string zodat deze geprint kan worden met spaties er tussen
		StringBuilder sb = new StringBuilder();
		String codeString = Integer.toString(gevuldeCode);
		for(int i = 0 ; i < 5 ; i++) {
			sb.append(codeString.charAt(i)); 
			sb.append(" ");
		}
		
		System.out.println("Je hebt gegooid: " + (sb.toString()));
		return gevuldeCode;  // code gaat zonder spaties weer terug
	}
}

