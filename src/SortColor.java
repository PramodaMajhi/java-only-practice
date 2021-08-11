

import java.util.Arrays;

public class SortColor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int colors[] = { 0, 1, 3,1,6 };
		System.out.println();

		/*for (int i = 0; i < colors.length; i++) {
			for (int j = i+1; j<colors.length; j++) {

				if (colors[j] < colors[i]) {
					
					int temp = colors[i];
					System.out.println("Temp Value  "+ temp);
					colors[i] = colors[j];
					colors[j] = temp;
				}
			}
		}*/
		
		
		/*for (int i = 1; i < colors.length; i++) {
            for (int j = i; j > 0; j--) {
            	if (colors[j] < colors[j-1]) {
            	int temp = colors[i];				
				colors[i] = colors[j-1];
				colors[j-1] = temp;
            	}
            }
            
        }*/
        
		Arrays.sort(colors);
		
		

		for (int k = 0; k < colors.length; k++) {
			System.out.println(colors[k]);
		}

	}

}
