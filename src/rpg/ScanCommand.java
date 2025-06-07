package rpg;

import java.util.Scanner;

/**
 * キーボードから値を読み込むクラス
 * 数値以外が入力された場合，もう一度入力をやり直させる
 *
 */
public class ScanCommand {
	private static Scanner scan= new Scanner(System.in);

	public static int scan() {
		while(true){
			try {
				int command = scan.nextInt();
				return command;
			} catch(Exception e){
				System.out.println("正しい値を入力してください");
				scan.next();
			}
		}
	}
	
	public static int scan(int choiceA, int choiceB) {
		int command = 0;
		while (true) {
			command = ScanCommand.scan();
			if (command == choiceA || command == choiceB) {
				break;
			} else {
				System.out.println("適切な値を入力してください");
			}
		}
		
		return command;
	}

	public static void close() {
		scan.close();
	}
}
