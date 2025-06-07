package rpg.area;

import rpg.ScanCommand;
import rpg.printExplorer;
import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;

/*Area�N���X���p��*/
public class Hotel extends Area {
	public Hotel() {
		name = "�h��";
	}
	
	// Area�N���X�����
	@Override
	public Area access(HeroParty party) {
		this.printArea();
		while (true) {
			System.out.println("�ǂ����܂���");
			System.out.println("1:�x������@2�F�͂��܂�̒��ֈړ�����");
			int nextMove = ScanCommand.scan(1, 2);
			
			if (nextMove == 1) {
				// �̗͂�S�񕜂���
				AbstractCharacter[] members = party.getMembers();
				for (AbstractCharacter m : members) {
					m.gotHeal(m.getMaxHp());
				}
				System.out.println("�̗͂��S�񕜂��܂���");
			} else if (nextMove == 2) {
				// �ړ��\��
				printExplorer.walk();
				Town town = new Town();
				town.access(party);
			}
		}
	}

	// Area�N���X�����
	@Override
	public void printArea() {
		System.out.println("���݂̏ꏊ��" + getName() + "�ł��D");
	}

}