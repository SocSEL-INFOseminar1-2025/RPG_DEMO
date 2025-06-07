package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.BabyDragon;
import rpg.character.monster.monster.Dragon;

/*Dungeonクラスを継承 ダンジョン設定（階層名・出現モンスターなど）を具体化*/
public class Dungeon1st extends Dungeon {
	public Dungeon1st() {
		this.name = "ドラゴンの巣窟";
		this.floorNum = 1;
		this.encountCounter = 0;
	}
	
	// Dungeonクラスから
	@Override
	protected Monster nextBoss() {
		Dragon boss1st = new Dragon();
		return boss1st;
	}
	// Dungeonクラスから
	@Override
	protected Monster nextMob(int i) {
		BabyDragon mob1st = new BabyDragon(i);
		return mob1st;
	}

	// Dungeonクラスから
	@Override
	protected Area nextArea() {
		Dungeon2nd dungeon2 = new Dungeon2nd();
		return dungeon2;
	}

}
