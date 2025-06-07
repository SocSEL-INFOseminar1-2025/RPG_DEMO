package rpg.character.hero.job;

import rpg.character.Specialist;
import rpg.character.hero.Hero;

/*Heroクラスを継承 Specialistインターフェースを実装*/
public abstract class AbstractSuperHero extends Hero implements Specialist{
	public AbstractSuperHero(String name, int hp, int attack){
		super(name, hp, attack);
	}
}
