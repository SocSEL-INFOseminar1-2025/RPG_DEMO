package rpg.area;

import java.util.Random;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.printExplorer;
import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

/*Areaクラスを継承*/
public abstract class Dungeon extends Area {
	private static Random random = new Random();
	
	protected int floorNum;
	protected int encountCounter;
	
	public Dungeon() {}
	
	protected abstract Monster nextBoss();
	protected abstract Monster nextMob(int i);
	protected abstract Area nextArea();
	
	// Areaクラスからの
	@Override
	public Area access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while (true) {
			System.out.println("どうしますか");
			System.out.println("1:探索する　2：はじまりの町へ戻る");
			int nextMove = ScanCommand.scan(1, 2);
			
			// 移動表現
			printExplorer.walk();

			if (nextMove == 1) {
				String result = this.explore(party);

				if (result.equals("WIN")) {
					// ダンジョン全クリア
					if (floorNum == 3) {
						DungeonCLEAR GAMECLEAR =  new DungeonCLEAR();
						GAMECLEAR.access(party);
						
					} else {
						System.out.println("どうしますか");
						System.out.println("1:ダンジョンを進む　2：はじまりの町へ戻る");
						nextMove = ScanCommand.scan(1, 2);
						
						if(nextMove == 1) {
							printExplorer.walk();
							// 今いる階層のクラスにおけるnextAreaメソッドを呼び出す
							Area nextArea = this.nextArea();
							nextArea.access(party);
						} else {
							Town town = new Town();
							town.access(party);
						}
					}
					
				} else if (result.equals("LOSE")) {
					DungeonGAMEOVER GAMEOVER =  new DungeonGAMEOVER();
					GAMEOVER.access(party);	
				}
				
			} else if (nextMove == 2) {
				Town town = new Town();
				town.access(party);
			}
		}
	}
	
	public String explore(HeroParty party) {
		// 移動表現
		printExplorer.walk();
		
		String result;
		while (true) {
			int randomNum = random.nextInt(2);
			
			// ボスの出現（戦闘が3回以上がボスモンスター出現の必要条件）
			if ((randomNum == 0 && this.encountCounter >= 3)) {
				result = this.encountBoss(party);
				
				// 逃亡成功
				if(result.equals("ESCAPE")){
					AbstractCharacter[] members = party.getMembers();
					for(AbstractCharacter m : members) {
						m.init();
					}
					nextMoveDungeon(party);
				}
				return result;
				
			// モブの出現
			} else if (1 <= randomNum && randomNum <= 3) {
				result = this.encountMob(party);
				
				// 敗北で終了
				if(result.equals("LOSE")){
					return result;
					
				// 逃亡成功
				} else if(result.equals("ESCAPE")){
					AbstractCharacter[] members = party.getMembers();
					for(AbstractCharacter m : members) {
						m.init();
					}
					nextMoveDungeon(party);
					
				// 勝利時に次の行動を尋ねる
				} else {
					nextMoveDungeon(party);
				}
			} 
		}
	}
	
	// Areaクラスからの
	@Override
	public void printArea() {
		System.out.println("現在の場所は" + getName() + "地下" + floorNum + "階です．");
	}
	
	private String encountMob(HeroParty party) {
		System.out.println("モンスターと遭遇した");

		// モンスターパーティ作成
		// モンスターをランダムな数生成（最大3） モンスターは継承先で指定
		int randomNum = random.nextInt(3);
		Monster ms[] = new Monster[randomNum + 1];
		for (int i = 0; i <= randomNum; i++) {
			// 今いる階層のクラスにおけるnextMobメソッドを呼び出す
			ms[i] = this.nextMob(i);
		}
		MonsterParty mpty = new MonsterParty(ms);
		
		// バトル開始
		BattleField bf = new BattleField();
		String result = bf.battle(party, mpty);
		this.printBattleResult(result,"戦い");
		
		return result;
	}
	
	private String encountBoss(HeroParty party) {
		System.out.println("ボスモンスターと遭遇した");
		
		// ボスモンスターとモブモンスターを作成(継承先で設定)
		// 今いる階層のクラスにおけるnextBossメソッド・nextMobメソッドを呼び出す
		Monster bm[] = {
				this.nextMob(1),
				this.nextBoss(),
				this.nextMob(2)
		};
		MonsterParty bmpty = new MonsterParty(bm);
		
		// バトル開始
		BattleField bf = new BattleField();
		String result = bf.battle(party, bmpty);
		this.printBattleResult(result,"ボス");
		
		return result;
	}
	
	private void printBattleResult(String result, String string) {
		if (result.equals("WIN")) {
			System.out.println("勇者たちは"+string+"に勝利した");
			System.out.println();
		} else if(result.equals("LOSE")){
			System.out.println("勇者たちは"+string+"に敗北した");
			System.out.println();
		} else if(result.equals("ESCAPE")){
			System.out.println("勇者たちは"+string+"から逃げ出した");
			System.out.println();
		}
	}
	
	// 追加要素：ダンジョン内での次の行動を尋ねるメソッド
	private void nextMoveDungeon(HeroParty party) {
		System.out.println("次の行動を選択して下さい");
		System.out.println("1:ダンジョンの探索を続ける　2：はじまりの町へ戻る");
		int nextMove = ScanCommand.scan(1, 2);
		
		if(nextMove == 1) {
			// 継続で戦闘回数加算
			this.encountCounter += 1;
			printExplorer.walk();
		} else {
			Town town = new Town();
			town.access(party);
		}
	}
}
