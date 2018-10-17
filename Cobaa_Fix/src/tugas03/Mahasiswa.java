package tugas03;

import java.io.Serializable;


public class Mahasiswa implements Serializable {

    private final String NAMA;
    private final String ASAL;
    private final String KELAS;
    private int NIM;

    public Mahasiswa(int nim, String nama, String asal, String kelas) {
        this.NIM = nim;
        this.NAMA = nama;
        this.ASAL = asal;
        this.KELAS = kelas;

    }

    public String getNama() {
        return NAMA;
    }

    public String getAsal() {
        return ASAL;
    }

    public String getKelas() {
        return KELAS;
    }

    public int getNim() {
        return NIM;
    }

    public void setNim(int nim) {
        this.NIM = nim;
    }

    @Override
    public String toString() {
        return NIM + "," + NAMA + "," + ASAL + "," + KELAS+",";
    }
}
