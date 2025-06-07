package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*BossMonsterクラスを継承 Specialistインターフェースを具体化*/
public class Dragon extends BossMonster {
	private static Random random = new Random();
	
	public Dragon() {
		super("レッドドラゴン", 200, 30);
	}
	
	// BossMonster（Specialist）から
	@Override
	public boolean special(AbstractParty targets) {
		// 攻撃成功フラグ
		boolean attackFlag = false;
		// ダメージ量
		int specialAttack;
		
		// 全体攻撃
		System.out.println(this.getName() + "の竜のいぶき! ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (AbstractCharacter targetE : targetMembers) {
			// 相手が生存かつ逃げていないときに攻撃可能
			if(!targetE.isDead() && !targetE.isEscaped()) {
				// 与ダメージ量の決定
				specialAttack = random.nextInt(this.getAttack()) + this.getAttack();
				
				targetE.gotDamage(specialAttack);
				System.out.println(targetE.getName() + "に" + specialAttack + "のダメージ");
				
				targetE.actionStatus();
				attackFlag = true;
			} else {
			}
		}
		
		return attackFlag;
	}
}
