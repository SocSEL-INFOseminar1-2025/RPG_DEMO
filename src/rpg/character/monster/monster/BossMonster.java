package rpg.character.monster.monster;

import rpg.character.Specialist;
import rpg.character.monster.Monster;

/*Monster�N���X���p�� Specialist�C���^�[�t�F�[�X������*/
public abstract class BossMonster extends Monster implements Specialist {
	public BossMonster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
}
