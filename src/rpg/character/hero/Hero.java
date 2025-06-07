package rpg.character.hero;

import java.util.Scanner;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.Specialist;

/*AbstractCharacter�N���X���p���@�q�[���[�Ƃ��ċ�̉�*/
public class Hero extends AbstractCharacter {
	Scanner sc = new Scanner(System.in);
	protected String job;
	
	public Hero(String name, int hp, int attack){
		super(name, hp, attack);
		job = "���ʂ̃q�[���[";
	}
	
	public void run() {
		System.out.println(getName() + "�͓����o����");
	}
	
	public void rest() {
		gotHeal(30);
	}
	
	public String getJob() {
		return job;
	}

	// AbstractCharacter����I�[�o�[���C�h
	@Override
	protected void command(AbstractParty allies, AbstractParty enemies) {
		// ���肪�S�ł��Ă��Ȃ���΍s������
		if(!enemies.isAllDead()) {
			System.out.println();
			System.out.print(this.getName() + "(" + this.getJob() + ")�̍s���F");
			System.out.println("1:�키�@2:������@3:�K�E�Z");
			int commandNum = ScanCommand.scan();
			
			// �키
			if(commandNum == 1) {
				while(true) {
					if(this.attack(enemies))
						break;
				}
			// ������
			} else if (commandNum == 2) {
				this.run();
				escaped = true;
			// �K�E�Z
			} else if (commandNum == 3) {
				// ��E�����̏ꍇ
				if(this instanceof Specialist) {
					Specialist specialist = (Specialist) this;
					// ��p�̕K�E�Z�𔭓�
					while (true) {
						if (getJob().equals("�m��")) {
							if (specialist.special(allies)) {
			                    break;
							}
		                } else {
			                if (specialist.special(enemies)) {
			                    break;
			                }
		                }
		            }
				} else {
					// ��E���Ȃ��ꍇ�͒ʏ�U��
					while (true) {
		                if (this.attack(enemies)) {
		                    break;
		                }
		            }
				}
			} else {
				 this.command(allies, enemies);
			}
		}
	}

	// AbstractCharacter����I�[�o�[���C�h
	@Override
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		// 	�U���Ώۂ���ʕ\��
		int i = 0;
		AbstractCharacter[] targetMembers = targets.getMembers();
		int[] targetNum = new int[targetMembers.length];
		
		System.out.println("�Ώۂ�");
		// �������Ă��鑊��̊m�F
		for(AbstractCharacter t : targetMembers) {
			if(t.getHp() > 0) {
				System.out.println(i + ":" + t.getName());
				targetNum[i] += 1;
			}
			i += 1;
		}
		
		// �L���ȓ��́i�U���\�ȑ���̔ԍ��j��������܂ŌJ��Ԃ�
		int select = 0;
	    while (true) {
	        select = ScanCommand.scan();
	        for (int j = 0; j < targetMembers.length; j++) {
	        	if(j == select && targetNum[j] != 0) {
	        		return targetMembers[select];
	        	}
	        }
	    }
	}
}
