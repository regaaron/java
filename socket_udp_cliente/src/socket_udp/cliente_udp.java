/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_udp;

import java.net.*;

public class cliente_udp {

    public static void main(String args[]) throws Exception {
        DatagramSocket dgSocket;
        DatagramPacket datagram;
        InetAddress destination = null;
        //byte msg[] = new byte[1024];
        String saludo = new String("hola" + "\0");
        byte msg[] = saludo.getBytes();
        //byte msg[]=("00200001001000000000"+"\0").getBytes();
        // Establecemos en socket bajo UDP
        dgSocket = new DatagramSocket(
                Constantes.PUERTO_DEL_CLIENTE,
                InetAddress.getByName(Constantes.HOST_CLIENTE));
        //recogemos el destino del servidor, 
        //  que se le pasa como parámetro
        try {
            destination = InetAddress.getByName(
                    Constantes.HOST_SERVIDOR);
            //destination=InetAddress.getByName("localhost");
        } catch (UnknownHostException uhe) {
            System.err.println("Host no encontrado : " + uhe);
            System.exit(-1);
        }
        byte msgR[] = new byte[1024];
        //creamos un DATAGRAMA, con el mensaje, 
        //la longitud, la dirección y el puerto
        datagram = new DatagramPacket(msg, msg.length,
                destination,
                Constantes.PUERTO_DEL_SERVIDOR);
        //enviamos el datagrama
        dgSocket.send(datagram);
        System.out.println("Dato enviado");
        datagram = new DatagramPacket(msgR, msgR.length);
        //esperamos que nos llegue respuesta desde el servidor 
        dgSocket.receive(datagram);
        //ha llegado un datagrama, para ver los 
        //datos se utiliza getDAta()
        String received = new String(datagram.getData());
        received = received.split("\0")[0];

        System.out.println("DATOS DEL DATAGRAMA: "
                + received);
//cerramos el socket UDP
        dgSocket.close();
    }
} // final de la clase cliente 

