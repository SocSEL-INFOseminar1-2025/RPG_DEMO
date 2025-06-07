package rpg.character.monster;

import java.util.Random;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.hero.HeroParty;

/*AbstractCharacterクラスを継承　モンスターとして具体化*/
public abstract class Monster extends AbstractCharacter {
	private static Random random = new Random();
	
	public Monster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
	
	// AbstractCharacterからオーバーライド
	@Override
	protected void command(AbstractParty allies, AbstractParty enemies) {
		// 相手が全滅していなければ行動する
		if(!enemies.isAllDead()) {
			if (enemies instanceof HeroParty) {
				HeroParty enemiesHero = (HeroParty) enemies;
				
				if (!enemiesHero.isEscapeAll()) {
					System.out.println(this.getName() + "の行動：");
					int commandNum = random.nextInt(7) + 1;
					
					try{
						// 相手の行動に時間的ゆとりを持たせ、状況を分かりやすくするための1.5秒停止
						Thread.sleep(1500);
						// 戦う
						if(commandNum >= 1 && commandNum <= 3) {
							while(true) {
								if(this.attack(enemies))
									break;
							}
						// ぼーっとする
						} else if (commandNum >= 4 && commandNum <= 5) {
							System.out.println(this.getName() + "はぼーっとしている");
						// 必殺技
						} else if (commandNum >= 6 && commandNum <= 7) {
							// ボスモンスターの場合
							if(this instanceof Specialist) {
								Specialist specialist = (Specialist) this;
								// 専用の必殺技を発動
								while (true) {
					                if (specialist.special(enemies)) {
					                    break;
					                }
					            }
							} else {
								// 通常モンスターは通常攻撃
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

	// AbstractCharacterからオーバーライド
	@Override
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		// 	攻撃対象を取得
		AbstractCharacter[] targetMembers = targets.getMembers();
		// ランダムで対象を選択
		return targetMembers[random.nextInt(3)];
	}
}
