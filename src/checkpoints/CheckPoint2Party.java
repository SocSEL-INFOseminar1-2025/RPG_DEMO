package checkpoints;

import rpg.character.hero.HeroParty;
import rpg.character.hero.Hero;

public class CheckPoint2Party {

	public static void main(String[] args) {
		// ��m�N���X�̔z���2�쐬
		Hero hs1[] = {
				new Hero("a1", 100, 30),
				new Hero("a2", 100, 30),
				new Hero("a3", 100, 30)
		};
		Hero hs2[] = {
				new Hero("b1", 100, 30),
				new Hero("b2", 100, 30),
				new Hero("b3", 100, 30)
		};
		
		// �q�[���[�p�[�e�B��2�쐬
		HeroParty corps1 = new HeroParty(hs1);
		HeroParty corps2 = new HeroParty(hs2);
		
		// ��m�̕������m�Ő�킹��
		while(!corps1.isAllDead() && !corps2.isAllDead()) {
			System.out.println("����1�̃^�[��");
			corps1.printPartyStatus();
			corps1.turn(corps2);
			if(corps1.isEscapeAll()) {
				break;
			}
			System.out.println("����2�̃^�[��");
			corps2.printPartyStatus();
			corps2.turn(corps1);
			if(corps2.isEscapeAll()) {
				break;
			}
		}
	}

}
