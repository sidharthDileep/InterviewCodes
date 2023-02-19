package problems.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class CountWordsInFile {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\VR763VS\\OneDrive - EY\\Documents\\Interview_Notes\\NT-Sidharth.txt");
		String fileName = "C:\\Users\\VR763VS\\OneDrive - EY\\Documents\\Interview_Notes\\NT-Sidharth.txt";
		String name = "Probem";

		/*
		 * Long wordsCount = Files.lines(Paths.get(file))
		 * .flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
		 * .filter(s->s.length()>0).count(); System.out.println(wordsCount);
		 */

		String fileName2 = "C:\\Codes\\60ips.txt";
		/*
		 * try { System.out.println("No. of occurences : " + countWords("Problem",
		 * "C:\\Users\\VR763VS\\OneDrive - EY\\Documents\\Interview_Notes\\NT-Sidharth.txt"
		 * ));
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); }
		 */

		try (Stream<String> stream = Files.lines(Paths.get(fileName2))) {
			// stream.filter(line -> line.contains(" " + name + "
			// ")).forEach(System.out::println);
			long count = stream.filter(line -> line.contains(" " + "153" + " ")).count();
			System.out.println("Count : " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String[] words = null;
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String s;
			String input = "Problem";

			int count = 0;

			while ((s = br.readLine()) != null) {
				words = s.split(" ");
				for (String word : words) {
					if (word.equals(input))
						count++;
				}

			}

			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int countWords(String word, String file) throws FileNotFoundException {
		int count = 0;

		Scanner sc = new Scanner(new FileInputStream(file));

		while (sc.hasNextLine()) {

			String line = sc.nextLine();
			System.out.println(line);

			if (line.indexOf(word) != -1) {
				count++;
			}

		}

		return count;
	}

}
