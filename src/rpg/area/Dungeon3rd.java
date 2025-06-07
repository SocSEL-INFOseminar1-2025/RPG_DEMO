package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Knight;
import rpg.character.monster.monster.PhantomKnight;

/*Dungeon�N���X���p�� �_���W�����ݒ�i�K�w���E�o�������X�^�[�Ȃǁj����̉�*/
public class Dungeon3rd extends Dungeon {
	public Dungeon3rd() {
		this.name = "�����̊�";
		this.floorNum = 3;
		this.encountCounter = 0;
	}
	
	// Dungeon�N���X����
	@Override
	protected Monster nextBoss() {
		PhantomKnight boss3rd = new PhantomKnight();
		return boss3rd;
	}
	// Dungeon�N���X����
	@Override
	protected Monster nextMob(int i) {
		Knight mob3rd = new Knight(i);
		return mob3rd;
	}

	// Dungeon�N���X����
	@Override
	protected Area nextArea() {
		return null;
	}

}
