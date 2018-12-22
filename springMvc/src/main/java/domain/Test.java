package domain;

import java.lang.ref.WeakReference;

public class Test {
	public static void main(String[] args) {
		WeakReference<String> sr = new WeakReference<String>(new String("nini"));
		System.out.println(sr.get());
		System.gc();
		System.out.println(sr.get());
	}
	
}
