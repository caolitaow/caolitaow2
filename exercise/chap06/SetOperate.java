import java.util.*;

class SetOperate{

	Set<Integer> set = new HashSet<>();
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<Integer> list(){
		int i = 1;
		while(i!=0){
			i=Integer.parseInt(new Scanner(System.in).next());
			if(i!=0)
				list.add(i);
		}
		return list;
	}

	void set20(){
		int i = 0;
		Random ra = new Random();
		while(i<10){
			set.add(ra.nextInt(20)+1);
			i++;
		}

		System.out.println(set);
	//	set.forEach(System.out::println);
	
	}
	
	void listMax(){
		Collections.sort(list());
		System.out.println("最大的数为:");
		System.out.println(list.get(list.size()-1));
	
	}

	public static void main(String[] args){
		SetOperate op = new SetOperate();
		op.set20();
		op.listMax();
	}


}
