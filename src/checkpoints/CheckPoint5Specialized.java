package checkpoints;

import rpg.BattleField;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.Dragon;
import rpg.character.monster.monster.BabyDragon;

public class CheckPoint5Specialized {

	public static void main(String[] args) {
		// �E�҃p�[�e�B�쐬
		Hero[] heros = {
				new Sorcerer("a1"),
				new Warrior("a2"),
				new Priest("a3")	
		};
		HeroParty hpty = new HeroParty(heros);
		
		// �����X�^�[�p�[�e�B�쐬
		Monster ms[] = {
				new BabyDragon(0),
				new BabyDragon(1),
				new BabyDragon(2)
		};
		MonsterParty mpty = new MonsterParty(ms);
		
		// �q�[���p�[�e�B�[�ƃ����X�^�[�p�[�e�B�̐퓬
		// �K�E�Z���g����悤�ɂȂ��Ă��邱�Ƃ��m�F
		BattleField bf = new BattleField();
		String result = bf.battle(hpty, mpty);
		if (result.equals("WIN")) {
			System.out.println("�q�[���[�����͏�������");
		} else if (result.equals("LOSE")) {
			System.out.println("�q�[���[�����͔s�k����");
		} else {
			System.out.println("�q�[���[�����͓����o����");
		}
		
		// �q�[���[��������
		hpty.rest();
		
		// �{�X�����X�^�[��p��
		Monster bm[] = {
				new Dragon()
		};
		MonsterParty bmpty = new MonsterParty(bm);
		
		// �{�X�����X�^�[�Ƃ̐퓬
		String bossBattleResult = bf.battle(hpty, bmpty);
		if (bossBattleResult.equals("WIN")) {
			System.out.println("�q�[���[�����͏�������");
		} else if (bossBattleResult.equals("LOSE")) {
			System.out.println("�q�[���[�����͔s�k����");
		} else {
			System.out.println("�q�[���[�����͓����o����");
		}
	}

}
