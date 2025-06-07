package rpg.character;

public abstract class AbstractParty {
	private AbstractCharacter[]	members;
	
	public AbstractParty(AbstractCharacter[] members) {
		this.members = members;
	}
	
	protected abstract boolean isEscapeAll();
	public abstract void printPartyStatus();
	
	public boolean isAllDead() {
		int dead = 0;
		for(AbstractCharacter m : members) {
			if(m.isDead()) {
				dead += 1;
			}
		}
		
		// �����o�[�S���̗̑͂�0�̂Ƃ���true��Ԃ�
		if(dead == members.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public String turn(AbstractParty enemies) {
		for (AbstractCharacter m : members) {
			// ���������S���Ă��Ȃ���΍s��
			if(!m.isDead() && !m.isEscaped())
				m.command(this, enemies);
		}
		return "";
	}
	
	public AbstractCharacter[] getMembers() {
		return members;
	}
}
