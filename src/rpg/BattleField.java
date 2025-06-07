package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.MonsterParty;

public class BattleField {
	public String battle(HeroParty heros, MonsterParty monsters) {
		// �G�̉�ʕ\��
		AbstractCharacter[] monsterMembers = monsters.getMembers();
		for (AbstractCharacter m : monsterMembers) {
			System.out.print(m.getName() + "�@");
		}
		System.out.println("�������ꂽ");
		
		// �퓬�J�n
		while (true) {
			monsters.printPartyStatus();
			System.out.println();
			System.out.println("�E�҂̃^�[��");
			heros.printPartyStatus();
			heros.turn(monsters);
			if(monsters.isAllDead()){
				return "WIN";
			} else if(heros.isEscapeAll()){
				return "ESCAPE";
			}
			
			System.out.println();
			System.out.println("�����X�^�[�̃^�[��");
			monsters.turn(heros);
			if(heros.isAllDead()){
				return "LOSE";
			} else if(heros.isEscapeAll()){
				return "ESCAPE";
			}
		}
	}
}
