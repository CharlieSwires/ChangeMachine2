import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChangeMachine {

	static final int[] coins = {200,100,50,20,10,5,2,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> change(int i) {
		int left = i;
		ArrayList<Integer> changeList = new ArrayList<>();
		for(;left != 0;) {
			for(int coin:coins) {
				if(coin <= left) {
					left -= coin;
					changeList.add(coin);
					break;
				}
			}
		}
		return changeList;
	}

	public List<Integer> change(List<Integer> c, int i) {
		ArrayList<Integer> coins = new ArrayList<Integer>();
		for(Integer coin:c) {
			coins.add(coin);
		}
		coins.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//descending order
				return o2.compareTo(o1);

			}
		}
				);
		int left = i;
		ArrayList<Integer> changeList = new ArrayList<>();
		for(;left != 0;) {
			int index = 0;
			boolean found = false;
			for(; index < coins.size(); index++) {
				int coin = coins.get(index);
				if(coin <= left) {
					left -= coin;
					coins.remove(index);
					changeList.add(coin);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("Ran out of change");
				break;
			}
		}

		return changeList;
	}

}
