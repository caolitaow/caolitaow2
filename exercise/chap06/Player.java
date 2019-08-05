import java.util.*;
class Player {

	public String input(){
		return	new Scanner(System.in).next();
	
	}

	FightAble select(String str){
		switch(str){
			case "法师":return new Mage();
			case "战士":return new Warrior();
			default:return null;
		
		}
	}

	public void fight(){
		
		System.out.println("请您选择角色：");
		FightAble fa = select(input());
		if(fa!=null){
			if(fa instanceof Mage){
				fa.specialFight();
				fa.commonFight();
			}else if(fa instanceof Warrior){
				fa.specialFight();
				fa.commonFight();
			}
		
		}else{
			System.out.println("你还没有选定角色！");
		}

	}

	public static void main(String[] args){
		new Player().fight();
	}
	
	

}

