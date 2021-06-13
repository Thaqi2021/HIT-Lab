package Lab2;

public class ArrayAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int y[][] = {{11,12,13},{14,15,16},{17,18,19}};
		int z[][] = new int[3][3];
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<y.length;j++) {
				z[i][j]=x[i][j]+y[i][j];
			}
		}
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<y.length;j++) {
				System.out.print(z[i][j]+"("+i+","+j+") ");
			}
			System.out.println();
			
		}
	}

}
