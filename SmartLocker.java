package JAVA.CHALLENGE;
import java.util.Scanner;

public class SmartLocker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] locker = new int[10][3]; 
        // Dimensi 1 = jumlah locker (index[0] = locker 1, dst)
        // Dimensi 2 = atribut locker (index[0] = status (penuh/kosong), index[1] = password, index[2] = isi locker)
        int menu; // Homepage
        int noLock1; // Opsi 1
        int noLock2, passTwo; // Opsi 2 (passTwo digunakan untuk mencocokkan input pw opsi 2 dengan input pw opsi 1)
        String status; // Opsi 3
        int noLock4; // Opsi 4

        while(true) {
        // UI Homepage (start)
            System.out.println(" ");
            System.out.println("======== Smart Locker ========");
            System.out.println("Selamat datang! Silahkan pilih operasi di bawah...");
            System.out.println("[1] Memasukkan barang ke locker. \n[2] Ambil barang dari locker \n[3] Lihat status seluruh locker \n[4] <admin> cek password locker");
            System.out.print("Pilihan anda: ");
            menu = input.nextInt();
            System.out.println(" ");
        // UI Homepage (end)

        // Pilihan menu (start)
            switch(menu) {
            case 1 : // Memasukkan barang ke locker
                System.out.print("Masukkan nomor locker yang kosong (1-10): ");
                noLock1 = input.nextInt();
                for (int m = (noLock1-1); m < noLock1; m++) { // 
                    if(locker[m][0] == 0) {
                        System.out.print("Masukkan password locker: ");
                        locker[m][1] = input.nextInt();
                        System.out.print("Masukkan isi locker: ");
                        locker[m][2] = input.nextInt();
                        System.out.println("Isi locker: " + locker[m][2] + ". Locer terisi!");
                        locker[m][0] = 1;
                    } else { // Untuk mencegah system meminta input password dan isi locker apabila locker sudah terisi.
                        System.out.println("Locker penuh!");
                    }
                }
                break;
            case 2 : // Mengambil barang
                System.out.print("Masukkan nomor locker (1-10): ");
                noLock2 = input.nextInt();
                for (int k = noLock2-1; k < noLock2; k++) {
                    if(locker[k][2] == 0) {
                        System.out.println("Locker kosong!");
                    } else {
                        System.out.print("Masukkan password locker: ");
                        passTwo = input.nextInt();
                        if (passTwo == locker[k][1]) { // Barang hanya dapat diambil jika password sesuai dengan input opsi 1.
                            System.out.println("Isi locker = " + locker[k][2] + ". Silahkan mengambil!");
                            locker[k][0] = locker[k][1] = locker[k][2] = 0;
                        } else {
                            System.out.println("Password salah! Silahkan coba lagi.");
                        }
                    }
                }
                break;
            case 3 : // Cek status locker
                for (int i = 0; i < locker.length; i++) {
                    status = (locker[i][0] == 1) ? "Terisi" : "Kosong"; 
                    // Syntax conditional if else. 
                    // Jika atribut[0] = 1, maka locker penuh. Selain itu, jika atribut[0] = 0, maka locker kosong.
                    System.out.println("Locker " + (i + 1) + ": " + status);
                }
                break;
            case 4 : // Cek password locker
                System.out.print("Masukkan nomor locker (1-10): ");
                noLock4 = input.nextInt();
                for (int j = noLock4-1; j < noLock4; j++) {
                    if (locker[j][1] == 0) {
                        System.out.println("Locker ini kosong. Silahkan diisi!");
                    } else {
                        System.out.print("Password locker " + (j+1) + ": " + locker[j][1] + "\n"); // atribut[1] digunakan untuk menyimpan password.
                    }
                }
                break;
            default : // Jika input melebihi 4
                System.out.print("Input salah! Mohon coba lagi.");
                break;
            }
        }
        // Pilihan menu (end)
    }
}