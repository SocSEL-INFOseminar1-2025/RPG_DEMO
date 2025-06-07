package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Demon;
import rpg.character.monster.monster.KingDemon;

/*Dungeonクラスを継承 ダンジョン設定（階層名・出現モンスターなど）を具体化*/
public class Dungeon2nd extends Dungeon {
	public Dungeon2nd() {
		this.name = "デーモンの間";
		this.floorNum = 2;
		this.encountCounter = 0;
	}
	
	// Dungeonクラスから
	@Override
	protected Monster nextBoss() {
		KingDemon boss2nd = new KingDemon();
		return boss2nd;
	}
	// Dungeonクラスから
	@Override
	protected Monster nextMob(int i) {
		Demon mob2nd = new Demon(i);
		return mob2nd;
	}

	// Dungeonクラスから
	@Override
	protected Area nextArea() {
		Dungeon3rd dungeon3rd = new Dungeon3rd();
		return dungeon3rd;
	}

}
