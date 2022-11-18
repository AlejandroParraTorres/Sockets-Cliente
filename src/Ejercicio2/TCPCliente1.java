package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPCliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc= new Scanner(System.in);
		int numero;
		String Host = "localhost"; //"localhost"
		int Puerto = 6000;//puerto remoto	
		
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket Cliente = new Socket(Host, Puerto);

		// CREO FLUJO DE SALIDA AL SERVIDOR	
		DataOutputStream flujoSalida = new
	            DataOutputStream(Cliente.getOutputStream());

		// ENVIO EL NUMERO
		System.out.print("Introduce el numero del cual deseas saber su cuadrado: ");
		numero=sc.nextInt();
		flujoSalida.writeInt(numero);
		

		// CREO FLUJO DE ENTRADA AL SERVIDOR	
		DataInputStream flujoEntrada = new 
	            DataInputStream(Cliente.getInputStream());

		// EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" + 
	               flujoEntrada.readUTF());

		// CERRAR STREAMS Y SOCKETS	
		flujoEntrada.close();	
		flujoSalida.close();	
		Cliente.close();
		sc.close();

	}

}
