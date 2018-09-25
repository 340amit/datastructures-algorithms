// Salesforce
// String source a b c d
// String target a b P Q
// Use 2d matrix and form data table to find out the common pattern
// if char matches to another take diagonal element and if not matches take min of left, upper left,above cells

package amit.cci.dynamicprogramming;

public class TransformStringMinOperation {

	public static void main(String[] args) {
		TransformStringMinOperation t=new TransformStringMinOperation();
		t.displayMatrix(t.getOperations("abcd", "KbcQ"));

	}
	
	public int[][] getOperations(String source,String target) {
		int row=source.length();
		int col=target.length();
		
		int[][] data=new int[row][col];
		
//		Initialize first row
		for(int c=0;c<col;c++) {
			if(source.charAt(0)==target.charAt(c)) {
				data[0][c]=0;
			}else {
				if(c-1<0) {
					data[0][c] = 1;
				}else {
					data[0][c] = data[0][c-1]+ 1;
				}
			}
		}
		
//		Initialize first col
		for(int r=0;r<row;r++) {
			if(source.charAt(r)==target.charAt(0)) {
				data[r][0]=0;
			}else {
				if(r-1<0) {
					data[r][0] =1;
				}else {
					data[r][0] =data[r-1][0] +1;
				}
			}
		}
		
		for(int r=1;r<row;r++) {
			for(int c=1;c<col;c++) {
				if(source.charAt(c)==target.charAt(c)) {
					data[r][c]=data[r-1][c-1];
				}else {
					data[r][c] =Math.min(Math.min(data[r][c-1], data[r-1][c-1]),data[r-1][c]) +1;
				}
			}
		}
		
		
		return data;
	}
	
	public void displayMatrix(int[][] data) {
		int row=data.length;
		int col=data[0].length;
		
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				System.out.print(data[r][c]+" ");
			}
			System.out.println();
		}
	}

}
