import java.util.Scanner;

class Avg{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	if(sc.hasNextDouble()){
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		System.out.println("Average is : "+ (x+y)/2);
	}
	else{
		System.out.println("Entered value is Illegal");
	}
    }
}

