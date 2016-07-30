package main_package;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Random_Gen {
	/* Atributos */
	Random rand = new Random();
	Integer[] rnd_list = new Integer[10000];
	

	public void RandomFill(){
	/* Se generan 3000 numeros pseudo random */
		int rnd_value;
		for(int i=0; i<10000; i++){
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
	}
	

}
