package rpg.character.hero.job;

import rpg.character.Specialist;
import rpg.character.hero.Hero;

/*Hero�N���X���p�� Specialist�C���^�[�t�F�[�X������*/
public abstract class AbstractSuperHero extends Hero implements Specialist{
	public AbstractSuperHero(String name, int hp, int attack){
		super(name, hp, attack);
	}
}
