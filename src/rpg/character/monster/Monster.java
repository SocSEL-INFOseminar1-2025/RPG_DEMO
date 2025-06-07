package rpg.character.monster;

import java.util.Random;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.hero.HeroParty;

/*AbstractCharacter�N���X���p���@�����X�^�[�Ƃ��ċ�̉�*/
public abstract class Monster extends AbstractCharacter {
	private static Random random = new Random();
	
	public Monster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
	
	// AbstractCharacter����I�[�o�[���C�h
	@Override
	protected void command(AbstractParty allies, AbstractParty enemies) {
		// ���肪�S�ł��Ă��Ȃ���΍s������
		if(!enemies.isAllDead()) {
			if (enemies instanceof HeroParty) {
				HeroParty enemiesHero = (HeroParty) enemies;
				
				if (!enemiesHero.isEscapeAll()) {
					System.out.println(this.getName() + "�̍s���F");
					int commandNum = random.nextInt(7) + 1;
					
					try{
						// ����̍s���Ɏ��ԓI��Ƃ���������A�󋵂𕪂���₷�����邽�߂�1.5�b��~
						Thread.sleep(1500);
						// �키
						if(commandNum >= 1 && commandNum <= 3) {
							while(true) {
								if(this.attack(enemies))
									break;
							}
						// �ځ[���Ƃ���
						} else if (commandNum >= 4 && commandNum <= 5) {
							System.out.println(this.getName() + "�͂ځ[���Ƃ��Ă���");
						// �K�E�Z
						} else if (commandNum >= 6 && commandNum <= 7) {
							// �{�X�����X�^�[�̏ꍇ
							if(this instanceof Specialist) {
								Specialist specialist = (Specialist) this;
								// ��p�̕K�E�Z�𔭓�
								while (true) {
					                if (specialist.special(enemies)) {
					                    break;
					                }
					            }
							} else {
								// �ʏ탂���X�^�[�͒ʏ�U��
								while (true) {
					                if (this.attack(enemies)) {
					                    break;
					                }
					            }
							}
						}
					} catch(InterruptedException e){
			            e.printStackTrace();
			        }
					System.out.println();
				}
			}
		}
	}

	// AbstractCharacter����I�[�o�[���C�h
	@Override
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		// 	�U���Ώۂ��擾
		AbstractCharacter[] targetMembers = targets.getMembers();
		// �����_���őΏۂ�I��
		return targetMembers[random.nextInt(3)];
	}
}
