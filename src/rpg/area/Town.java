package rpg.area;

import rpg.ScanCommand;
import rpg.printExplorer;
import rpg.character.hero.HeroParty;

/*Area�N���X���p��*/
public class Town extends Area {
	public Town() {
		name = "�͂��܂�̒�";
	}
	
	// Area�N���X�����
	@Override
	public Area access(HeroParty party) {
		this.printArea();
		while (true) {
			System.out.println("�ǂ����܂���");
			System.out.println("1:�_���W�����֍s���@2�F�h���ֈړ�����");
			int nextMove = ScanCommand.scan(1, 2);
			
			// �ړ��\��
			printExplorer.walk();
			
			if (nextMove == 1) {
				Dungeon1st dungeon = new Dungeon1st();
				dungeon.access(party);
			} else if (nextMove == 2) {
				Hotel hotel = new Hotel();
				hotel.access(party);
			}
		}
	}

	// Area�N���X�����
	@Override
	public void printArea() {
		System.out.println("���݂̏ꏊ��" + getName() + "�ł��D");
	}

}
