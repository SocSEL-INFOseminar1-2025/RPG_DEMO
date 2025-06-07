package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractSuperHeroクラスを継承 Specialistインターフェースを具体化*/
public class Sorcerer extends AbstractSuperHero {
	private static Random random = new Random();
	
	public Sorcerer(String name) {
		super(name, 100, 4);
		job = "魔法使い";
	}
	
	// AbstractSuperHero（Specialist）から
	@Override
	public boolean special(AbstractParty targets) {
		// 攻撃成功フラグ
		boolean attackFlag = false;
		// ダメージ量
		int specialAttack;
		// 固定ダメージ
		final int FIREATTACK = 30;
		
		// 全体攻撃
		System.out.println(this.getName() + "の必殺技 ファイア ");
		
		AbstractCharacter[] targetMembers = targets.getMembers();
		for (AbstractCharacter targetE : targetMembers) {
			// 相手が生存かつ逃げていないときに攻撃可能
			if(!targetE.isDead() && !targetE.isEscaped()) {
				// 与ダメージ量の決定
				specialAttack = random.nextInt(this.getAttack()) + FIREATTACK;
				
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
