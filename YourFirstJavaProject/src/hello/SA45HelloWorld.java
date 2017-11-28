package hello;

public class SA45HelloWorld {

	private int x = 5;

	public static void main(String args[]) {
		System.out.println("Hello World!!!! Same old keyphrase");
		for (int i = 0; i < 3; i++) {
			System.out.println("Hello World!!!! Inside the for loop " + i);
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[i]" + args[i]);
		}

	}

}
