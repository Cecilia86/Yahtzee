import java.util.ArrayList;

class Speler {
	ArrayList<String> worpGeschiedenis = new ArrayList<String>();
	
	void worp(String gevuldeCode) {  // voegt de worp toe aan de worpGeschiedenis array
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 5 ; i++) {
			sb.append(gevuldeCode.charAt(i)); 
			sb.append(" ");
		}
		String gevuldeCodeString = sb.toString();
		worpGeschiedenis.add(gevuldeCodeString);
	}
	
	void worpGeschiedenis() { // print de worpGeschiedenis array
		StringBuilder sb = new StringBuilder();
		 for(String geschiedenis : worpGeschiedenis) {
	            sb.append(" [ "+ geschiedenis+ "]");
	            sb.append(", ");
	        }
		 System.out.println("Tot nu toe geworpen: " + (sb.toString()));
		
	}

}

