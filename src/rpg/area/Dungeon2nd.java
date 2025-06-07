package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Demon;
import rpg.character.monster.monster.KingDemon;

/*Dungeon�N���X���p�� �_���W�����ݒ�i�K�w���E�o�������X�^�[�Ȃǁj����̉�*/
public class Dungeon2nd extends Dungeon {
	public Dungeon2nd() {
		this.name = "�f�[�����̊�";
		this.floorNum = 2;
		this.encountCounter = 0;
	}
	
	// Dungeon�N���X����
	@Override
	protected Monster nextBoss() {
		KingDemon boss2nd = new KingDemon();
		return boss2nd;
	}
	// Dungeon�N���X����
	@Override
	protected Monster nextMob(int i) {
		Demon mob2nd = new Demon(i);
		return mob2nd;
	}

	// Dungeon�N���X����
	@Override
	protected Area nextArea() {
		Dungeon3rd dungeon3rd = new Dungeon3rd();
		return dungeon3rd;
	}

}
