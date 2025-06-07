package rpg.area;

import java.util.Random;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.printExplorer;
import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

/*Area�N���X���p��*/
public abstract class Dungeon extends Area {
	private static Random random = new Random();
	
	protected int floorNum;
	protected int encountCounter;
	
	public Dungeon() {}
	
	protected abstract Monster nextBoss();
	protected abstract Monster nextMob(int i);
	protected abstract Area nextArea();
	
	// Area�N���X�����
	@Override
	public Area access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while (true) {
			System.out.println("�ǂ����܂���");
			System.out.println("1:�T������@2�F�͂��܂�̒��֖߂�");
			int nextMove = ScanCommand.scan(1, 2);
			
			// �ړ��\��
			printExplorer.walk();

			if (nextMove == 1) {
				String result = this.explore(party);

				if (result.equals("WIN")) {
					// �_���W�����S�N���A
					if (floorNum == 3) {
						DungeonCLEAR GAMECLEAR =  new DungeonCLEAR();
						GAMECLEAR.access(party);
						
					} else {
						System.out.println("�ǂ����܂���");
						System.out.println("1:�_���W������i�ށ@2�F�͂��܂�̒��֖߂�");
						nextMove = ScanCommand.scan(1, 2);
						
						if(nextMove == 1) {
							printExplorer.walk();
							// ������K�w�̃N���X�ɂ�����nextArea���\�b�h���Ăяo��
							Area nextArea = this.nextArea();
							nextArea.access(party);
						} else {
							Town town = new Town();
							town.access(party);
						}
					}
					
				} else if (result.equals("LOSE")) {
					DungeonGAMEOVER GAMEOVER =  new DungeonGAMEOVER();
					GAMEOVER.access(party);	
				}
				
			} else if (nextMove == 2) {
				Town town = new Town();
				town.access(party);
			}
		}
	}
	
	public String explore(HeroParty party) {
		// �ړ��\��
		printExplorer.walk();
		
		String result;
		while (true) {
			int randomNum = random.nextInt(2);
			
			// �{�X�̏o���i�퓬��3��ȏオ�{�X�����X�^�[�o���̕K�v�����j
			if ((randomNum == 0 && this.encountCounter >= 3)) {
				result = this.encountBoss(party);
				
				// ���S����
				if(result.equals("ESCAPE")){
					AbstractCharacter[] members = party.getMembers();
					for(AbstractCharacter m : members) {
						m.init();
					}
					nextMoveDungeon(party);
				}
				return result;
				
			// ���u�̏o��
			} else if (1 <= randomNum && randomNum <= 3) {
				result = this.encountMob(party);
				
				// �s�k�ŏI��
				if(result.equals("LOSE")){
					return result;
					
				// ���S����
				} else if(result.equals("ESCAPE")){
					AbstractCharacter[] members = party.getMembers();
					for(AbstractCharacter m : members) {
						m.init();
					}
					nextMoveDungeon(party);
					
				// �������Ɏ��̍s����q�˂�
				} else {
					nextMoveDungeon(party);
				}
			} 
		}
	}
	
	// Area�N���X�����
	@Override
	public void printArea() {
		System.out.println("���݂̏ꏊ��" + getName() + "�n��" + floorNum + "�K�ł��D");
	}
	
	private String encountMob(HeroParty party) {
		System.out.println("�����X�^�[�Ƒ�������");

		// �����X�^�[�p�[�e�B�쐬
		// �����X�^�[�������_���Ȑ������i�ő�3�j �����X�^�[�͌p����Ŏw��
		int randomNum = random.nextInt(3);
		Monster ms[] = new Monster[randomNum + 1];
		for (int i = 0; i <= randomNum; i++) {
			// ������K�w�̃N���X�ɂ�����nextMob���\�b�h���Ăяo��
			ms[i] = this.nextMob(i);
		}
		MonsterParty mpty = new MonsterParty(ms);
		
		// �o�g���J�n
		BattleField bf = new BattleField();
		String result = bf.battle(party, mpty);
		this.printBattleResult(result,"�킢");
		
		return result;
	}
	
	private String encountBoss(HeroParty party) {
		System.out.println("�{�X�����X�^�[�Ƒ�������");
		
		// �{�X�����X�^�[�ƃ��u�����X�^�[���쐬(�p����Őݒ�)
		// ������K�w�̃N���X�ɂ�����nextBoss���\�b�h�EnextMob���\�b�h���Ăяo��
		Monster bm[] = {
				this.nextMob(1),
				this.nextBoss(),
				this.nextMob(2)
		};
		MonsterParty bmpty = new MonsterParty(bm);
		
		// �o�g���J�n
		BattleField bf = new BattleField();
		String result = bf.battle(party, bmpty);
		this.printBattleResult(result,"�{�X");
		
		return result;
	}
	
	private void printBattleResult(String result, String string) {
		if (result.equals("WIN")) {
			System.out.println("�E�҂�����"+string+"�ɏ�������");
			System.out.println();
		} else if(result.equals("LOSE")){
			System.out.println("�E�҂�����"+string+"�ɔs�k����");
			System.out.println();
		} else if(result.equals("ESCAPE")){
			System.out.println("�E�҂�����"+string+"���瓦���o����");
			System.out.println();
		}
	}
	
	// �ǉ��v�f�F�_���W�������ł̎��̍s����q�˂郁�\�b�h
	private void nextMoveDungeon(HeroParty party) {
		System.out.println("���̍s����I�����ĉ�����");
		System.out.println("1:�_���W�����̒T���𑱂���@2�F�͂��܂�̒��֖߂�");
		int nextMove = ScanCommand.scan(1, 2);
		
		if(nextMove == 1) {
			// �p���Ő퓬�񐔉��Z
			this.encountCounter += 1;
			printExplorer.walk();
		} else {
			Town town = new Town();
			town.access(party);
		}
	}
}
