public class Main {

	public static void main(String[] args) {
		Random_Gen rnd = new Random_Gen();
		rnd.RandomFill();
                Integer[] listaInsertion = rnd.Read("Random_DB.txt");
                Integer[] listaMerge = rnd.Read("Random_DB.txt");
                Integer[] listaQuickSort = rnd.Read("Random_DB.txt");
                Integer[] listaSelection = rnd.Read("Random_DB.txt");
                Integer[] listaRadix = rnd.Read("Random_DB.txt");
                Sort sort = new Sort();
                listaInsertion = sort.insertionSort(listaInsertion);
                listaMerge = sort.mergeSort(listaMerge);
                listaQuickSort = sort.quickSort(listaMerge);
                listaSelection = sort.selectionSort(listaSelection);
                listaRadix = sort.radixSort(listaRadix);
                for(int i=0; i<10; i++){
                System.out.println("Insertion: "+String.valueOf(listaInsertion[i]));
                System.out.println("Merge: "+String.valueOf(listaMerge[i]));
                System.out.println("Quick: "+String.valueOf(listaQuickSort[i]));
                System.out.println("Selection: "+String.valueOf(listaSelection[i]));
                System.out.println("Radix: "+String.valueOf(listaRadix[i]));
                }
                
                
                
	}

}
