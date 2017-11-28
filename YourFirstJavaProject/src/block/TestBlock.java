package block;

public class TestBlock {

	public static void main(String[] args) {
		BlockScope b = new BlockScope();
		System.out.println(b.PI);
		BlockScope b1 = new BlockScope(3.0);
		System.out.println(b1.PI);
		b.modifyPI();
		System.out.println(b.PI);
		System.out.println(b1.PI);
		
	}

}
