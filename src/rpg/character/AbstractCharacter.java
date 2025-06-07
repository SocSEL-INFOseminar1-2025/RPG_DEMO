package rpg.character;

import java.util.Random;

public abstract class AbstractCharacter {
	private static Random random = new Random();
	
	protected int attack;
	protected boolean escaped;
	private int	hp;
	private int	maxHp;
	private String name;
	
	protected AbstractCharacter(String name, int hp, int attack) {
		this.attack = attack;
		this.escaped = false; 
		this.maxHp = hp;
		this.hp = maxHp;
		this.name = name;
	}
	
	protected abstract void command(AbstractParty allies, AbstractParty enemies);
	protected abstract AbstractCharacter selectTarget(AbstractParty targets);
	
	public String getName() {
		return this.name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	private void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	private void setAttack(int i) {
		this.attack = i;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	private void setMaxHp(int maxHP) {
		this.maxHp = maxHp;
	}
	
	public boolean isDead() {
		if (hp <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean attack(AbstractParty enemies) {
		AbstractCharacter targetE = selectTarget(enemies);
		
		// ‘ŠŽè‚ª¶‘¶‚©‚Â“¦‚°‚Ä‚¢‚È‚¢‚Æ‚«‚ÉUŒ‚‰Â”\
		if(!targetE.isDead() && !targetE.isEscaped()) {
			// —^ƒ_ƒ[ƒWŒˆ’è
			int randomAttack = random.nextInt(this.getAttack()) + this.getAttack();
			
			targetE.gotDamage(randomAttack);
			System.out.print(this.getName() + "‚ÌUŒ‚ ");
			System.out.println(targetE.getName() + "‚É" + randomAttack + "‚Ìƒ_ƒ[ƒW");
			
			targetE.actionStatus();
			return true;
		} else {
			return false;
		}
	}
	
	public int gotDamage(int damage) {
		hp -= damage;
		if(hp < 0) {
			hp = 0;
		}
		return damage;
	}
	
	public int gotHeal(int heal) {
		hp += heal;
		if (hp > maxHp) {
			hp = maxHp;
		}
		return heal;
	}
	
	public boolean isEscaped() {
		return escaped;
	}
	
	public void init() {
		this.escaped = false;
	}
	
	public void actionStatus() {
		if(isDead()) {
			System.out.println(name + "‚Í“|‚ê‚½");
		}
	}
}
