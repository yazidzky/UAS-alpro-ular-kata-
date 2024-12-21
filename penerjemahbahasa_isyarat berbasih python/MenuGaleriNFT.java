import java.util.Scanner;

class NFT {
    String nama;
    String creator;
    double harga;
    NFT next;

    public NFT(String nama, String creator, double harga) {
        this.nama = nama;
        this.creator = creator;
        this.harga = harga;
        this.next = null;
    }
}

class GaleriNFT {
    private NFT head;

    public GaleriNFT() {
        head = null;
    }

    // Menambahkan NFT ke dalam galeri
    public void tambahNFT(String nama, String creator, double harga) {
        NFT nftBaru = new NFT(nama, creator, harga);
        if (head == null) {
            head = nftBaru;
        } else {
            NFT temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nftBaru;
        }
        System.out.println("NFT \"" + nama + "\" berhasil ditambahkan ke galeri.");
    }

    public void hapusNFT(String nama) {
        if (head == null) {
            System.out.println("Galeri kosong. Tidak ada NFT untuk dihapus.");
            return;
        }

        if (head.nama.equalsIgnoreCase(nama)) {
            head = head.next;
            System.out.println("NFT \"" + nama + "\" berhasil dihapus.");
            return;
        }

        NFT temp = head;
        while (temp.next != null && !temp.next.nama.equalsIgnoreCase(nama)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("NFT \"" + nama + "\" tidak ditemukan.");
        } else {
            temp.next = temp.next.next;
            System.out.println("NFT \"" + nama + "\" berhasil dihapus.");
        }
    }
    public void cariNFT(String nama) {
        NFT temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.nama.equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + temp.nama + " | Creator: " + temp.creator + " | Harga: Rp " + temp.harga + " | Posisi: " + index);
                return;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("NFT \"" + nama + "\" tidak ditemukan.");
    }

    public void urutkanNFT() {
        if (head == null || head.next == null) {
            System.out.println("Galeri kosong atau hanya memiliki satu NFT, tidak perlu pengurutan.");
            return;
        }

        NFT temp1 = head;
        while (temp1 != null) {
            NFT temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.harga > temp2.harga) {
                    String tempNama = temp1.nama;
                    String tempCreator = temp1.creator;
                    double tempHarga = temp1.harga;

                    temp1.nama = temp2.nama;
                    temp1.creator = temp2.creator;
                    temp1.harga = temp2.harga;

                    temp2.nama = tempNama;
                    temp2.creator = tempCreator;
                    temp2.harga = tempHarga;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println("Galeri berhasil diurutkan berdasarkan harga.");
    }

    public void tampilGaleri() {
        if (head == null) {
            System.out.println("Galeri kosong.");
            return;
        }

        NFT temp = head;
        System.out.println("Daftar NFT di Galeri:");
        while (temp != null) {
            System.out.println("Nama: \"" + temp.nama + "\", Creator: " + temp.creator + ", Harga: Rp " + temp.harga);
            temp = temp.next;
        }
    }
}

public class MenuGaleriNFT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GaleriNFT galeri = new GaleriNFT();
        int pilihan;

        do {
            tampilMenu();
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama NFT: ");
                    String namaNFT = input.nextLine();
                    System.out.print("Masukkan nama creator: ");
                    String creatorNFT = input.nextLine();
                    System.out.print("Masukkan harga NFT: ");
                    double hargaNFT = input.nextDouble();
                    galeri.tambahNFT(namaNFT, creatorNFT, hargaNFT);
                    break;
                case 2:
                    System.out.print("Masukkan nama NFT yang ingin dihapus: ");
                    String hapusNFT = input.nextLine();
                    galeri.hapusNFT(hapusNFT);
                    break;
                case 3:
                    System.out.print("Masukkan nama NFT yang ingin dicari: ");
                    String cariNFT = input.nextLine();
                    galeri.cariNFT(cariNFT);
                    break;
                case 4:
                    galeri.urutkanNFT();
                    break;
                case 5:
                    galeri.tampilGaleri();
                    break;
                case 6:
                    System.out.println("Terima kasih, keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 6);

        input.close();
    }

    private static void tampilMenu() {
        System.out.println("\n--- Menu Galeri NFT ---");
        System.out.println("1. Tambah NFT");
        System.out.println("2. Hapus NFT");
        System.out.println("3. Cari NFT");
        System.out.println("4. Urutkan NFT berdasarkan harga");
        System.out.println("5. Tampilkan Galeri NFT");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu (1-6): ");
    }
}
