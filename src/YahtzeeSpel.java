import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class YahtzeeSpel {
	ArrayList<Integer> dobbelstenen = new ArrayList<Integer>();
	int[] blokkeer = new int[5];
	int[] dice = new int[5];

	YahtzeeSpel() {			// vult in eerste instantie de dice array met waarden
		Dobbelsteen dobbelsteen = new Dobbelsteen();
		// int[] dice = new int[5];
		int j = 0;

		for (int i = 0; i < dice.length; i++) {
			dice[i] = dobbelsteen.werpen(j);
			dobbelstenen.add(dice[i]);
		}
	}

	void introSpel() { //uitleg spel
		System.out.println("Welkom bij het spel Yahtzee!");
		System.out.println();
		System.out.println(
				"Bij dit spel is het de bedoeling dat je binnen 10 beurten 5 dobbelstenen met de zelfde waarde bij elkaar gaat rollen.");
		System.out.println("Na de eerste rol mag je naar keuze de dobbelstenen houden of opnieuw gooien.");
		System.out.println("Bij 5 dezelfde dobbelstenen heb je Yahtzee en gewonnen!");
		System.out.println();
		System.out.println("Klaar om te beginnen?");
	}

	String spelen(String code) { 		//hierin worden de nieuwe codes aangemaakt
		String finalCode = "0";
		StringBuilder sb = new StringBuilder();
		int[] dice = new int[5];

		while (true) {
			Dobbelsteen dobbelsteen = new Dobbelsteen();
			System.out.println("Druk op <enter> om de dobbelstenen te gaan gooien, of <q> om te stoppen!");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			if (input.contentEquals("q")) {
				finalCode = "q";
				return finalCode;
			}
			if (input.isEmpty() && code.contentEquals("00000")) {
				dice[0] = dobbelsteen.werpen(Integer.parseInt(code));
				dice[1] = dobbelsteen.werpen(Integer.parseInt(code));
				dice[2] = dobbelsteen.werpen(Integer.parseInt(code));
				dice[3] = dobbelsteen.werpen(Integer.parseInt(code));
				dice[4] = dobbelsteen.werpen(Integer.parseInt(code));

				StringBuilder builder = new StringBuilder();
				builder.append(dice[0]);
				builder.append(dice[1]);
				builder.append(dice[2]);
				builder.append(dice[3]);
				builder.append(dice[4]);

				finalCode = builder.toString();
				return finalCode;
			} else {
				String temp = code;
				int[] codeArr = new int[temp.length()];
				for (int i = 0; i < temp.length(); i++) {
					codeArr[i] = temp.charAt(i) - '0';
				}
				for (int i = 0; i < codeArr.length; i++) {
					if (codeArr[i] == 0) {
						dice[i] = dobbelsteen.werpen(Integer.parseInt(code));
					}
					if (codeArr[i] != 0) {
						dice[i] = codeArr[i];
					}
				}
				StringBuilder builder = new StringBuilder();
				builder.append(dice[0]);
				builder.append(dice[1]);
				builder.append(dice[2]);
				builder.append(dice[3]);
				builder.append(dice[4]);

				finalCode = builder.toString();
				return finalCode;
			}
		}
	}

	

	String vasthouden(String finalCode) { // deze methode heeft 3 arrays; [blokkeer] array, de vastgehouden [dice] array en
											// de huidige [worp] array.
		String toPrintCode = "0";
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int[] dice = new int[blokkeer.length]; // onthoud waarde van vastgehouden dice
		Scanner scanner = new Scanner(System.in);
		String invoerString;

		while (true) { // deze loop controleert of de speler invoer wel 0 of 1 is
			System.out.println("Welke index posities wil je houden? 1= houden, 0= opnieuw gooien");
			invoerString = scanner.nextLine();
			Worp worp = new Worp();

			if (invoerString.isEmpty()) { // geen invoer
				System.out.println("Ongeldige code.");
				System.out.println();
				worp.uitslag(Integer.parseInt(finalCode));
				continue;
			} else { // voldoet de invoer? Exit loop.
				break;
			}
		}

		blokkeer = new int[invoerString.length()]; // invoerString omzetten in een blokkeer array
		for (int i = 0; i < 5; i++) {
			blokkeer[i] = invoerString.charAt(i) - '0';
		}
		int[] worp = new int[5]; 					// Gerolde code omzetten in een int array
		for (int i = 0; i < 5; i++) {
			worp[i] = finalCode.charAt(i) - '0';
		}

		for (int i = 0; i < blokkeer.length; i++) { // is blokkeer array 1? Dan wordt array dice gevuld met de worp. Is
													// blokkeer 0? Dan wordt dice array index leeggehaald.
			if (blokkeer[i] == 1) {
				dice[i] = worp[i];
			}
			if (blokkeer[i] == 0) {
				dice[i] = 0;
			} else {
				continue;
			}
		}
		finalCode = Arrays.toString(dice);
		for (int i : dice) {
			sb.append(i);
			sb2.append(i);
			sb2.append(" ");

			toPrintCode = sb2.toString(); // om de code uit te printen met spaties
			finalCode = sb.toString(); // om de code door te geven (die lust geen spaties)
		}

		System.out.println();
		System.out.println("Ok! Dan gaan we die houden, alle dobbelstenen die nu 0 zijn gaan we opnieuw gooien!");
		System.out.println("Nieuwe code: " + toPrintCode);
		System.out.println();
		return finalCode;
	}
}
