package rpg;

import java.util.Scanner;

/**
 * 
 * Class for reading input from the keyboard
 * Any input other than numbers will be redone.
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
				System.out.println("Please enter valid value");
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
				System.out.println("Please enter the appropriate value.");
			}
		}
		
		return command;
	}

	public static void close() {
		scan.close();
	}
}
