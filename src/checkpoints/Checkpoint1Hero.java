package checkpoints;

import rpg.character.hero.Hero;

public class Checkpoint1Hero {

	public static void main(String[] args) {
		// �C���X�^���X����
		Hero h1 = new Hero("kojiro", 100, 10);

		// �E�҂̖��O�ƌ��݂�HP��\��
		System.out.println("���O: " + h1.getName());
		System.out.println("���݂�HP: " + h1.getHp());
		System.out.println("�W���u: " + h1.getJob());
		
		// �E�҂ɍU����^����
		int damage = 30;
		System.out.println(h1.getName() + "�ɍU��");
		System.out.println(h1.getName() + "��" + h1.gotDamage(damage) + "�_���[�W�󂯂�");
		System.out.println("���݂�HP: " + h1.getHp());
		
		// �E�҂��x�܂���
		System.out.println(h1.getName() + "���x�܂���");
		h1.rest();
		System.out.println("���݂�HP: " + h1.getHp());
				
		// �E�҂������o����
		h1.run();
		
		// �E�҂ɒv���I�ȃ_���[�W��^����
		damage = 500;
		System.out.println(h1.getName() + "�ɒv���I�ȃ_���[�W��^����");
		System.out.println(h1.getName() + "��" + h1.gotDamage(damage) + "�_���[�W�󂯂�");
		System.out.println("���݂�HP: " + h1.getHp());
		h1.actionStatus();
	}

}
