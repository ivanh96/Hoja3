package main_package;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



public class Random_Gen {
	/* Atributos */
	Random rand = new Random();
	Integer[] rnd_list = new Integer[3000];
	Integer[] rnd_list2 = new Integer[3000];


	public Integer[] RandomFill(){
	/* Se generan 3000 numeros pseudo random */
		int rnd_value;
		for(int i=0; i<3000; i++){
			rnd_value = rand.nextInt(10000)+1;
			rnd_list[i] = rnd_value;
		}
		
	/* Fill de numeros random en el .txt */	
	try{
		FileWriter writer = new FileWriter("Random_DB.txt", true);
		for(int c=0; c<rnd_list.length; c++){
			writer.write(rnd_list[c] + " ");
		}
		writer.close();
	}
	catch(IOException e){
		System.out.println("Ups! No ha sido posible guardar los numeros.");
	}
	return rnd_list;
	}
	

	
// LEER LOS NUMEROS DESDE EL ARCHIVO DE TEXTO
	public Integer[] Read(String direccion){
		
		int i = 0;
		File file = new File(direccion);
	    Scanner inputFile = null;
	     try {
	        inputFile = new Scanner(file);
	     } 
	
	        catch (FileNotFoundException Exception) {
	           System.out.println("No hay archivo amigo");
	        }
	   
	     if (inputFile != null) {
	    	  
	    	  try {
	    	    while (inputFile.hasNext()) {
	    	      if (inputFile.hasNextInt() && i <3000) {
	    	        rnd_list2[i] = inputFile.nextInt();
	    	        i++;
	    	      } else {
	    	        inputFile.next();
	    	      }
	    	    }
	    	  } finally {
	    	    inputFile.close();
	    	  }
	    	 
	    	}
				
				
		return rnd_list2;		
			
				

				
	}
	
	
	}