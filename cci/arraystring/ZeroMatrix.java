//If any element is zero make complete row column zero
package amit.cci.arraystring;

public class ZeroMatrix {

	public static void main(String[] args) {
		int N=4;
		boolean x[]=new boolean[N];
		boolean y[]=new boolean[N];
		int mat[][]= {{1,2,3,4},
					  {5,6,7,0},
					  {9,0,11,0},
					  {13,14,15,16}};
//		System.out.println("mat.length"+mat[0].length);
		displayMatrix(N, mat);
		System.out.println();
		markZero(N, mat, x, y);
		makeZero(N, mat, x, y);
		System.out.println();
		displayMatrix(N, mat);

	}
	static void makeZero(int N,int[][] mat,boolean[] x,boolean[] y) {
		for(int k=0;k<N;k++) {
			if(x[k]==true) {
				for(int l=0;l<N;l++) {
					mat[k][l]=0;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			if(y[i]==true) {
				for(int j=0;j<N;j++) {
					mat[j][i]=0;
				}
			}
		}
	}
	static void markZero(int N,int[][] mat,boolean[] x,boolean[] y) {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(mat[i][j]==0) {
					x[i]=true;
					y[j]=true;
				}
			}
		}
		for(int m=0;m<N;m++) {
			System.out.print(x[m]+" ");
		}
		System.out.println();
		for(int n=0;n<N;n++) {
			System.out.print(y[n]+" ");
		}
		System.out.println();
		
	}
	static void displayMatrix(int N,int[][] mat) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}


}
