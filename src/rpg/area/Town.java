package rpg.area;

import rpg.ScanCommand;
import rpg.printExplorer;
import rpg.character.hero.HeroParty;

/*Areaクラスを継承*/
public class Town extends Area {
	public Town() {
		name = "はじまりの町";
	}
	
	// Areaクラスからの
	@Override
	public Area access(HeroParty party) {
		this.printArea();
		while (true) {
			System.out.println("どうしますか");
			System.out.println("1:ダンジョンへ行く　2：宿屋へ移動する");
			int nextMove = ScanCommand.scan(1, 2);
			
			// 移動表現
			printExplorer.walk();
			
			if (nextMove == 1) {
				Dungeon1st dungeon = new Dungeon1st();
				dungeon.access(party);
			} else if (nextMove == 2) {
				Hotel hotel = new Hotel();
				hotel.access(party);
			}
		}
	}

	// Areaクラスからの
	@Override
	public void printArea() {
		System.out.println("現在の場所は" + getName() + "です．");
	}

}
