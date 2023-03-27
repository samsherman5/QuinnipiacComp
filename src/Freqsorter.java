import java.util.*;

class Entry implements Comparable<Entry>{
	public Integer key;
	public Integer value;


	public int compareTo(Entry o) {
		if(value > o.value){
			return -1;
		} else if(value < o.value){
			return 1;
		} else {
			return key.compareTo(o.key);
		}
	}

}

public class Freqsorter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<Integer, Integer> map = new HashMap<>();
		List<Entry> list = new ArrayList<Entry>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(sc.nextLine());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
			else {
				map.put(num, 1);
			}
		}
		for (Integer key : map.keySet()) {
			Entry entry = new Entry();
			entry.key = key;
			entry.value = map.get(key);
			list.add(entry);
		}
		Collections.sort(list);
		for (Entry entry : list) {
			System.out.println(entry.key);
		}
	}

}
