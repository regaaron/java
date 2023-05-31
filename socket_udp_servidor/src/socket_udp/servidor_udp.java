/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_udp;

/**
 *
 * @author Chuy
 */
import java.net.*;
import java.io.*;
import java.util.*;

public class servidor_udp {

    public static void main(String[] args) throws IOException {
        byte msg[] = new byte[1024];
        //Creamos el socket UDP del servidor en el pueto asociado
        DatagramSocket s = new DatagramSocket(
                Constantes.PUERTO_DEL_SERVIDOR);
        System.out.println("Servidor Activo");
        //implementacion del protocolo del servidor 
        String dato;
        while (true) {
            DatagramPacket recibido = new DatagramPacket(
                    new byte[1024], 1024);
            System.out.println("Esperando...");
            //llega un datagrama
            s.receive(recibido);
            System.out.println("Ha llegado una peticion \n");
            System.out.println("Procedente de :"
                    + recibido.getAddress());
            System.out.println("En el puerto :"
                    + recibido.getPort());
            dato = new String(recibido.getData());
            dato=dato.split("\0")[0];
            System.out.println("Dato: " +dato);
            System.out.println("Sirviendo la petición");
            //se prepara el mensaje a enviar con la fecha del sistema
            String message = new String("HORA DEL SERVIDOR "
                    + new Date() + "\0");
            //Date dato=new Date();
            //message=dato.getMinutes()+"";
            msg = message.getBytes();
            //se crea el datagrama que contendrá al mensaje 
            DatagramPacket paquete = new DatagramPacket(msg,
                    msg.length, recibido.getAddress(),
                    recibido.getPort());
            //se le envia al cliente
            s.send(paquete);
        }
    }
}
