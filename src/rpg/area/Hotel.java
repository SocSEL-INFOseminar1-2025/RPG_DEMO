package rpg.area;

import rpg.ScanCommand;
import rpg.printExplorer;
import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;

/*Areaクラスを継承*/
public class Hotel extends Area {
	public Hotel() {
		name = "宿屋";
	}
	
	// Areaクラスからの
	@Override
	public Area access(HeroParty party) {
		this.printArea();
		while (true) {
			System.out.println("どうしますか");
			System.out.println("1:休息する　2：はじまりの町へ移動する");
			int nextMove = ScanCommand.scan(1, 2);
			
			if (nextMove == 1) {
				// 体力を全回復する
				AbstractCharacter[] members = party.getMembers();
				for (AbstractCharacter m : members) {
					m.gotHeal(m.getMaxHp());
				}
				System.out.println("体力が全回復しました");
			} else if (nextMove == 2) {
				// 移動表現
				printExplorer.walk();
				Town town = new Town();
				town.access(party);
			}
		}
	}

	// Areaクラスからの
	@Override
	public void printArea() {
		System.out.println("現在の場所は" + getName() + "です．");
	}

}