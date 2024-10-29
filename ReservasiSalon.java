package tugas2;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservasiSalon{
    private String namaPelanggan;
    private String tanggalReservasi;
    private String layanan;

    public ReservasiSalon(String namaPelanggan, String tanggalReservasi, String layanan) {
        this.namaPelanggan = namaPelanggan;
        this.tanggalReservasi = tanggalReservasi;
        this.layanan = layanan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    @Override
    public String toString() {
        return "Nama: " + namaPelanggan + ", Tanggal: " + tanggalReservasi + ", Layanan: " + layanan;
    }
}



class SalonManager {
    private ArrayList<ReservasiSalon> daftarReservasi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /** menambahkan kelas tambahreservasi untuk menjalankan aplikasi reservasi salon, di dalam kelas ini pelayan dapat
      menambahkan nama pelanggan, masukan tanggal reservasi, dan layanan yang ingin di reservasi*/
    public void tambahReservasi() {
        String nama = input("Masukkan Nama: ");
        String tanggal = input("Masukkan Tanggal (DD/MM/YYYY): ");
        String layanan = input("Masukkan Layanan: ");
        daftarReservasi.add(new ReservasiSalon(nama, tanggal, layanan));
        System.out.println("Reservasi Berhasil Ditambahkan!");
    }

    /** menambahkan kelas lihat reservasi, disini pelayan dapat melihat siapa saja yang sudah melakukan reservasi
     * agar customer ga tabrakan jadwal saat ingin melakukan servis salon kami*/
    public void lihatReservasi() {
        if (daftarReservasi.isEmpty()) {
            System.out.println("Tidak ada reservasi yang tersedia.");
        } else {
            System.out.println("Daftar Reservasi:");
            for (ReservasiSalon reservasi : daftarReservasi) {
                System.out.println(reservasi);
            }
        }
    }

    /** ketika pelanggan telah melakukan servis, atau pelanggan ingin membatalkan reservasi di salon kami,
     * pelayan dapat menghapus reservasi disini
     */
    public void hapusReservasi() {
        String nama = input("Masukkan Nama Pelanggan yang ingin dihapus: ");
        ReservasiSalon reservasi = cariReservasi(nama);
        if (reservasi != null) {
            daftarReservasi.remove(reservasi);
            System.out.println("Reservasi atas nama " + nama + " berhasil dihapus.");
        } else {
            System.out.println("Reservasi tidak ditemukan.");
        }
    }

    /** nah, ini method untuk mencari nama pelanggan untuk di hapus reservasinya atau untuk melihat daftar reservasi*/
    private ReservasiSalon cariReservasi(String nama) {
        for (ReservasiSalon reservasi : daftarReservasi) {
            if (reservasi.getNamaPelanggan().equals(nama)) {
                return reservasi;
            }
        }
        return null;
    }

    /** oke, sekarang waktunya kamu reservasi salon kita:)*/
    private String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}



