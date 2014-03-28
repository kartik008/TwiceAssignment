import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Jumble2 {
	
	static Scanner sc = new Scanner(System.in);
	static HashSet<String> Dictionary = new HashSet<String>();
	static HashSet<String> ans = new HashSet<String>();

	static char[] alphabet;
	public static void main(String args[])
	{
		
		
		String path = null;
		System.out.println(" Enter the file path (Dictionary)");
		path = sc.next();
		
		System.out.println("Enter the word ");
		String word = sc.next();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		String line;
		try {
			while ((line = br.readLine()) != null) {
		String array[] = line.split(" ");
		Dictionary.add(array[0]);
		
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		 alphabet = word.toCharArray();
		 
		StringBuilder sb = new StringBuilder();
        for (int length = 2; length <= word.length(); length++) {
            sb.setLength(length);
        
            generator(sb, 0);
 
        }
        
        Iterator it = ans.iterator();
        while(it.hasNext())
        {
        	String ans1 = (String)it.next();
        	System.out.println(ans1);
        }
        
	
	}
	
	static void generator(StringBuilder sb, int n) {
        if (n == sb.length()) {
        	if(Dictionary.contains(sb.toString()))
        	{	
        		//System.out.println(sb.toString());
        		ans.add(sb.toString());
        	}
            return;
        }
        for (char letter : alphabet) {
            sb.setCharAt(n, letter);
            generator(sb, n + 1);
        }
       
	}
	
	
}
