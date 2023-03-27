import java.util.Scanner;

public class Mountain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int points = Integer.parseInt(scan.nextLine());
		int waypoints = Integer.parseInt(scan.nextLine());
		int[] height = new int[points];
		for (int i = 0; i < points; i++) {
			height[i] = Integer.parseInt(scan.nextLine());
		}
		int start = Integer.parseInt(scan.nextLine());
		long gain = 0;
		for (int i = 0; i < waypoints-1; i++) {
			int next = Integer.parseInt(scan.nextLine());
			if(start < next){
				for (int j = start; j < next; j++) {
					if(height[j] < height[j+1]){
						gain+= height[j+1] - height[j];
					}
				}
			} else {
				for (int j = start; j > next; j--) {
					if(height[j] < height[j-1]){
						gain+= height[j-1] - height[j];
					}
				}
			}
			start = next;
		}
		System.out.println(gain);
	}
}
