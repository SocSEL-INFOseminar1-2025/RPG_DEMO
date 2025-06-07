package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/*AbstractSuperHeroクラスを継承 Specialistインターフェースを具体化*/
public class Priest extends AbstractSuperHero {
	private static Random random = new Random();
	
	public Priest(String name) {
		super(name, 100, 4);
		job = "僧侶";
	}
	
	// AbstractSuperHero（Specialist）から
	@Override
	public boolean special(AbstractParty allies) {
		// 固定回復量
		final int HEAL = 10;
		
		// 回復量の決定
		int healNum = random.nextInt(HEAL) + HEAL;
		
		// 場にいる味方全員を回復（死者は復活しない）
		System.out.println(this.getName() + "の必殺技 ヒール ");
		
		AbstractCharacter[] members = allies.getMembers();
		for (AbstractCharacter member : members) {
			if(!member.isDead() && !member.isEscaped()) {
				member.gotHeal(healNum);
				System.out.println(member.getName() + "はHPを" + healNum + "回復した");
			}
		}
		return true;
	}
}
