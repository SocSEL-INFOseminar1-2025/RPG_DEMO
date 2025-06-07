package rpg;

public class printExplorer {
	public static void walk() {
		// 移動表現
		System.out.println();
		System.out.println("トコトコ");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
