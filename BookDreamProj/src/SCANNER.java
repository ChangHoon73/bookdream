import java.util.Scanner;

public class SCANNER {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("두개의 정수를 입력해 주세요.");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int sum = a+b;
		
		System.out.println("두개의 정수 SUM= "+sum+" 입니다.");
		
		
	}

}
