
public class SampleTest {

	public static void main(String[] args) {
		String s[] = {"H","e","l","l","o"};
		
		//reverse2(s);
		//show(s);
		
		String test = "Hello";
		System.out.println(reverseItStrBuffer(test));
		
	}
	// reverses the entries in the array
    public static void reverse2(String[] s) {
        int n = s.length;
        int condition = n/2;
        for (int i = 0; i < condition; i++) {
            exch(s, i, n-i-1);
        }
    }
	 // swap a[i] and a[j]
    public static void exch(String[] a, int i, int j) {
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    // print the entries in the array a[] to standard output
    public static void show(String[] a) {
        for (int i = 0; i < a.length; i++) {
           System.out.print(a[i]);
        }
    }

    
    public static String reverseItStrBuffer(String source) {
    	
    	
    	StringBuffer buffer = new StringBuffer(source.length());
    	for(int i = source.length() -1; i >= 0 ; i--) {
    		buffer.append(source.charAt(i));
    	}
    	return buffer.toString();
    }
}
