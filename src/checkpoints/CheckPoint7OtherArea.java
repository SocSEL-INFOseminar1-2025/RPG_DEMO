package checkpoints;

import rpg.area.Area;
import rpg.area.Hotel;
import rpg.area.Town;
import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Warrior;

public class CheckPoint7OtherArea {

	public static void main(String[] args) {
		// �E�҃p�[�e�B�쐬
		Hero[] heros = {
				new Warrior("a1"),
				new Warrior("a2"),
				new Warrior("a3")	
		};
		HeroParty party = new HeroParty(heros);
				
		// �E�҂�����30�_���[�W��^����
		for (AbstractCharacter h : party.getMembers()) {
			h.gotDamage(30);
		}
		
		// ���Ńz�e���ɍs���ă_���[�W��
		Area area;
		Town town = new Town();
		area = town.access(party);
		if (area instanceof Hotel) {
			area.access(party);
		}
		
		// �E�҂������񕜂��Ă��邱�Ƃ��m�F
		party.printPartyStatus();
	}

}
