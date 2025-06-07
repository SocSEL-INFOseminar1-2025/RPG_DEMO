package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*BossMonster�N���X���p�� Specialist�C���^�[�t�F�[�X����̉�*/
public class KingDemon extends BossMonster {
	private static Random random = new Random();
	
	public KingDemon() {
		super("�f�����Y�Q�C�g", 100, 5);
	}
	
	// BossMonster�iSpecialist�j����
	@Override
	public boolean special(AbstractParty targets) {
		// �U�������t���O
		boolean attackFlag = false;
		// �_���[�W��
		int specialAttack;
		// ���v�_���[�W�i�񕜗ʁj
		int totalDamage = 0;
		
		// �S�̍U��
		System.out.println(this.getName() + "�̃M�K�h���C�� ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (AbstractCharacter targetE : targetMembers) {
			// ���肪�����������Ă��Ȃ��Ƃ��ɍU���\
			if(!targetE.isDead() && !targetE.isEscaped()) {
				// �^�_���[�W�ʂ̌���
				specialAttack = random.nextInt(this.getAttack()*2) + this.getAttack();
				totalDamage += specialAttack;
				
				targetE.gotDamage(specialAttack);
				System.out.println(targetE.getName() + "��" + specialAttack + "�̃_���[�W");
				
				targetE.actionStatus();
				attackFlag = true;
			} else {
			}
		}
		// �^�����_���[�W�����񕜂���
		this.gotHeal(totalDamage);
		System.out.println("�M�K�h���C���̌��� " + this.getName() + "��" + totalDamage + "�񕜂���");
		
		return attackFlag;
	}
}
