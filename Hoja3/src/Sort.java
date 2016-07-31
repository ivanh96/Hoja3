/**
 * @author Diego Soler, Fredy Espana, Marlon Hernandez, Rodolfo Cacacho
 * Clase Sort
 * Clase que maneja los diferentes tipos de ordenamiento
 * @version 30/07/2016
 */

public class Sort {


	public Integer [] selectionSort(Integer[] list){
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
		}
                return list;
		}
	
	
//-------------------------------- EL mergeSort se divide en dos metodos ------------------------------------
	
   
//--------------------------------BARRA ESPACIADORA-----------------------------------------------------------
	
	public Integer [] mergeSort(Integer [] lista){
    
    //Si la lista tiene menos de 1 o menos elementos, no vale la pena ordenarla
    if (lista.length <=1){
       	 return lista;
        }
        
      //Se divide el array en dos partes, no importando si es numero impar
      Integer[] part1 = new Integer[lista.length/2];
      Integer[] part2 = new Integer[lista.length-part1.length];
      //Aqui se utiliza el metodo ArrayCopy, que permite copiar arrays de uno a otro desde ciertas posiciones indicadas
      //Se copia el array original en las dos mitades, hasta la posicion que llega la division de la parte correspondiente
      System.arraycopy(lista, 0, part1, 0, part1.length);
      System.arraycopy(lista, part1.length, part2, 0,part2.length);
      
      //Recursivamente se divide nuevamente cada mitad
      mergeSort(part1);
      mergeSort(part2);
      
      //Metodo que la ordena
      merge(part1,part2,lista);
      return lista;
    }

	
    
    public void merge(Integer[] part1, Integer[] part2,  Integer[] resultado){
    	
    	//Llevan la cuenta de la posicion de cada array
    	int array1 = 0;
    	int array2 = 0;
    	int merged = 0;
    	
    	//Ciclo mientras las posiciones sigan en cada una de las listas
    	while(array1<part1.length && array2<part2.length){
    		
    			//Aqui se compara cada posicion en los dos arrays finales (que en algun instante seran de un elemento) y los introduce al array ordenado
    		if (part1[array1].compareTo(part2[array2]) < 0){
    			resultado[merged] = part1[array1];
    			array1++;
    		}
    		
    		else{
    			
    			resultado[merged] = part2[array2];
    			array2++;
    		}
    		
    		merged++;
    	}
    	
    	//Se copia cada parte al array final
    	System.arraycopy(part1, array1, resultado, merged, part1.length-array1);
    	System.arraycopy(part2, array2, resultado, merged, part2.length-array2);
    		
    		
    }
    
//--------------------------------BARRA ESPACIADORA-----------------------------------------------------------
    


/*metodo de recursion, se convierten en dos listas con un pivote. 
La lista max ordena todos los menores al pivote, min mayores al pivote. 
La primera instancia se toma 0 como max y el ultimo valor como min*/
    public Integer [] quickSort(Integer[] list){      
        recursiveQS(list, 0, list.length - 1);
        return list;

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
    /*consultado dehttp://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html*/
    
  //--------------------------------BARRA ESPACIADORA-----------------------------------------------------------


        // El metodo insertionSort ordena de izquierda a derecha, escogiendo un valor y comparandolo con el
        // siguiente, si este es menor, lo inserta en la posicion anterior y el otro a la siguiente.
    	public Integer[] insertionSort(Integer[] list){
	
            int i, j, nuevo_Num;
            for (i = 1; i < list.length; i++) {
                nuevo_Num = list[i];
                j = i;
                while (j > 0 && list[j - 1] > nuevo_Num) {
                    list[j] = list[j - 1];
                    j--;
                }
                list[j] = nuevo_Num;
                }
            return list;
	}

/*consultado de http://www.sourcecodesworld.com/articles/java/java-data-structures/Radix_sort.asp*/

    public Integer[] radixSort( Integer[] list){

        Integer[][] bucket = new Integer[list.length][2];
        Integer[] tmp = new Integer[list.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int f = 0;

        for(k=0;k<4;k++){
            for(i=0;i<(bucket.length-1);i++){
                bucket[i][1] = i+1;
            }
            bucket[i][1] = -1;
            for(i=0;i<tmp.length;i++){
                tmp[i] = -1;
            }

            for(f=i=0;i<list.length;i++){
                j = ((0xFF<<(k<<3))&list[i])>>(k<<3);
                if(tmp[j] == -1){
                    l = tmp[j] = f;
                }else{
                    l = tmp[j];
                    while(bucket[l][1] != -1){
                        l = bucket[l][1];
                    }

                    bucket[l][1] = f;
                    l = bucket[l][1];
                }

                f = bucket[f][1];
                bucket[l][0] = list[i];
                bucket[l][1] = -1;
            }

            for(l=tmp[i=j=0];i<list.length;i++){
                for(l=tmp[i];l!=-1;l=bucket[l][1]){
                        list[j++] = bucket[l][0];
                }
            }
        }
        return list;
    }
}
