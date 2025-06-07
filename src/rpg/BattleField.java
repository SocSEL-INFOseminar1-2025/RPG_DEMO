package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.MonsterParty;

public class BattleField {
	public String battle(HeroParty heros, MonsterParty monsters) {
		// enemy dispay
		AbstractCharacter[] monsterMembers = monsters.getMembers();
		for (AbstractCharacter m : monsterMembers) {
			System.out.print(m.getName() + " ");
		}
		System.out.println("があらわれた");
		
		// battle start
		while (true) {
			monsters.printPartyStatus();
			System.out.println();
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			heros.turn(monsters);
			if(monsters.isAllDead()){
				return "WIN";
			} else if(heros.isEscapeAll()){
				return "ESCAPE";
			}
			
			System.out.println();
			System.out.println("モンスターのターン");
			monsters.turn(heros);
			if(heros.isAllDead()){
				return "LOSE";
			} else if(heros.isEscapeAll()){
				return "ESCAPE";
			}
		}
	}
}
