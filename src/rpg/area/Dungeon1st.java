package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.BabyDragon;
import rpg.character.monster.monster.Dragon;

/*Dungeon�N���X���p�� �_���W�����ݒ�i�K�w���E�o�������X�^�[�Ȃǁj����̉�*/
public class Dungeon1st extends Dungeon {
	public Dungeon1st() {
		this.name = "�h���S���̑��A";
		this.floorNum = 1;
		this.encountCounter = 0;
	}
	
	// Dungeon�N���X����
	@Override
	protected Monster nextBoss() {
		Dragon boss1st = new Dragon();
		return boss1st;
	}
	// Dungeon�N���X����
	@Override
	protected Monster nextMob(int i) {
		BabyDragon mob1st = new BabyDragon(i);
		return mob1st;
	}

	// Dungeon�N���X����
	@Override
	protected Area nextArea() {
		Dungeon2nd dungeon2 = new Dungeon2nd();
		return dungeon2;
	}

}
