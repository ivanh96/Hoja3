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
		
		
    public void insertionSort(Integer[] list) {
        // TODO implement here
        return null;
    }

    /**
     * @param List[int] 
     * @return
     */
    public void mergeSort(Integer[] list) {
        // TODO implement here
        return null;
    }


/*metodo de recursion, se convierten en dos listas con un pivote. 
La lista max ordena todos los menores al pivote, min mayores al pivote. 
La primera instancia se toma 0 como max y el ultimo valor como min*/
    public void quickSort(Integer[] list){      
        recursiveQS(list, 0, list.length - 1);
        System.out.println(list);

    }    

/*el metodo recursivo parte la lista en dos, y va ordenando dependiendo del pivote, en max y min*/
    public void recursiveQS(Integer[] list, int max, int min){
        int index = partition(list, max, min);

        if (max < index - 1){
            recursiveQS(list, max, index - 1);
        }

        if (min > max){
            recursiveQS(list, index, min);
        }
    }

    public int partition(Integer[] list, int max, int min){
        int pivot = list[max]; /*el max se toma como pivote*/

        while (min <= max){ /*se busca el numero mayor al pivote, desde la izquierda*/
            while (list[min] < pivot){
                min++;
            }
            
            while (list[max] > pivot){ /*se busca el numero menor al pivote, desde la derecha*/
                max--;
            }

            if (min <= max){ /*se cambian los valores para seguir ordenando*/ 
                int tmp = list[min];
                list[min] = list[max];
                list[max] = tmp;

                /*se incrementa el valor de donde se encuentran el max y el min hasta llegar al pivote*/
                min++;
                max--;
            }
        }
        return min;
    }
    
    public void radixSort(Integer[] list) {
        // TODO implement here
        return null;
    }
}
