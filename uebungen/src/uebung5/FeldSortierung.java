package uebung5;
import java.util.Scanner;
public class FeldSortierung {
	public static void main(String[] args) {
		int[] array1= {2,1,4,3,0};
		
		
	}
	
	static void selectionSort(int[] array) {
		 	 
		for(int i=0;i<array.length-1;i++) {
			
			int index=i;
			for(int j=i+1;index<array.length;j++) {
				if(array[j]<array[index]) {
					index=j;
				}
			}
			int smallerNumber=array[index];//1
			array[index]=array[i];//array ot 1 poziciq= array ot 0 poz.;
			array[i]=smallerNumber;//array ot 0 poz. = nai malkoto;
		}	
		
	}
	static void bubbleSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					int temp=array[j];
					array[j]= array[j+1];
					array[j+1]= temp;
				}
			}
		}
		
	}

}
