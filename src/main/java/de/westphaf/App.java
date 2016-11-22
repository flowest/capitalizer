package de.westphaf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter something:");
		String input = br.readLine().toUpperCase();
		System.out.print(input);
    }
}
