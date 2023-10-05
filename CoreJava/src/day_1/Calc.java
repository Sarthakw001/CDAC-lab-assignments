import java.util.Scanner;
class Calc{
	public static void main(String[] args){
		boolean flag = true;
		while(flag){
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculator:");
		System.out.println("");
		System.out.println("1:Add");
		System.out.println("2:Subtract");
		System.out.println("3:Multiply");
		System.out.println("4:Division");
		System.out.println("5:Exit");
		
		System.out.println("Enter your options;");
		int option = sc.nextInt();
		if(option == 5) break;
		System.out.println("Enter 1st number");
		double num1 = sc.nextDouble();
		System.out.println("Enter 2nd number");
		double num2 = sc.nextDouble();
		
		
			switch (option) {
			case 1:
			System.out.println("Answer is : "+ (num1+num2));
			break;
			
			case 2:
			System.out.println("Answer is : "+ (num1-num2));
			break;
			
			case 3:
			System.out.println("Answer is : "+ (num1*num2));
			break;
			
			case 4:
			System.out.println("Answer is : "+ (num1/num2));
			break;
			
		}
	}	
   }
}
