package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractPartyクラスを継承　モンスターパーティとして具体化*/
public class MonsterParty extends AbstractParty {
	public MonsterParty(AbstractCharacter[] monsters) {
		super(monsters);
	}

	// AbstractPartyからオーバーライド
	@Override
	protected boolean isEscapeAll() {
		return false;
	}

	// AbstractPartyからオーバーライド
	@Override
	public void printPartyStatus() {
		for (AbstractCharacter m : this.getMembers()) {
			if (m.getHp() > 0 && !m.isEscaped()) {
				System.out.println(m.getName() + " HP:" + m.getHp() + " ");
			} 
			else if(m.isEscaped()) {
				System.out.println(m.getName() + ":逃亡　");
			}
		}
	}
}
