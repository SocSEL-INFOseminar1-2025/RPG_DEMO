package rpg.area;

import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

/*Dungeon�N���X���p��*/
public class DungeonGAMEOVER extends Dungeon {
	public Area access(HeroParty party) {
		System.out.println("�Q�[���I�[�o�[�I�I");
		System.out.println("�܂����킵�Ă�");
		System.exit(0);
		return null;
	}
	
	@Override
	protected Monster nextBoss() {
		return null;
	}

	@Override
	protected Area nextArea() {
		return null;
	}

	@Override
	protected Monster nextMob(int i) {
		return null;
	}

}
