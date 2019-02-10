package helloWorld;
/*
 * Auth: Reinan Gabriel
 * Date: 2019-02-10
*/
import java.util.Scanner;
public class helloWorld{
	public static void main(String[] args){

		int n,i;

		if(args.length > 0){
			n = Integer.parseInt(args[0]);
		}else{
			System.out.printf("Qual é o valor do número: ");
			Scanner in = new Scanner(System.in);

			n = in.nextInt();

		}
			
		for(i=0;i < 10; i++){
			System.out.printf("%d * %d = %d\n", n, i, (n*i) );
		}

		//System.out.println("Hello World");

	}
}
