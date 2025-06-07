package rpg.area;

import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

/*Dungeonクラスを継承*/
public class DungeonCLEAR extends Dungeon {
	
	public Area access(HeroParty party) {
		System.out.println("ゲームクリア！！");
		AbstractCharacter[] members = party.getMembers();
		try {
			Thread.sleep(1000);
			System.out.println("Cast");
			for (AbstractCharacter m : members) {
				if (m instanceof Hero) {
					Hero h = (Hero) m;
					Thread.sleep(1000);
					System.out.println("ヒーロー：" + h.getName() + "(" + h.getJob() + ")");
				} else {
					System.out.println("ヒーロー：" + m.getName());
				}
			}

			System.out.print("お  ");
			Thread.sleep(1000);
			System.out.print("わ  ");
			Thread.sleep(1000);
			System.out.println("り  ");
			System.exit(0);

		} catch (InterruptedException e) {
			throw new Error();
		}
		return null;
	}

	@Override
	protected Monster nextBoss() {
		return null;
	}

	@Override
	protected Area nextArea() {
		return null;
	}

	@Override
	protected Monster nextMob(int i) {
		return null;
	}

}
