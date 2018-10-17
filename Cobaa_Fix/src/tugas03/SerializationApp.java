package tugas03;

import java.util.ArrayList;
import java.util.List;


public class SerializationApp {

    public static void main(String[] args) throws ClassNotFoundException {
        List<Mahasiswa> mhs = new ArrayList<Mahasiswa>();

//        for (int i = 0; i < 3; i++) {
//            String nim = JOptionPane.showInputDialog("NIM");
//            int nimDadiAngka = Integer.parseInt(nim);
//            String inputNama = JOptionPane.showInputDialog("masukkan nama");
//            String inputAsal = JOptionPane.showInputDialog("masukkan Kota Asal");
//            String inputKelas = JOptionPane.showInputDialog("masukkan Kelas Praktikum");
//
//            //String namanya = "group"+i;
//            Mahasiswa group = new Mahasiswa(nimDadiAngka, inputNama, inputAsal, inputKelas);
//
//            mhs.add(group);
//
//        }

        //mhs.remove(0);

        // akses arrayList:
        // ambil element = .get(1);

        // panjang arrayList = .size();

        // edit
        // newList.set(1, new Mahasiswa(1, "gantinama", "gantiAsal", "gantikelas"));

        // hapus
        // newList.remove(0);

        //System.out.println("Participant : " + mhs);

        SerializationDemo demo = new SerializationDemo();
//        demo.serialize(mhs, "ParticipantData.txt");
//        System.out.println("serialization is done");

        System.out.println("\nDeserialize object...");
        List<Mahasiswa> newList = demo.deserialize("participantData.txt");
//newList.remove(0);
        System.out.println("New List: " + newList);

       


    }
}
