package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractSuperHero�N���X���p�� Specialist�C���^�[�t�F�[�X����̉�*/
public class Warrior extends AbstractSuperHero {
	private static Random random = new Random();
	
	public Warrior(String name) {
		super(name, 100, 30);
		job = "��m";
	}
	
	// AbstractSuperHero�iSpecialist�j����
	@Override
	public boolean special(AbstractParty targets) {
		AbstractCharacter targetE = selectTarget(targets);
		
		// ���肪�����������Ă��Ȃ��Ƃ��ɍU���\
		if(!targetE.isDead() && !targetE.isEscaped()) {
			// �^�_���[�W�ʂ̌���
			int specialAttack = random.nextInt(this.getAttack()) + this.getAttack();
			
			// �U���Ώۂ��h���S���̏ꍇ
			if(targetE.getName().contains("�h���S��")) {
				// +50�̌Œ�_���[�W�����Z
				specialAttack += 50;
			}
			
			targetE.gotDamage(specialAttack);
			System.out.print(this.getName() + "�̕K�E�h���S���L�b�N! ");
			System.out.println(targetE.getName() + "��" + specialAttack + "�̃_���[�W");
			
			targetE.actionStatus();
			return true;
		} else {
			return false;
		}
	}
}
