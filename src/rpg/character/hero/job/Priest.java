package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractSuperHero�N���X���p�� Specialist�C���^�[�t�F�[�X����̉�*/
public class Priest extends AbstractSuperHero {
	private static Random random = new Random();
	
	public Priest(String name) {
		super(name, 100, 4);
		job = "�m��";
	}
	
	// AbstractSuperHero�iSpecialist�j����
	@Override
	public boolean special(AbstractParty allies) {
		// �Œ�񕜗�
		final int HEAL = 10;
		
		// �񕜗ʂ̌���
		int healNum = random.nextInt(HEAL) + HEAL;
		
		// ��ɂ��閡���S�����񕜁i���҂͕������Ȃ��j
		System.out.println(this.getName() + "�̕K�E�Z �q�[�� ");
		
		AbstractCharacter[] members = allies.getMembers();
		for (AbstractCharacter member : members) {
			if(!member.isDead() && !member.isEscaped()) {
				member.gotHeal(healNum);
				System.out.println(member.getName() + "��HP��" + healNum + "�񕜂���");
			}
		}
		return true;
	}
}
