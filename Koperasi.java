import java.util.Scanner;

public class Koperasi {
    static int indexAmbilData;
    static int[][] isi = new int[5][5];

    public static void main(String[] args) {

        // Definisi Variabel
        Scanner input = new Scanner(System.in); 
        Scanner input2 = new Scanner(System.in);
        String[][] data = new String[3][5];
        String pilihan, pilihanLanjut = "", kode_anggota = "KA", pilihanMenu = "";
        
        /*
        * Pilihan Untuk menentukan pilihan Register atau Login
        * PilihanLanjut untuk menentukan Berhentinya PRogram atau Lanjut
         */
        int index = 2,
                indexLanjut = 1,
                no_anggota = 2;

        /*
        * index digunakan untuk batas perulangan untuk memasukkan data
        * indexLanjut digunakan untuk mengisikan variabel awal untuk memasukkan data
        * sedangkan untuk indexAmbilData digunakan untuk mengambil data ketika kita login
         */
        String userAnggota, nama = "", password;
        //End Definisi Variabel

        System.out.println("==================================");
        System.out.println("==== KOPERASI SIMPAN PINJAM ====");
        System.out.println("");

        do {
            String pilihanTrans;
            pilihanLanjut = "";
            System.out.println("1. Register Sebagai Anggota Koperasi");
            System.out.println("2. Login Sebagai Anggota Koperasi");
            System.out.print("Masukkan Pilihan Anda : ");
            pilihan = input.nextLine();
            System.out.println("");

            if (pilihan.equals("1")) {
                for (int i = indexLanjut; i < index; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j == 0) {
                            data[i][j] = kode_anggota + no_anggota;
                        } else if (j == 1) {
                            System.out.print("Masukkan Nama Anda : ");
                            data[i][j] = input.nextLine();
                        } else if (j == 2) {
                            System.out.print("Masukkan Alamat Anda : ");
                            data[i][j] = input.nextLine();
                        } else if (j == 3) {
                            System.out.print("Email : ");
                            data[i][j] = input.nextLine();
                        } else if (j == 4) {
                            System.out.print("Masukkan Password Anda : ");
                            data[i][j] = input.nextLine();
                        }
                    }
                }

                for (int i = indexLanjut; i < index; i++) {
                    System.out.print("\nLogin Berhasil");
                    System.out.println(" Data Anda : ");
                    System.out.print("{ ");
                    for (int j = 0; j < 4; j++) {
                        System.out.print(data[i][j] + ", ");
                    }
                    System.out.print(" }");
                }

                System.out.println();
                index++;
                indexLanjut++;
                no_anggota++;
                System.out.print("Apakah Anda Ingin Lanjut ? [y/n] ");
                pilihanLanjut = input.nextLine();
                System.out.println("");

            } else if (pilihan.equals("2")) {
                System.out.print("Masukkan No Anggota anda : ");
                userAnggota = input.nextLine();
                System.out.println("Masukkan Password : ");
                password = input.nextLine();

                if (userAnggota.equals(data[0][0]) && password.equals(data[0][3])
                        || userAnggota.equals(data[1][0]) && password.equals(data[1][3])
                        || userAnggota.equals(data[2][0]) && password.equals(data[2][3])) {
                    if (userAnggota.equals(data[0][0])) {
                        indexAmbilData = 0;
                        nama = data[0][1];
                    } else if (userAnggota.equals(data[1][0])) {
                        indexAmbilData = 1;
                        nama = data[1][1];
                    } else if (userAnggota.equals(data[2][0])) {
                        indexAmbilData = 2;
                        nama = data[2][1];
                    }

                    System.out.println("\nAnda Login Sebagai " + nama);
                    do {
                        System.out.println("===== Pilihan Transaksi=====");
                        System.out.println("1. Simpan Ke Koperasi");
                        System.out.println("2. Pinjam Dari Koperasi");
                        System.out.println("3. Bayar Hutang");
                        System.out.println("4. Ambil Uang");
                        System.out.println("5. Info");
                        System.out.println("6. Keluar");
                        System.out.println("=============================");
                        System.out.print("\nMasukkan Pilihan Anda : ");
                        pilihanTrans = input.nextLine();

                        //Pemilihan Transaksi
                        if (pilihanTrans.equals("1")) {
                            System.out.println("Anda Menyimpan ke Koperasi");
                            simpan();
                        } else if (pilihanTrans.equals("2")) {
                            System.out.println("Pinjam Dari Koperasi");
                            pinjam();
                        } else if (pilihanTrans.equals("3")) {
                            System.out.println("Bayar Hutang");
                            bayar();
                        } else if (pilihanTrans.equals("4")) {
                            System.out.println("Ambil Uang");
                            ambil();
                        } else if (pilihanTrans.equals("5")) {
                            System.out.println("Info");
                            info();
                        } else if (pilihanTrans.equals("6")) {
                            System.out.println("Exit");
                            pilihanMenu = "n";
                        } else if (pilihanTrans.equals("7")) {
                            System.out.println("Nama kelompok");
                            nama();
                        }else {
                            System.out.println("Menu yang anda pilih tidak tersedia");
                        }
                        System.out.print("\nApakah Anda Ingin melakukan Transaksi lagi ? [y/n] ");
                        pilihanMenu = input2.nextLine();
                    } while (pilihanMenu.equals("y"));
                    System.out.print("Apakah Anda Ingin Kembali ke Halaman Awal ? [y/n] ");
                    pilihanLanjut = input2.nextLine();
                    System.out.println("");

                } else {
                    System.out.println("Password Atau Username Anda Salah");
                    System.out.print("Apakah Anda Ingin Lanjut ? [y/n] ");
                    pilihanLanjut = input.nextLine();
                }

            } else {
                System.out.println("Menu yang anda pilih tidak tersedia");
                pilihanLanjut = "y";
            }
        } while (pilihanLanjut.equals("y"));

    }

    private static void simpan() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Jumlah Uang : ");
        isi[0][indexAmbilData] = input.nextInt();
        System.out.println("\nsaldo anda saat ini : ");
        System.out.println("=====" + isi[0][indexAmbilData]+"=====");

    }

    private static void pinjam() {
        Scanner input = new Scanner(System.in);
        String ulang = "y";
        if (isi[1][indexAmbilData] > 1000000) {
            System.out.println("Anda tidak bisa meminjam karena hutang melebihi 1 Juta");
            System.out.println(isi[1][indexAmbilData]);
        } else {
            System.out.println("Masukkan jumlah uang yang ingin di pinjam : ");
            int pinjam = input.nextInt();
            if (pinjam <= 10000000) {
                isi[1][indexAmbilData] += pinjam;
                do {
                    ulang = "y";
                    System.out.println("\nPilih cicilan pembayaran hutang");
                    System.out.println("1. 3 Bulan");
                    System.out.println("2. 6 Bulan");
                    System.out.println("3. 12 Bulan");
                    System.out.println("4. 20 Bulan");
                    System.out.print("Pilih nomor? :");
                    String pilih = input.next();
                    System.out.println("");
                    if (pilih.equals("1")) {
                        isi[2][indexAmbilData] = isi[1][indexAmbilData] / 3;
                    } else if (pilih.equals("2")) {
                        isi[2][indexAmbilData] = isi[1][indexAmbilData] / 6;
                    } else if (pilih.equals("3")) {
                        isi[2][indexAmbilData] = isi[1][indexAmbilData] / 12;
                    } else if (pilih.equals("4")) {
                        isi[2][indexAmbilData] = isi[1][indexAmbilData] / 20;
                    } else {
                        System.out.println("Pilihan tidak tersedia");
                        ulang = "n";
                    }
                } while (ulang.equals("n"));
                System.out.println("Pinjaman Anda telah Disetujui");
                System.out.println("Jumlah yang harus anda bayarkan setiap bulan: Rp." + isi[2][indexAmbilData]);
            } else {
                System.out.println("Pinjaman Anda tidak Disetuji karena melebihi batas Peminjaman ");
            }

        }

    }

    private static void ambil() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah uang yang ingin di ambil : ");
        int ambil = input.nextInt();
        if (ambil <= isi[0][indexAmbilData]) {
            isi[0][indexAmbilData] -= ambil;
            System.out.println("saldo anda saat ini adalah: " + isi[0][indexAmbilData]);
        } else {
            System.out.println("Nilai saldo tidak cukup");
        }

    }

    private static void bayar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Jumlah uang cicilan");
        int cicil = input.nextInt();
        if (cicil == isi[2][indexAmbilData]) {
            isi[1][indexAmbilData] -= cicil;
            System.out.println("Sisa hutang anda adalah : Rp." + isi[1][indexAmbilData]);
        } else {
            System.out.println("Jumlah yang anda masukkan tidak sesuai cicilan");
        }
    }

    private static void info() {
        Scanner input = new Scanner(System.in);
        String ulang = "y";
        do {
            ulang = "y";
            System.out.println("Pilih Menu:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Cek Hutang");
            String info = input.nextLine();
            if (info.equals("1")) {
                System.out.println("Saldo anda berjumlah : Rp." + isi[0][indexAmbilData]);
            } else if (info.equals("2")) {
                System.out.println("Hutang anda berjumlah : Rp." + isi[1][indexAmbilData]);
            } else {
                System.out.println("Pilihan tidak tersedia");
                ulang = "n";
            }
        } while (ulang.equals("n"));

    }

    private static void nama() {
        System.out.println("  ");

    }

}