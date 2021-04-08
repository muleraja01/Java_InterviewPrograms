package javasessions;

import java.util.stream.IntStream;

public class PrintNumberWithOutLoop {

	/**
	 * Print 1 to 100 without using any Loops
	 * 1.Recursive function
	 * 2.Java Streams 
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printNum(1);
		IntStream.range(1, 101).forEach(e->System.out.println(e));
	}
	public static void printNum(int num) {
		if(num<=100) {
			System.out.println(num);
			num++;
			printNum(num);
		}
	}

}
