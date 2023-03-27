import java.util.*;

class Point implements Comparable<Point>{
	public Integer x;
	public Integer y;
	public Integer prom;
	public boolean isPeak;

	public int compareTo(Point o) {
		if(prom > o.prom){
			return -1;
		} else if(prom < o.prom){
			return 1;
		} else {
			return x.compareTo(o.x);
		}
	}
	public Point(int x, int y, int prom, boolean isPeak) {
		this.x = x;
		this.y = y;
		this.prom = prom;
		this.isPeak = isPeak;
	}

}
public class MOUNTAINSCOLS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int ranks = Integer.parseInt(sc.nextLine());
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(sc.nextLine());
			points.add(new Point(i, height, 0, false));
		}
		findPeaks(points);
		//printPoints(points);
		findProminence(points);
		//printPoints(points);
		Collections.sort(points);
		for (int i = 0; i < ranks; i++) {
			int rank = Integer.parseInt(sc.nextLine());
			System.out.println(points.get(rank).x + points.get(rank).prom);
		}
	}

	public static void findPeaks(List<Point> points){
		for (int i = 0; i < points.size(); i++) {
			/*if(points.get(i).y > points.get(i-1).y && points.get(i).y > points.get(i+1).y){
				points.get(i).isPeak = true;
			}*/
			if (i != 0 && i != points.size() - 1) {
				if (points.get(i).y > points.get(i-1).y && points.get(i).y > points.get(i+1).y) {
					points.get(i).isPeak = true;
				}
			}
			else if (i == 0 && points.get(i).y < points.get(i+1).y) {
				points.get(i).isPeak = true;
			}
			else if (i == points.size() - 1 && points.get(i).y < points.get(i-1).y) {
				points.get(i).isPeak = true;
			}
		}
		/*for (Point point : points) {
			System.out.print(point.x + " " + point.y + " " + point.isPeak + " ");
			System.out.println();
		}*/
	}

	public static void findProminence(List<Point> points) {
		int highestHeight = 0;
		int highestPeak = 0;
		for (int i = 0; i < points.size(); i++) {
			if(points.get(i).isPeak){
				if(points.get(i).y > highestHeight){
					highestHeight = points.get(i).y;
					highestPeak = i;
				}
			}
		}
		points.get(highestPeak).prom = highestHeight;
		//System.out.println(highestPeak);
		//System.out.println(highestHeight);
		for (int i = 0; i < points.size(); i++) {
			//System.out.println(i);
			//System.out.println(points.size());
			if (i != highestPeak && points.get(i).isPeak) {
				//System.out.println("here");
				int col1 = 0;
				int col2 = 0;
				if (i != points.size() - 1) {
					int index = i;
					while (index < points.size() - 1) {
						if (col2 > points.get(index).y) {
							col2 = points.get(index).y;
						}
						index++;
					}
				}
				if (i != 0) {
					int index = i;
					while (index > 0) {
						if (col1 > points.get(index).y) {
							col1 = points.get(index).y;
						}
						index--;
					}

				}
				int col = Math.max(col1, col2);
				int prom = points.get(i).y - col;
				//System.out.println(prom);
				points.get(i).prom = points.get(i).y - col;
			}
		}
		/*for (Point point : points) {
			System.out.print(point.x + " " + point.y + " " + point.isPeak + " " + point.prom);
			System.out.println();
		}*/
	}

	//write a method to print the points array
	public static void printPoints(List<Point> points) {
		for (Point point : points) {
			System.out.print(point.x + " " + point.y + " " + point.isPeak + " " + point.prom);
			System.out.println();
		}
	}

}
