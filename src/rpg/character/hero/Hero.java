package rpg.character.hero;

import java.util.Scanner;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.Specialist;

/*AbstractCharacterクラスを継承　ヒーローとして具体化*/
public class Hero extends AbstractCharacter {
	Scanner sc = new Scanner(System.in);
	protected String job;
	
	public Hero(String name, int hp, int attack){
		super(name, hp, attack);
		job = "普通のヒーロー";
	}
	
	public void run() {
		System.out.println(getName() + "は逃げ出した");
	}
	
	public void rest() {
		gotHeal(30);
	}
	
	public String getJob() {
		return job;
	}

	// AbstractCharacterからオーバーライド
	@Override
	protected void command(AbstractParty allies, AbstractParty enemies) {
		// 相手が全滅していなければ行動する
		if(!enemies.isAllDead()) {
			System.out.println();
			System.out.print(this.getName() + "(" + this.getJob() + ")の行動：");
			System.out.println("1:戦う　2:逃げる　3:必殺技");
			int commandNum = ScanCommand.scan();
			
			// 戦う
			if(commandNum == 1) {
				while(true) {
					if(this.attack(enemies))
						break;
				}
			// 逃げる
			} else if (commandNum == 2) {
				this.run();
				escaped = true;
			// 必殺技
			} else if (commandNum == 3) {
				// 役職持ちの場合
				if(this instanceof Specialist) {
					Specialist specialist = (Specialist) this;
					// 専用の必殺技を発動
					while (true) {
						if (getJob().equals("僧侶")) {
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
					// 役職がない場合は通常攻撃
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

	// AbstractCharacterからオーバーライド
	@Override
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		// 	攻撃対象を画面表示
		int i = 0;
		AbstractCharacter[] targetMembers = targets.getMembers();
		int[] targetNum = new int[targetMembers.length];
		
		System.out.println("対象は");
		// 生存している相手の確認
		for(AbstractCharacter t : targetMembers) {
			if(t.getHp() > 0) {
				System.out.println(i + ":" + t.getName());
				targetNum[i] += 1;
			}
			i += 1;
		}
		
		// 有効な入力（攻撃可能な相手の番号）が得られるまで繰り返す
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
