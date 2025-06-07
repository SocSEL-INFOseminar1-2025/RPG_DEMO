package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*BossMonsterクラスを継承 Specialistインターフェースを具体化*/
public class KingDemon extends BossMonster {
	private static Random random = new Random();
	
	public KingDemon() {
		super("デモンズゲイト", 100, 5);
	}
	
	// BossMonster（Specialist）から
	@Override
	public boolean special(AbstractParty targets) {
		// 攻撃成功フラグ
		boolean attackFlag = false;
		// ダメージ量
		int specialAttack;
		// 合計ダメージ（回復量）
		int totalDamage = 0;
		
		// 全体攻撃
		System.out.println(this.getName() + "のギガドレイン ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (AbstractCharacter targetE : targetMembers) {
			// 相手が生存かつ逃げていないときに攻撃可能
			if(!targetE.isDead() && !targetE.isEscaped()) {
				// 与ダメージ量の決定
				specialAttack = random.nextInt(this.getAttack()*2) + this.getAttack();
				totalDamage += specialAttack;
				
				targetE.gotDamage(specialAttack);
				System.out.println(targetE.getName() + "に" + specialAttack + "のダメージ");
				
				targetE.actionStatus();
				attackFlag = true;
			} else {
			}
		}
		// 与えたダメージだけ回復する
		this.gotHeal(totalDamage);
		System.out.println("ギガドレインの効果 " + this.getName() + "は" + totalDamage + "回復した");
		
		return attackFlag;
	}
}
