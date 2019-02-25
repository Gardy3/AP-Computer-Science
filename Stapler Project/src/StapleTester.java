public class StapleTester {

	public static void main(String[] args) {
		
		Stapler mine = new Stapler();
		Stapler swing = new Stapler("Hot Pink", 9, "wood", 300);
		
//		System.out.println(mine.color);
//		System.out.println(mine.size);
//		System.out.println(mine.staple());
		
		System.out.println(swing.color);
		for(int i = 0; i < 300; i++)
			swing.staple();
		swing.open();
		swing.reload();
		swing.reload();
		System.out.println(swing.numStaples);
		swing.staple();
		swing.close();
		swing.staple();
		System.out.println(swing.numStaples);
		System.out.println(swing.uses);
		swing.reload();
		swing.open();
		swing.reload();
		swing.close();
		
		
	}

}