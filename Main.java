package tugas2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SalonManager manager = new SalonManager();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Lihat Reservasi");
            System.out.println("3. Hapus Reservasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Menangkap enter

            switch (pilihan) {
                case 1:
                    manager.tambahReservasi();
                    break;
                case 2:
                    manager.lihatReservasi();
                    break;
                case 3:
                    manager.hapusReservasi();
                    break;
                case 4:
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
