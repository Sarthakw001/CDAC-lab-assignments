import java.util.Scanner;

class Rest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int bill_value = 0;

		while (true) {

			System.out.println("Food Menu : ");
			System.out.println();
			System.out.println("1. Dosa - 100");
			System.out.println("2. Idli - 50");
			System.out.println("3. Sambhar-wada - 150");
			System.out.println("4. Chowmein - 200");
			System.out.println("5. Momos - 80");
			System.out.println("6. Butter Chicken - 400");
			System.out.println("7. Fish Curry - 700");
			System.out.println("8. Panner butter Masala - 380");
			System.out.println("9. Water Bottle - 20");
			System.out.println("10.Generate Bill");

			System.out.println("");

			System.out.println("Enter your choice");

			int option = sc.nextInt();
			if (option == 10) {
				System.out.println("Generated bill is : " + bill_value);
				break;
			}
			System.out.println("");

			System.out.println("Enter the quantity");

			int qty = sc.nextInt();

			switch (option) {
				case 1:
					bill_value += qty * 100;
					break;
				case 2:
					bill_value += qty * 50;
					break;
				case 3:
					bill_value += qty * 150;
					break;
				case 4:
					bill_value += qty * 200;
					break;
				case 5:
					bill_value += qty * 80;
					break;
				case 6:
					bill_value += qty * 400;
					break;
				case 7:
					bill_value += qty * 700;
					break;
				case 8:
					bill_value += qty * 380;
					break;
				case 9:
					bill_value += qty * 20;
					break;

			}
		}
		sc.close();
	}
}
