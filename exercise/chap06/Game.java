
interface FightAble{
	void specialFight();
	void commonFight();

}
abstract class CommonFight implements FightAble{
	public void commonFight(){
		System.out.println("普通攻击");
	}

}

class Warrior  extends CommonFight{
	public void specialFight(){
		System.out.println("武器攻击");
	
	}


}

class Mage  extends CommonFight{
	public void specialFight(){
		System.out.println("法术攻击");
	}
	

}


