package checkpoints;

import rpg.character.AbstractCharacter;
import rpg.character.hero.*;
import rpg.character.hero.job.Warrior;
import rpg.character.monster.*;
import rpg.character.monster.monster.*;

public class Checkpoint3Monster {

	public static void main(String[] args) {
		// �x�r�[�h���S������
		Monster babyDragon = new BabyDragon(0);
		
		// �x�r�[�h���S���̃f�[�^��\��
		System.out.println("name: " + babyDragon.getName());
		System.out.println("hp: " + babyDragon.getHp());
		System.out.println("power: " + babyDragon.getAttack());
		
		// �����X�^�[�p�[�e�B�쐬
		Monster ms1[] = {
				new BabyDragon(1),
				new BabyDragon(2),
				new BabyDragon(3)
		};
		Monster ms2[] = {
				new BabyDragon(4),
				new BabyDragon(5),
				new BabyDragon(6)
		};
		MonsterParty mpty1 = new MonsterParty(ms1);
		MonsterParty mpty2 = new MonsterParty(ms2);
		
		// �����X�^�[���m�Ō���
		while(!mpty1.isAllDead() && !mpty2.isAllDead()) {
			System.out.println("�����X�^�[�p�[�e�B�[1�̃^�[��");
			mpty1.turn(mpty2);
			System.out.println("�����X�^�[�p�[�e�B�[2�̃^�[��");
			mpty2.turn(mpty1);
			if (mpty1.isAllDead()) {
				System.out.println("�����X�^�[�p�[�e�B�[2�̏���");
			}
			if (mpty2.isAllDead()) {
				System.out.println("�����X�^�[�p�[�e�B�[1�̏���");
			}
		}
	}

}
