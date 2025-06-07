package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractParty�N���X���p���@�q�[���[�p�[�e�B�Ƃ��ċ�̉�*/
public class HeroParty extends AbstractParty {

	public HeroParty(AbstractCharacter[] heros) {
		super(heros);
	}
	
	public void rest() {
		
	}
	
	// AbstractParty����I�[�o�[���C�h
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
					System.out.println(m.getName() + ":���S�@");
				}
				else if(m.getHp() <=0 ){
					System.out.println(m.getName() + ":���S�@");
				}
			}
		}
	}
	
	private void printPartyStatus(Hero hero) {
		if (hero.getHp() > 0 && !hero.isEscaped()) {
			System.out.print(hero.getName() + "(" + hero.getJob() + "):" + hero.getHp() + " ");
		} 
		else if(hero.isEscaped()) {
			System.out.print(hero.getName() + "(" + hero.getJob() + "):���S�@");
		}
		else if(hero.getHp() <=0 ){
			System.out.print(hero.getName() + "(" + hero.getJob() + "):���S�@");
		}
		
		System.out.println();
	}

	public void init() {
		
	}

	// AbstractParty����I�[�o�[���C�h
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
		
		// HP��0�łȂ������o�[�S�����u������v��I������Γ�������
		if(success == liveHero) {
			return true;
		} else {
			return false;
		}
	}
}
