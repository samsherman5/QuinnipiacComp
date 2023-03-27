import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpellingBee {
	static long pansum = 0;
	static long matchsum = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dic = Integer.parseInt(scanner.nextLine());
		int testcases = Integer.parseInt(scanner.nextLine());

		Set<String> dictionary = new HashSet<String>();
		for(int i = 0; i < dic; i++) {
			dictionary.add(scanner.nextLine());
		}
		for(int j = 0; j< testcases; j++) {
			System.out.println(solve(scanner.nextLine(), dictionary));

		}
		System.out.println(pansum + " " + matchsum);

	}
	public static String solve(String word, Set<String> dictionary){
		long matchingWords = 0;
		long panangram = 0;
		Set<String> letters = new HashSet<String>(Arrays.asList(word.split("")));
		for(String keys: dictionary){
			Set<String> lettersDict = new HashSet<String>(Arrays.asList(keys.split("")));

			Set<String> workingDict = new HashSet<String>(lettersDict);
			if(workingDict.removeAll(letters) && workingDict.isEmpty() && lettersDict.contains(word.substring(0,1))){
				matchingWords++;
				Set<String> working = new HashSet<String>(letters);
				if(working.removeAll(lettersDict) && working.isEmpty()){
					panangram++;
				}
			}
		}
		pansum += panangram;
		matchsum += matchingWords;
		return "" + panangram + " " + matchingWords;
	}

}
