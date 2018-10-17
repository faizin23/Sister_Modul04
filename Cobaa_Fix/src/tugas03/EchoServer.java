/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas03;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.BreakNode;

public class EchoServer {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;
    public String nim_e = "";
    public String nama_e = "";
    public String asal_e = "";
    public String kelas_e = "";
    public String index_e;
    
    
    

    public EchoServer() {
        try {
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Service active on port " + socket.getLocalPort());
        } catch (Exception e) {
            System.err.println("Unable to bind port");
        }
    }
    

    public void serviceClients() throws IOException, ClassNotFoundException {

        List<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
        SerializationDemo demo = new SerializationDemo();
        //

        byte[] buffer = new byte[BUFSIZE];

        for (int i = 0; i < 1000; i++) {

            if (i == 0) {

                try {
                    DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                    socket.receive(packet);

                    System.out.println("Packet received from " + packet.getAddress() + ";" + packet.getPort() + " of length " + packet.getLength());
// tambahan
                    ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
                    BufferedReader br = new BufferedReader(new InputStreamReader(bin));
                    String durungPecah = br.readLine();
                    System.out.println("Message : " + durungPecah);

                    // coba pecah object

                    String[] pecah = durungPecah.split(",");
                    System.out.println("The number of fruits is: " + pecah.length);
                    for (String cetak : pecah) {
                        System.out.println(cetak);

                        nim_e = pecah[0];
                        nama_e = pecah[1];
                        asal_e = pecah[2];
                        kelas_e = pecah[3];

                    }

                    List<Mahasiswa> newList = demo.deserialize("ParticipantData.txt");
                    int nim_eDadiAngka = Integer.parseInt(nim_e);
                    Mahasiswa nL = new Mahasiswa(nim_eDadiAngka, nama_e, asal_e, kelas_e);
                    newList.add(nL);
                    mhs.add(nL);

                    for (int j = 0; j < newList.size(); j++) {
                        int nimDadiAngka = newList.get(j).getNim();
                        String inputNama = newList.get(j).getNama();
                        String inputAsal = newList.get(j).getAsal();
                        String inputKelas = newList.get(j).getKelas();

                        Mahasiswa group = new Mahasiswa(nimDadiAngka, inputNama, inputAsal, inputKelas);
                        mhs.add(group);
//                //System.out.println(newList.get(j));
//
                    }
                    mhs.remove(0);

                    socket.send(packet);
                    demo.serialize(mhs, "ParticipantData.txt");
                } catch (IOException ioe) {
                    System.err.println("Error : " + ioe);
                }

            } else {

                try {
                    DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                    socket.receive(packet);

                    System.out.println("Packet received from " + packet.getAddress() + ";" + packet.getPort() + " of length " + packet.getLength());
// tambahan
                    ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
                    BufferedReader br = new BufferedReader(new InputStreamReader(bin));
                    String durungPecah = br.readLine();
                    System.out.println("Message : " + durungPecah);

                    // coba pecah object

                    String[] pecah = durungPecah.split(",");
                    System.out.println("The number of fruits is: " + pecah.length);
                    for (String cetak : pecah) {
                        System.out.println(cetak);

                        nim_e = pecah[0];
                        nama_e = pecah[1];
                        asal_e = pecah[2];
                        kelas_e = pecah[3];


                    }

                    List<Mahasiswa> newList = demo.deserialize("ParticipantData.txt");
                    int nim_eDadiAngka = Integer.parseInt(nim_e);

                    Mahasiswa nL = new Mahasiswa(nim_eDadiAngka, nama_e, asal_e, kelas_e);
                    newList.add(nL);
                    mhs.add(nL);

                    socket.send(packet);
                    demo.serialize(mhs, "ParticipantData.txt");
                } catch (IOException ioe) {
                    System.err.println("Error : " + ioe);
                }

            }

        }
    }

    public void serviceClientsUpdate() throws IOException, ClassNotFoundException {

        List<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
        SerializationDemo demo = new SerializationDemo();
        //

        byte[] buffer = new byte[BUFSIZE];
        for (int i = 0; i < 1000; i++) {

            if (i == 0) {

                try {
                    DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                    socket.receive(packet);

                    System.out.println("Packet received from " + packet.getAddress() + ";" + packet.getPort() + " of length " + packet.getLength());
// tambahan
                    ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
                    BufferedReader br = new BufferedReader(new InputStreamReader(bin));
                    String durungPecah = br.readLine();
                    System.out.println("Message : " + durungPecah);

                    // coba pecah object

                    String[] pecah = durungPecah.split(",");
                    System.out.println("The number of fruits is: " + pecah.length);
                    for (String cetak : pecah) {
                        System.out.println(cetak);

                        nim_e = pecah[0];
                        nama_e = pecah[1];
                        asal_e = pecah[2];
                        kelas_e = pecah[3];
                        index_e = pecah[4];

                    }



                    List<Mahasiswa> newList = demo.deserialize("ParticipantData.txt");
                    int nim_eDadiAngka = Integer.parseInt(nim_e);
                    int index_eDadiAngka = Integer.parseInt(index_e);


                    newList.set(index_eDadiAngka, new Mahasiswa(nim_eDadiAngka, nama_e, asal_e, kelas_e));

                    for (int j = 0; j < newList.size(); j++) {
                        int nimDadiAngka = newList.get(j).getNim();
                        String inputNama = newList.get(j).getNama();
                        String inputAsal = newList.get(j).getAsal();
                        String inputKelas = newList.get(j).getKelas();

                        Mahasiswa group = new Mahasiswa(nimDadiAngka, inputNama, inputAsal, inputKelas);
                        mhs.add(group);
                    }
                    //mhs.remove(0);

                    socket.send(packet);
                    demo.serialize(mhs, "ParticipantData.txt");
                } catch (IOException ioe) {
                    System.err.println("Error : " + ioe);
                }

            } else {

                try {
                    DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                    socket.receive(packet);

                    System.out.println("Packet received from " + packet.getAddress() + ";" + packet.getPort() + " of length " + packet.getLength());
// tambahan
                    ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
                    BufferedReader br = new BufferedReader(new InputStreamReader(bin));
                    String durungPecah = br.readLine();
                    System.out.println("Message : " + durungPecah);

                    // coba pecah object

                    String[] pecah = durungPecah.split(",");
                    System.out.println("The number of fruits is: " + pecah.length);
                    for (String cetak : pecah) {
                        System.out.println(cetak);

                        nim_e = pecah[0];
                        nama_e = pecah[1];
                        asal_e = pecah[2];
                        kelas_e = pecah[3];
                        index_e = pecah[4];

                    }



                    List<Mahasiswa> newList = demo.deserialize("ParticipantData.txt");
                    int nim_eDadiAngka = Integer.parseInt(nim_e);
                    int index_eDadiAngka = Integer.parseInt(index_e);

                    mhs.set(index_eDadiAngka, new Mahasiswa(nim_eDadiAngka, nama_e, asal_e, kelas_e));


                    socket.send(packet);
                    demo.serialize(mhs, "ParticipantData.txt");
                } catch (IOException ioe) {
                    System.err.println("Error : " + ioe);
                }

            }


        }
    }
    

    public void serviceClientsDelete() throws IOException, ClassNotFoundException {

        List<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
        SerializationDemo demo = new SerializationDemo();

        byte[] buffer = new byte[BUFSIZE];

        for (int i = 0; i < 1000; i++) {

            if (i == 0) {

                try {
                    DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                    socket.receive(packet);

                    System.out.println("Packet received from " + packet.getAddress() + ";" + packet.getPort() + " of length " + packet.getLength());
// tambahan
                    ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
                    BufferedReader br = new BufferedReader(new InputStreamReader(bin));
                    String indexHapus = br.readLine();
                    System.out.println("Message : " + indexHapus);

                    String str = indexHapus.replaceAll("\\D+", "");

                    int indexHapusDadiAngka = Integer.parseInt(str);

                    List<Mahasiswa> newList = demo.deserialize("ParticipantData.txt");

                    newList.remove(indexHapusDadiAngka);
                    //mhs.remove(indexHapus);

                    for (int j = 0; j < newList.size(); j++) {
                        int nimDadiAngka = newList.get(j).getNim();
                        String inputNama = newList.get(j).getNama();
                        String inputAsal = newList.get(j).getAsal();
                        String inputKelas = newList.get(j).getKelas();

                        Mahasiswa group = new Mahasiswa(nimDadiAngka, inputNama, inputAsal, inputKelas);
                        mhs.add(group);
                    }
                    //mhs.remove(0);

                    socket.send(packet);
                    demo.serialize(mhs, "ParticipantData.txt");
                } catch (IOException ioe) {
                    System.err.println("Error : " + ioe);
                }

            } else {

                try {
                    DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                    socket.receive(packet);

                    System.out.println("Packet received from " + packet.getAddress() + ";" + packet.getPort() + " of length " + packet.getLength());
// tambahan
                    ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
                    BufferedReader br = new BufferedReader(new InputStreamReader(bin));
                    String indexHapus = br.readLine();
                    System.out.println("Message : " + indexHapus);

                    String str = indexHapus.replaceAll("\\D+", "");

                    int indexHapusDadiAngka = Integer.parseInt(str);

                    List<Mahasiswa> newList = demo.deserialize("ParticipantData.txt");

                    mhs.remove(indexHapusDadiAngka);

                    socket.send(packet);
                    demo.serialize(mhs, "ParticipantData.txt");
                } catch (IOException ioe) {
                    System.err.println("Error : " + ioe);
                }

            }
            

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EchoServer server = new EchoServer();
        
        
        
        
      
        
        
        
        
        

      
        //server.serviceClientsUpdate();
        
        
//       EchoServer serverUp=new EchoServer();
//        EchoServer serverDelete=new EchoServer();        
//        
//        serverdd.serviceClients();
//      serverUp.serviceClientsUpdate();
//        serverDelete.serviceClientsDelete();
        
//        if(true){
//            server.serviceClients();
//        
//        }else if(true){
//            server.serviceClientsUpdate();
//            
//        
//        }else{
//            server.serviceClientsDelete();
//        
//        
//        }
        
       
        
        
        
    }
}
