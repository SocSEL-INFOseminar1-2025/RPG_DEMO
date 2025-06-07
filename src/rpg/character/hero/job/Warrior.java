package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractSuperHeroクラスを継承 Specialistインターフェースを具体化*/
public class Warrior extends AbstractSuperHero {
	private static Random random = new Random();
	
	public Warrior(String name) {
		super(name, 100, 30);
		job = "戦士";
	}
	
	// AbstractSuperHero（Specialist）から
	@Override
	public boolean special(AbstractParty targets) {
		AbstractCharacter targetE = selectTarget(targets);
		
		// 相手が生存かつ逃げていないときに攻撃可能
		if(!targetE.isDead() && !targetE.isEscaped()) {
			// 与ダメージ量の決定
			int specialAttack = random.nextInt(this.getAttack()) + this.getAttack();
			
			// 攻撃対象がドラゴンの場合
			if(targetE.getName().contains("ドラゴン")) {
				// +50の固定ダメージを加算
				specialAttack += 50;
			}
			
			targetE.gotDamage(specialAttack);
			System.out.print(this.getName() + "の必殺ドラゴンキック! ");
			System.out.println(targetE.getName() + "に" + specialAttack + "のダメージ");
			
			targetE.actionStatus();
			return true;
		} else {
			return false;
		}
	}
}
