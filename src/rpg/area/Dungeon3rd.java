package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Knight;
import rpg.character.monster.monster.PhantomKnight;

/*Dungeonクラスを継承 ダンジョン設定（階層名・出現モンスターなど）を具体化*/
public class Dungeon3rd extends Dungeon {
	public Dungeon3rd() {
		this.name = "試練の間";
		this.floorNum = 3;
		this.encountCounter = 0;
	}
	
	// Dungeonクラスから
	@Override
	protected Monster nextBoss() {
		PhantomKnight boss3rd = new PhantomKnight();
		return boss3rd;
	}
	// Dungeonクラスから
	@Override
	protected Monster nextMob(int i) {
		Knight mob3rd = new Knight(i);
		return mob3rd;
	}

	// Dungeonクラスから
	@Override
	protected Area nextArea() {
		return null;
	}

}
