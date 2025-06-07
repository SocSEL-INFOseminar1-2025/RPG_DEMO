package rpg;

import java.util.Scanner;

/**
 * �L�[�{�[�h����l��ǂݍ��ރN���X
 * ���l�ȊO�����͂��ꂽ�ꍇ�C������x���͂���蒼������
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
				System.out.println("�������l����͂��Ă�������");
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
				System.out.println("�K�؂Ȓl����͂��Ă�������");
			}
		}
		
		return command;
	}

	public static void close() {
		scan.close();
	}
}
