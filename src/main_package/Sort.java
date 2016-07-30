package main_package;

public class Sort {
	
	public void selectionSort(Integer[] list){
		int minNumber = 0;
		
		for (int i=0; i<list.length; i++){
			minNumber = i;
			for(int c=(i+1); c < list.length; c++){
				if(list[c] < list[minNumber]){
					minNumber = c;
				}
			}
			if (minNumber != i){
				int temp_position = list[i];
				list[i] = list[minNumber];
				list[minNumber] = temp_position;
			}
			System.out.println(list[i]);
		}
		}
}
