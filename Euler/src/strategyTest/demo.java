package strategyTest;

import selectiveAmnesia.App;

public class demo {
	
		private static int len=1000;
		
		public static void main(String[] args) {
			App[] a=new App[len];
			float[] f=new float[len];
			int[] freq=new int[len];
			
			for(int i=0;i<len;i++){
				a[i]=new App();
				f[i]=(float) a[i].ans();
				freq[(int)f[i]]++;
			}
			
			float ans = 0;
			for(int i=0;i<len;i++){
				ans+=(float)(f[i]*freq[(int)f[i]]);
			}
			System.out.println(ans/(len*len));
		}
}
