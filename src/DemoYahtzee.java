import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DemoYahtzee {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String legeCode = "00000"; // lege startwaarde code
		String gevuldeCode;

		YahtzeeSpel yahtzeespel = new YahtzeeSpel();
		yahtzeespel.introSpel(); // uitleg spel

		while (true) { // loop om te overzien of speler invoer aan voorwaarden voldoet
			gevuldeCode = yahtzeespel.spelen(legeCode); // lege code wordt gestuurd naar spelen(), deze komt gevuld
														// terug en wordt opgeslagen in gevuldeCode

			if (gevuldeCode.contentEquals("q")) {  //als iemand q heeft gedrukt om het spel te onderbreken
				System.out.println("Spel gestopt! Groot gelijk, volgens mij is het kwart voor bier..");
				System.out.println("Einde spel.");
				System.exit(1);
			}
			if (gevuldeCode.contentEquals("11111") || gevuldeCode.contentEquals("22222") // voor het geval dat iemand in
																							// 1e worp yahtzee heeft
					|| gevuldeCode.contentEquals("33333") || gevuldeCode.contentEquals("44444")
					|| gevuldeCode.contentEquals("55555") || gevuldeCode.contentEquals("66666")) {
				System.out.println("Yahtzee! Je hebt gewonnen!");
				System.out.println("Einde spel!");
				System.exit(1);

			} else {
				break;
			}
		}

		Speler speler = new Speler();
		speler.worp(gevuldeCode); // gevuldeCode wordt opgeslagen in ArrayList

		Worp worp = new Worp();
		worp.uitslag(Integer.parseInt(gevuldeCode)); // de uitslag van de worp wordt geprint op het scherm

		String codeAlsString = Integer.toString(Integer.parseInt(gevuldeCode)); // gevulde code wordt naar String
																				// omgezet zodat deze naar vasthouden()
																				// kan
		String returnedCode = yahtzeespel.vasthouden(codeAlsString); // wordt aan de speler gevraagd welke dobbelstenen
																		// vast te houden en welke opnieuw te gooien

		gevuldeCode = returnedCode; // returnedcode vult weer de eerdere gevuldeCode (voor makkelijk kopieren van
									// lappen code)

		int counter = 0; // als counter op 3 staat is het spel afgelopen

		while (true) { // na eerste worp gaat het spel de loop in
			if (counter < 10) {

				while (true) {
					gevuldeCode = yahtzeespel.spelen(gevuldeCode);

					if (gevuldeCode.contentEquals("q")) {
						System.out.println("Spel gestopt! Groot gelijk, volgens mij is het kwart voor bier..");
						System.exit(1);
					}
					if (gevuldeCode.contentEquals("11111") || gevuldeCode.contentEquals("22222")
							|| gevuldeCode.contentEquals("33333") || gevuldeCode.contentEquals("44444")
							|| gevuldeCode.contentEquals("55555") || gevuldeCode.contentEquals("66666")) {
						System.out.println("Yahtzee! Je hebt gewonnen!");
						System.out.println("Einde spel!");
						System.exit(1);
					}

					speler.worp(gevuldeCode);

					worp.uitslag(Integer.parseInt(gevuldeCode));

					speler.worpGeschiedenis();

					returnedCode = yahtzeespel.vasthouden(gevuldeCode);
					gevuldeCode = returnedCode;
				}
			}
			if (counter == 10) {
				System.out.println("Helaas! Alle beurten zijn op! Maar je hebt bier verdiend voor de goede inzet.");
				break;
			}
		}
		System.out.println("Einde spel.");
	}
}
