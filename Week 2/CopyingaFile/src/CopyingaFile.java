import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyingaFile {
	public static void main(String args[]) {
		String fileName;

		System.out.println("Enter file name:");
		
		Scanner scan = new Scanner(System.in);
		fileName = scan.nextLine();
		
		File text = new File("D:/Akademik/SEM 4/APPL/APPL PR/Week 2/CopyingaFile/src/" + fileName + ".txt");
		try {
			scan = new Scanner(text);
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found, try again...");
		}
	}
}

