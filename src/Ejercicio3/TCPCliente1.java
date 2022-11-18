package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPCliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc= new Scanner(System.in);
		String cadena="";
		String Host = "localhost"; //"localhost"
		int Puerto = 6000;//puerto remoto	
		
		
		System.out.println("PROGRAMA CLIENTE 1 INICIADO....");
		Socket Cliente = new Socket(Host, Puerto);

		// CREO FLUJO DE SALIDA AL SERVIDOR	
		DataOutputStream flujoSalida = new
	            DataOutputStream(Cliente.getOutputStream());

		// ENVIO LA CADENA AL SERVIDOR
		System.out.print("Introduce la cadena a enviar: ");
		cadena=sc.nextLine();
		flujoSalida.writeUTF(cadena);
		

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
