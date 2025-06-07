package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*BossMonster�N���X���p�� Specialist�C���^�[�t�F�[�X����̉�*/
public class Dragon extends BossMonster {
	private static Random random = new Random();
	
	public Dragon() {
		super("���b�h�h���S��", 200, 30);
	}
	
	// BossMonster�iSpecialist�j����
	@Override
	public boolean special(AbstractParty targets) {
		// �U�������t���O
		boolean attackFlag = false;
		// �_���[�W��
		int specialAttack;
		
		// �S�̍U��
		System.out.println(this.getName() + "�̗��̂��Ԃ�! ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (AbstractCharacter targetE : targetMembers) {
			// ���肪�����������Ă��Ȃ��Ƃ��ɍU���\
			if(!targetE.isDead() && !targetE.isEscaped()) {
				// �^�_���[�W�ʂ̌���
				specialAttack = random.nextInt(this.getAttack()) + this.getAttack();
				
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
