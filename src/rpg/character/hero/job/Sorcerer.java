package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractSuperHero�N���X���p�� Specialist�C���^�[�t�F�[�X����̉�*/
public class Sorcerer extends AbstractSuperHero {
	private static Random random = new Random();
	
	public Sorcerer(String name) {
		super(name, 100, 4);
		job = "���@�g��";
	}
	
	// AbstractSuperHero�iSpecialist�j����
	@Override
	public boolean special(AbstractParty targets) {
		// �U�������t���O
		boolean attackFlag = false;
		// �_���[�W��
		int specialAttack;
		// �Œ�_���[�W
		final int FIREATTACK = 30;
		
		// �S�̍U��
		System.out.println(this.getName() + "�̕K�E�Z �t�@�C�A ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (AbstractCharacter targetE : targetMembers) {
			// ���肪�����������Ă��Ȃ��Ƃ��ɍU���\
			if(!targetE.isDead() && !targetE.isEscaped()) {
				// �^�_���[�W�ʂ̌���
				specialAttack = random.nextInt(this.getAttack()) + FIREATTACK;
				
				targetE.gotDamage(specialAttack);
				System.out.println(targetE.getName() + "��" + specialAttack + "�̃_���[�W");
				
				targetE.actionStatus();
				attackFlag = true;
			} else {
			}
		}
		
		return attackFlag;
	}
}
