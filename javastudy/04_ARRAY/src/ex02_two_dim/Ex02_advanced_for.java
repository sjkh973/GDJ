package ex02_two_dim;

public class Ex02_advanced_for {

	public static void main(String[] args) {
		
		String [][] timeTable = {
				{"국어", "윤리", "수학", "영어"},
				{"미술", "수학", "과학"},
				{"체육", "사회", "수학", "영어"},
				{"국어", " 한자", "문학","수학", "영어"},
				{"음악", "국어", "수학", "영어"},
				
		};
		
		for(int i = 0; i < timeTable.length; i++) {
			for(int j = 0; j < timeTable[i].length; j++) {
				System.out.print(timeTable[i][j] + " ");
			}
			System.out.println();
		}
		System.err.println("===================================");
		//향상 for문
		
		for(String[] weekName : timeTable) { //weekName에 timeTable[i]를 넣어줌
			for(String course : weekName) { // weekName[i][j] = course
				System.out.print(course + " ");
			}
			System.out.println();
		}

	}

}
