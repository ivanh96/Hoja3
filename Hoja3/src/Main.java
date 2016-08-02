public class Main {

	public static void main(String[] args) {
		Random_Gen rnd = new Random_Gen();
		rnd.RandomFill();
                Integer[] listaInsertion = rnd.Read("Random_DB.txt");
                Integer[] listaMerge = rnd.Read("Random_DB.txt");
                Integer[] listaQuickSort = rnd.Read("Random_DB.txt");
                Integer[] listaSelection = rnd.Read("Random_DB.txt");
                Sort sort = new Sort();

                System.out.println("Tiempos de ejecucion de los Sort: \n");
                
                
                long st1 = System.nanoTime();
                listaInsertion = sort.insertionSort(listaInsertion);             
                long end1 = System.nanoTime();
                System.out.println("Tiempo Insertion: " + (end1 - st1) + " nano segundos");
                
                long st2 = System.nanoTime();
                listaMerge = sort.insertionSort(listaMerge);             
                long end2 = System.nanoTime();
                System.out.println("Tiempo Merge: " + (end2 - st2) + " nano segundos");

                long st4 = System.nanoTime();
                listaSelection = sort.selectionSort(listaSelection);            
                long end4 = System.nanoTime();
                System.out.println("Tiempo Selection: " + (end4 - st4) + " nano segundos");    
                
                long st3 = System.nanoTime();
                listaQuickSort = sort.quickSort(listaQuickSort);             
                long end3 = System.nanoTime();
                System.out.println("Tiempo QuickSort: " + (end3 - st3) + " nano segundos");
                
                System.out.println("\nVerificacion de lista ordenada: \nPrimeros 5 valores\n");

                for(int i=0; i<5; i++){
                
                    System.out.println("Insertion: "+String.valueOf(listaInsertion[i]));
                    System.out.println("Merge: "+String.valueOf(listaMerge[i]));
                    System.out.println("Selection: " + String.valueOf(listaSelection[i]));
                    System.out.println("QuickSort: " + String.valueOf(listaQuickSort[i]));
                }
                
                System.out.println("\nValores intermedios: \n");
                
                for(int i=1500;i < 1505; i++){
                
                    System.out.println("Insertion: "+String.valueOf(listaInsertion[i]));
                    System.out.println("Merge: "+String.valueOf(listaMerge[i]));
                    System.out.println("Selection: " + String.valueOf(listaSelection[i]));
                    System.out.println("QuickSort: " + String.valueOf(listaQuickSort[i]));
                }

                System.out.println("\nUltimos valores: \n");
                
                for(int i=2995;i < 3000; i++){
                
                    System.out.println("Insertion: "+String.valueOf(listaInsertion[i]));
                    System.out.println("Merge: "+String.valueOf(listaMerge[i]));
                    System.out.println("Selection: " + String.valueOf(listaSelection[i]));
                    System.out.println("QuickSort: " + String.valueOf(listaQuickSort[i]));
                }
                
	}

}
