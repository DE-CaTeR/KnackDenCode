package de.acc;

import java.util.Arrays;

/**
 * @author Carsten
 *
 */
public class KnackDenCode {
	static class Masher {
		static byte[] mash(String s){
			System.out.println("mashing String: '" + s + "'");
			byte[] bytes = s.getBytes();
			byte[] mashed = new byte[bytes.length];
			
			for (int i = 0; i < bytes.length; i++) {
				mashed[i] = (byte) ~bytes[i];
			}
			// #### Debugging
			System.out.println("in:\t" + Arrays.toString(bytes));
			System.out.println("out:\t" + Arrays.toString(mashed));
			
			
			return mashed;
		}
		
		static String unmash(byte[] s) {
			System.out.println("unmashing....");
			byte[] bytes = s;
			byte[] unmashed = new byte[bytes.length];
			
			for (int i = 0; i < bytes.length; i++) {
				unmashed[i] = (byte) ~bytes[i];
			}
			// #### Debugging
			System.out.println("in:\t" + Arrays.toString(bytes));
			System.out.println("out:\t" + Arrays.toString(unmashed));
			System.out.println("unmashed String: '" + new String(unmashed) + "'");
			
			
			return new String(unmashed);
		}
	}

	public static void main(String[] args) {
		// Test the masher
		String testString = "Ein Team, ein Ziel, ein Weg.";
		
		/***  Debugging
		System.out.println("String:\t" + testString + " (" + testString.length() + ")");
		
		byte[] out1 = testString.getBytes();
		System.out.println("oByte:\t" + Arrays.toString(out1) + " (" + out1.length + ")");
		
		byte[] mashed = Masher.mash(testString);
		String unmashed = Masher.unmash(mashed);
		
		System.out.println("Out:\t" + unmashed + " (" + unmashed.length() + ")");
		
		*****/
		boolean success = Masher.unmash(Masher.mash(testString)).equals(testString);
		System.out.print("Vergleiche....");
		if (success){
			System.out.println("OK");
		} else {
			System.out.println("Fehler");
		}
		

	}

}
