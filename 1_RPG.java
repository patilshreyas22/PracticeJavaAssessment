import java.util.*;

class RPG{

	static class Monster{
	
		int power;
		int bonus;

		Monster(int power , int bonus){
			
			this.power = power;
			this.bonus = bonus;
		
		}
	}

	public static int maxDefeatedMonsters(int n , int e , int [] powers , int [] bonuses){
	
		List<Monster> monsters = new ArrayList<>();

		for(int i = 0 ; i < n ; i++){
		
			monsters.add(new Monster(powers[i] , bonuses[i]));
		}

		monsters.sort(Comparator.comparingInt(m -> m.power));

		int currentExperience = e;

		int defeatedMonsters = 0;

		for(Monster monster : monsters){
		
			if(currentExperience >= monster.power){
			
				currentExperience += monster.bonus;
				defeatedMonsters++;
			
			}else{
			
				break;
			}
		
		}

		return defeatedMonsters;
	
	}

	public static void main(String args []){
	
	
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int e = scanner.nextInt();

		int [] powers = new int[n];

		int [] bonuses = new int[n];

		for(int i = 0 ; i<n ; i++){
			
			powers[i] = scanner.nextInt();
		
		}

		for(int i = 0 ; i<n ; i++){
		
			bonuses[i] = scanner.nextInt();
		}

		int result = maxDefeatedMonsters(n , e , powers , bonuses);
		System.out.println(result);
	
	}



}
