package rpg;

import java.util.Scanner;

import rpg.area.Town;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;

// �Q�[���J�n�������s���N���X
public class Adventure {
	private static Scanner s = new Scanner(System.in);
	
	public static void start() {
		// �E�҃p�[�e�B�쐬
		// �p�[�e�B�����o�[��
		final int MEMBERNUM = 3;
		
		Hero[] heros = new Hero[MEMBERNUM];
		System.out.println("�p�[�e�B�����o�[��" + MEMBERNUM + "�l�W�߂܂��傤");

		heros = setMember(heros);		
		System.out.println("�p�[�e�B�����o���W�܂�܂����I�`�����J�n���܂�");
		HeroParty party = new HeroParty(heros);
		
		// �͂��܂�̒�����Q�[���J�n
		Town town = new Town();
		town.access(party);
	}
	
	// �p�[�e�B�����o�̖��O�Ɩ�E��ݒ肷�郁�\�b�h
	private static Hero[] setMember(Hero[] heros) {
		int job;
		String name;
		
		for(int i = 0; i < heros.length; i++) {
			System.out.println(i+1 + "�l�ڂ̃p�[�e�B�����o�[�̖��O����͂��Ă�������");
			name = s.next();
			
			while(true) {
				System.out.println(name + "�̖�E��I�����ĉ�����");
				System.out.println("0�F��m 1�F�m�� 2�F���@�g���@���̑��̐����F�e��E�̏ڍ�");
				job = ScanCommand.scan();
				
				switch(job) {
					case(0):
						heros[i] = new Warrior(name);
						break;
					case(1):
						heros[i] = new Priest(name);
						break;
					case(2):
						heros[i] = new Sorcerer(name);
						break;
					default:
						printJob();
						break;
				};
				
				if (heros[i] != null) {
					break;
				}
			}
		}
		
		return heros;
	}
	
	// ��E�̐�����\�����郁�\�b�h
	private static void printJob() {
		System.out.println("��m�F�U���͂��ł������C�K�E�Z�̃h���S���L�b�N�̓h���S���ɑ�_���[�W��^����");
		System.out.println("�m���F�K�E�Z�q�[���͖����S�����񕜂���");
		System.out.println("���@�g���F�K�E�Z�t�@�C�A�͑���S�̂Ƀ_���[�W��^����");
		System.out.println();
	}
	
	public static void close() {
		s.close();
	}
}
