

public class AsciiartFactory {

	public static void printHelicopter() throws InterruptedException {
		int t=0;
		while (t<30) {

			for (int num = 0; num < 8; num++) {
				System.out.print('\n');
				}

			System.out.println("         :***********");
			System.out.println("           A           ");
			System.out.println("       /--------       ");
			System.out.println(" ***====      ()\\     ");
			System.out.println("  *    \\         \\        ");
			System.out.println("        \\_________]                ");
			System.out.println("           I     I      ");
			System.out.println("        -----------/              ");
			System.out.println("                       ");
			System.out.println("      Team's Helicopter!              ");

			Thread.sleep(50);

			for (int num = 0; num < 8; num++) {
				System.out.print('\n');
				}

			System.out.println("***********:         ");
			System.out.println("           A           ");
			System.out.println("  *    /--------       ");
			System.out.println(" ***====      ()\\     ");
			System.out.println("       \\         \\        ");
			System.out.println("        \\_________]                ");
			System.out.println("           I     I      ");
			System.out.println("        -----------/              ");
			System.out.println("                       ");
			System.out.println("      Team's Helicopter!              ");

			Thread.sleep(50);
			t++;
		}

	}
	
	public static void printMan() {


				System.out.println("   O   ");
				System.out.println("  /|\\/    ");
				System.out.println("   /\\   ");
				System.out.println("  / |  ");


		}
	}
