package rpg.character.monster.monster;

import rpg.character.monster.Monster;

/*Monsterクラスを継承 モンスターを具体化*/
public class BabyDragon extends Monster {
	public BabyDragon(int i) {
		super("ベビードラゴン" + i, 50, 5);
	}
}
