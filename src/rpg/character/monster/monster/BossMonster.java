package rpg.character.monster.monster;

import rpg.character.Specialist;
import rpg.character.monster.Monster;

/*Monsterクラスを継承 Specialistインターフェースを実装*/
public abstract class BossMonster extends Monster implements Specialist {
	public BossMonster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
}
