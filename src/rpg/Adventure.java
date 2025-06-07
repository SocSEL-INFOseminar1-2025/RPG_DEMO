package rpg;

import java.util.Scanner;

import rpg.area.Town;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;

// Class for starting the game
public class Adventure {
	private static Scanner s = new Scanner(System.in);
	
	public static void start() {
		// create hero party
		// the number of party member
		final int MEMBERNUM = 3;
		
		Hero[] heros = new Hero[MEMBERNUM];
		System.out.println("パーティーメンバーを" + MEMBERNUM + "人集めましょう");

		heros = setMember(heros);		
		System.out.println("パーティーメンバーが集まりました！冒険を始めます");
		HeroParty party = new HeroParty(heros);
		
		// game start from town
		Town town = new Town();
		town.access(party);
	}
	
	// Method for setting member names and jobs
	private static Hero[] setMember(Hero[] heros) {
		int job;
		String name;
		
		for(int i = 0; i < heros.length; i++) {
			System.out.println(i+1 + "人目のパーティーメンバーの名前を入力してください");
			name = s.next();
			
			while(true) {
				System.out.println(name + "の役職を選択してください");
				System.out.println("0:戦士 1:僧侶 2:魔法使い その他:各役職の詳細");
				job = ScanCommand.scan();
				
				switch(job) {
					case(0):
						heros[i] = new Warrior(name);
						break;
					case(1):
						heros[i] = new Priest(name);
						break;
					case(2):
						heros[i] = new Sorcerer(name);
						break;
					default:
						printJob();
						break;
				};
				
				if (heros[i] != null) {
					break;
				}
			}
		}
		
		return heros;
	}
	
	// Method for displaying job descriptions
	private static void printJob() {
		System.out.println("戦士：攻撃力が最も高い．必殺技ドラゴンキックはドラゴンに大ダメージ");
		System.out.println("僧侶：攻撃力が最も低い．必殺技ヒールは味方全員を回復する");
		System.out.println("魔法使い：魔法が使える．必殺技ファイアは相手全体にダメージを与える");
		System.out.println();
	}
	
	public static void close() {
		s.close();
	}
}
