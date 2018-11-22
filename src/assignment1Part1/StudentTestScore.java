package assignment1Part1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class StudentTestScore {

	public static void main(String[] args) {
		
		/* Name: Aurnob Jahin Islam
		 * Student number: 991464820
		 * Assignment: Assignment 1 Part 1
		 * Program name: Information Systems Security
		 * This is a program which is designed to read user inputs as test scores 
		 * of students, where the maximum number of students is 5. Array manipulation
		 * is the main focus of this program. After reading the test scores, this program 
		 * finds the best score using the array that stores the test scores, it provides 
		 * grades to according to given conditions, provides the average, the 
		 * standard deviation and also sorts scores in the increasing order.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int numOfStudents;
		int[] testScores;
		
		System.out.println("Enter the number of students : ");
		numOfStudents = Integer.parseInt(scan.nextLine());
		
		/* use of array index out of bound exception to 
		 * make sure max array size is 5
		 */
		if(numOfStudents > 5) {
			scan.close();
			throw new ArrayIndexOutOfBoundsException("Please enter a value from 1 - 5");
		}
		
		testScores = new int[numOfStudents];
		
		/*reading test scores for each student provided by the user*/
		for(int i=0; i<testScores.length; i++) {
			System.out.println("Enter test score " + (i+1)+ ": ");
			testScores[i] = scan.nextInt();
		}
		
		/*the five methods that were required to be implemented are called here*/
		outputResult(testScores);
		findBest(testScores);
		sortingScores(testScores);
		findMean(testScores);
		findStandardDeviation(testScores);
		
		scan.close();
		
	}
		
	//this method outputs the result of the test scores
	public static void outputResult(int[] n) {
		for(int i=0; i<n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}
	
	//this method finds the best score out of all, and provides the grade
	public static void findBest(int[] n) {
		int best = 0;
		
		for(int i=0; i<n.length; i++) {
			if(n[i] > best) {
				best = n[i];
			}
		}
		
		System.out.println("\nBest Score is " + best);
		
		String grade;
		
		for(int i=0; i<n.length; i++) {
			if(n[i] == best) {
				grade = "A";
			}
			else if(n[i] < best && n[i] >=(best-20)) {
				grade = "B";
			}
			else if(n[i] < (best-20) && n[i] >=(best-30)) {
				grade = "C";
			}
			else if(n[i] < (best-30) && n[i] >=(best-40)) {
				grade = "D";
			}
			else {
				grade= "F";
			}
			System.out.println("Student " + i + " score is " + n[i] + " and grade is " + grade);
		}
	}
	
	
	/*This method is used to sort the scores stored in the testScores array*/
	public static void sortingScores(int[] n) {
		Arrays.sort(n);
		System.out.println("Sorted Scores: " + Arrays.toString(n));
	}
	
	/*This method is used to finding the mean of the result scores*/
	public static double findMean(int[] n) {

		int sum = IntStream.of(n).sum();
		double mean;
		System.out.println("Sum :" + sum);
		mean = sum/n.length;
		System.out.println("Mean: " + mean);
		return mean;
	}
	
	/*This method is used to calculate the standard deviation of the result scores*/
	public static void findStandardDeviation(int[] n) {

		double var = 0.0;
		int sum = IntStream.of(n).sum();
		double avg = sum/n.length;
		
		for(int i=0;i<n.length;i++) {
			var += (n[i] - avg)*(n[i] - avg);
		}
		
		double value = var / (n.length-1);
		
		double sd = Math.sqrt(value);
		System.out.printf("The standard deviation is: %.2f", sd);
	}
}
