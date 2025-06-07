package rpg.character.monster.monster;

import rpg.character.monster.Monster;

/*Monsterクラスを継承 モンスターを具体化*/
public class Demon extends Monster {
	public Demon(int i) {
		super("デーモン" + i, 70, 10);
	}
}
