package checkpoints;

import rpg.area.*;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Warrior;

public class CheckPoint6Dungeon {

	public static void main(String[] args) {
		// �E�҃p�[�e�B�쐬
		Hero[] heros = {
				new Warrior("a1"),
				new Warrior("a2"),
				new Warrior("a3")	
		};
		HeroParty party = new HeroParty(heros);
		
		// �_���W�����n��1�K�ɍs��
		// �h���S����|������I��
		Dungeon1st dungeon = new Dungeon1st();
		dungeon.access(party);
	}

}
