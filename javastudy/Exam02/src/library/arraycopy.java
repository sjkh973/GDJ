package library;

public class arraycopy {
public static void main(String[] args) {
	
	int[] arr1 = {1,2,3,4};
	
	int[] arr2 = {5,6,7,8};
	int idx = 3;
	System.arraycopy(arr1, 1, arr2, 1, 3);
	
	for(int i = 0; i < arr2.length; i++) 		
		System.arraycopy (arr1, (i + 1), arr2, i, idx - (i - 1));
		System.out.println(arr2[2]);
	}
}

