package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*BossMonsterクラスを継承 Specialistインターフェースを具体化*/
public class PhantomKnight extends BossMonster {
	private static Random random = new Random();
	
	public PhantomKnight() {
		super("幻影の騎士", 300, 40);
	}
	
	// BossMonster（Specialist）から
	@Override
	public boolean special(AbstractParty targets) {
		// 攻撃成功フラグ
		boolean attackFlag = false;
		// ダメージ量
		int specialAttack;
		// ターゲット
		AbstractCharacter targetE;
		
		// 2回攻撃
		System.out.println(this.getName() + "の剣の舞! ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (int i = 0; i < 2; i++) {
			attackFlag = false;
			while(!attackFlag) {
				// 攻撃対象をランダム選択
				targetE = targetMembers[random.nextInt(targetMembers.length)];
				
				// 相手が生存かつ逃げていないときに攻撃可能
				if(!targetE.isDead() && !targetE.isEscaped()) {
					// 与ダメージ量の決定
					specialAttack = random.nextInt(this.getAttack()) + this.getAttack() ;
					
					targetE.gotDamage(specialAttack);
					System.out.println(i+1 + "回目の攻撃");
					System.out.println(targetE.getName() + "に" + specialAttack + "のダメージ");
					
					targetE.actionStatus();
					attackFlag = true;
				} else {
				}
			}
		}
		
		return attackFlag;
	}
}
