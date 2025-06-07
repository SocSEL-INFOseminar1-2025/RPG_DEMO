package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractPartyクラスを継承　ヒーローパーティとして具体化*/
public class HeroParty extends AbstractParty {

	public HeroParty(AbstractCharacter[] heros) {
		super(heros);
	}
	
	public void rest() {
		
	}
	
	// AbstractPartyからオーバーライド
	@Override
	public void printPartyStatus() {
		for (AbstractCharacter m : this.getMembers()) {
			if (m instanceof Hero) {
				Hero h = (Hero) m;
				printPartyStatus(h);
			} else {
				if (m.getHp() > 0 && !m.isEscaped()) {
					System.out.print(m.getName() + ":" + m.getHp() + " ");
				} 
				else if(m.isEscaped()) {
					System.out.println(m.getName() + ":逃亡　");
				}
				else if(m.getHp() <=0 ){
					System.out.println(m.getName() + ":死亡　");
				}
			}
		}
	}
	
	private void printPartyStatus(Hero hero) {
		if (hero.getHp() > 0 && !hero.isEscaped()) {
			System.out.print(hero.getName() + "(" + hero.getJob() + "):" + hero.getHp() + " ");
		} 
		else if(hero.isEscaped()) {
			System.out.print(hero.getName() + "(" + hero.getJob() + "):逃亡　");
		}
		else if(hero.getHp() <=0 ){
			System.out.print(hero.getName() + "(" + hero.getJob() + "):死亡　");
		}
		
		System.out.println();
	}

	public void init() {
		
	}

	// AbstractPartyからオーバーライド
	@Override
	public boolean isEscapeAll() {
		int success = 0;
		int liveHero = 0;
				
		AbstractCharacter[] heros = getMembers();
		for(AbstractCharacter h : heros) {
			if(h.isEscaped()) {
				success += 1;
			}
			if(h.getHp() > 0) {
				liveHero += 1;
			}
		}
		
		// HPが0でないメンバー全員が「逃げる」を選択すれば逃走成功
		if(success == liveHero) {
			return true;
		} else {
			return false;
		}
	}
}
