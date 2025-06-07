package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*BossMonster�N���X���p�� Specialist�C���^�[�t�F�[�X����̉�*/
public class PhantomKnight extends BossMonster {
	private static Random random = new Random();
	
	public PhantomKnight() {
		super("���e�̋R�m", 300, 40);
	}
	
	// BossMonster�iSpecialist�j����
	@Override
	public boolean special(AbstractParty targets) {
		// �U�������t���O
		boolean attackFlag = false;
		// �_���[�W��
		int specialAttack;
		// �^�[�Q�b�g
		AbstractCharacter targetE;
		
		// 2��U��
		System.out.println(this.getName() + "�̌��̕�! ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (int i = 0; i < 2; i++) {
			attackFlag = false;
			while(!attackFlag) {
				// �U���Ώۂ������_���I��
				targetE = targetMembers[random.nextInt(targetMembers.length)];
				
				// ���肪�����������Ă��Ȃ��Ƃ��ɍU���\
				if(!targetE.isDead() && !targetE.isEscaped()) {
					// �^�_���[�W�ʂ̌���
					specialAttack = random.nextInt(this.getAttack()) + this.getAttack() ;
					
					targetE.gotDamage(specialAttack);
					System.out.println(i+1 + "��ڂ̍U��");
					System.out.println(targetE.getName() + "��" + specialAttack + "�̃_���[�W");
					
					targetE.actionStatus();
					attackFlag = true;
				} else {
				}
			}
		}
		
		return attackFlag;
	}
}
