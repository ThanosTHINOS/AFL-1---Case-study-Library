import java.util.*;

public class AFL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek autentikasi dengan file teks sebagai sumber informasi login
        Authentication authentication = new Authentication("credentials.txt");

        // Meminta pengguna untuk login
        System.out.println("Masukkan username:");
        String username = scanner.nextLine();
        System.out.println("Masukkan password:");
        String password = scanner.nextLine();

        // Memeriksa autentikasi pengguna
        if (authentication.authenticate(username, password)) {
            String role = authentication.getRole(username);
            if (role != null) {
                if (role.equalsIgnoreCase("mahasiswa")) {
                    // Melanjutkan dengan operasi Mahasiswa
                    Mahasiswa mahasiswa = new Mahasiswa();
                    System.out.println("Masukkan nama Mahasiswa:");
                    mahasiswa.setNama(scanner.nextLine());
                    System.out.println("Masukkan NIM Mahasiswa:");
                    mahasiswa.setNpm(scanner.nextLine());
                    
                    // Memilih jenis barang yang ingin dipinjam (buku/cd)
                    System.out.println("Apakah ingin meminjam CD atau buku? (cd/buku):");
                    String jenisBarang = scanner.nextLine();
                    if (jenisBarang.equalsIgnoreCase("buku")) {
                        System.out.println("Masukkan judul buku yang ingin dipinjam:");
                        String judulBuku = scanner.nextLine();
                        System.out.println("Buku " + judulBuku + " telah berhasil dipinjam oleh " + mahasiswa.getNama());
                    } else if (jenisBarang.equalsIgnoreCase("cd")) {
                        System.out.println("Masukkan judul CD yang ingin dipinjam:");
                        String judulCD = scanner.nextLine();
                        System.out.println("CD " + judulCD + " telah berhasil dipinjam oleh " + mahasiswa.getNama());
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    
                } else if (role.equalsIgnoreCase("dosen")) {
                    // Melanjutkan dengan operasi Dosen
                    Dosen dosen = new Dosen();
                    System.out.println("Masukkan nama Dosen:");
                    dosen.setNama(scanner.nextLine());
                    System.out.println("Masukkan NIK Dosen:");
                    dosen.setNip(scanner.nextLine());
                    
                    // Memilih tindakan yang ingin dilakukan oleh dosen
                    System.out.println("Apakah ingin melakukan tindakan tertentu? (ya/tidak):");
                    String inginTindakan = scanner.nextLine();
                    if (inginTindakan.equalsIgnoreCase("ya")) {
                        System.out.println("Masukkan tindakan yang ingin dilakukan oleh dosen " + dosen.getNama() + ":");
                        String tindakan = scanner.nextLine();
                        System.out.println("Dosen " + dosen.getNama() + " telah melakukan tindakan: " + tindakan);
                    } else if (inginTindakan.equalsIgnoreCase("tidak")) {
                        System.out.println("Terima kasih, tidak ada tindakan yang dilakukan.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    
                } else {
                    System.out.println("Peran tidak valid.");
                }
            } else {
                System.out.println("Peran tidak ditemukan.");
            }
        } else {
            System.out.println("Gagal login. Username atau password salah.");
        }
    }
}
