package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractParty�N���X���p���@�����X�^�[�p�[�e�B�Ƃ��ċ�̉�*/
public class MonsterParty extends AbstractParty {
	public MonsterParty(AbstractCharacter[] monsters) {
		super(monsters);
	}

	// AbstractParty����I�[�o�[���C�h
	@Override
	protected boolean isEscapeAll() {
		return false;
	}

	// AbstractParty����I�[�o�[���C�h
	@Override
	public void printPartyStatus() {
		for (AbstractCharacter m : this.getMembers()) {
			if (m.getHp() > 0 && !m.isEscaped()) {
				System.out.println(m.getName() + " HP:" + m.getHp() + " ");
			} 
			else if(m.isEscaped()) {
				System.out.println(m.getName() + ":���S�@");
			}
		}
	}
}
