package block;

public class BlockScope {

	private double d = 200.00;
	public static double PI = 3.142;

	public BlockScope(double d) {
		super();
		this.d = d;
		System.out.println("This is the constructor with d");
	}

	public BlockScope() {
		super();
		System.out.println("This is the empty argument constructor");
	}

	{
		int x = 100;
		System.out.println(x);
	}
	
	static {
		System.out.println("This is static inner block");
	}
	public void doNothingMethod() {
		System.out.println("Nothing lor!"); 
		{
			int x;
		}
	}
	
	public static void doSomethingMethod() {
		System.out.println("Nothing lor!"); 
		double circleArea = PI*10*10;
		
	}
	public void modifyPI ()
	{
		this.PI = 4.56;
	}

}
