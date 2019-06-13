import java.io.*;
import java.util.*;

public class perfectRectangle{
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rectangles:");
		int n=sc.nextInt();
		int arr[][]=new int[n][4];
		System.out.println("Enter the coordinates of each rectangle:");

		int i,j;
		for(i=0;i<n;i++){
			System.out.println("Xmin,Ymin,Xmax,Ymax of rectangle "+i);
			for(j=0;j<4;j++)
				arr[i][j]=sc.nextInt();
		}
		if(checkRectangles(arr,n)){
			System.out.println("Perfect Rectangle");
		}
		else{
			System.out.println("Invalid Rectangle");
		}
	}

	public static void pointCount(Map<String,Integer> count, int x, int y){
		String key=Integer.toString(x)+","+Integer.toString(y);
		if(!count.containsKey(key)){
			count.put(key,1);
		}
		else{
			count.put(key, count.get(key) + 1);
		}
	}

	public static boolean checkRectangles(int arr[][], int n){
		String key1,key2;
		int i,max_x=Integer.MIN_VALUE,max_y=Integer.MIN_VALUE,min_x=Integer.MAX_VALUE,min_y=Integer.MAX_VALUE;
		Map<String,Integer> count=new HashMap<String,Integer>();

		for(i=0;i<n;i++){
			min_x=Math.min(min_x,arr[i][0]);
			min_y=Math.min(min_y,arr[i][1]);
			max_x=Math.max(max_x,arr[i][2]);
			max_y=Math.max(max_y,arr[i][3]);

			pointCount(count,arr[i][0],arr[i][1]);
			pointCount(count,arr[i][0],arr[i][3]);
			pointCount(count,arr[i][2],arr[i][1]);
			pointCount(count,arr[i][2],arr[i][3]);
		}

		for(i=0;i<n;i++){
			key1=Integer.toString(arr[i][0])+","+Integer.toString(arr[i][1]);
			key2=Integer.toString(arr[i][2])+","+Integer.toString(arr[i][3]);

			if((max_x==arr[i][0]||min_x==arr[i][0]) && (min_y==arr[i][1]||max_y==arr[i][1])){
				if(count.get(key1)!=1){
					return false;
				}
			}
			else if((max_x==arr[i][2]||min_x==arr[i][2]) && (min_y==arr[i][3]||max_y==arr[i][3])){
				if(count.get(key2)!=1){
					return false;
				}
			}
			else if(count.get(key1)!=2&&count.get(key1)!=4){
				return false;
			}
			else if(count.get(key2)!=2&&count.get(key2)!=4){
				return false;
			}
		}

		return true;
	}
}