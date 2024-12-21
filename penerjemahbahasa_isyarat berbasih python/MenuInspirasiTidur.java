import java.util.Scanner;

class SingleLinkedList {
    // Node class
    private class Node {
        String judulInspirasi;
        String kategori;
        int durasi; // durasi dalam menit
        Node next;

        Node(String judulInspirasi, String kategori, int durasi) {
            this.judulInspirasi = judulInspirasi;
            this.kategori = kategori;
            this.durasi = durasi;
            this.next = null;
        }
    }

    private Node head;

    public SingleLinkedList() {
        head = null;
    }

    // 1. Tambah Inspirasi
    public void tambahInspirasi(String judulInspirasi, String kategori, int durasi) {
        Node newNode = new Node(judulInspirasi, kategori, durasi);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inspirasi berhasil ditambahkan.");
    }

    // 2. Hapus Inspirasi
    public void hapusInspirasi(String judulInspirasi) {
        if (head == null) {
            System.out.println("Daftar kosong, tidak ada inspirasi untuk dihapus.");
            return;
        }

        if (head.judulInspirasi.equalsIgnoreCase(judulInspirasi)) {
            head = head.next;
            System.out.println("Inspirasi \"" + judulInspirasi + "\" berhasil dihapus.");
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.judulInspirasi.equalsIgnoreCase(judulInspirasi)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Inspirasi tidak ditemukan.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Inspirasi \"" + judulInspirasi + "\" berhasil dihapus.");
        }
    }

    // 3. Pencarian Inspirasi
    public void cariInspirasi(String judulInspirasi) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.judulInspirasi.equalsIgnoreCase(judulInspirasi)) {
                System.out.println("Inspirasi ditemukan: \"" + judulInspirasi + "\", Kategori: " + temp.kategori + ", Durasi: " + temp.durasi + " menit, Posisi: " + index);
                return;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("Inspirasi tidak ditemukan.");
    }

    // 4. Pengurutan Inspirasi (berdasarkan durasi)
    public void urutkanInspirasi() {
        if (head == null || head.next == null) {
            System.out.println("Daftar kosong atau hanya satu inspirasi, tidak perlu diurutkan.");
            return;
        }

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.durasi > j.durasi) {
                    // Tukar data
                    String tempJudul = i.judulInspirasi;
                    String tempKategori = i.kategori;
                    int tempDurasi = i.durasi;

                    i.judulInspirasi = j.judulInspirasi;
                    i.kategori = j.kategori;
                    i.durasi = j.durasi;

                    j.judulInspirasi = tempJudul;
                    j.kategori = tempKategori;
                    j.durasi = tempDurasi;
                }
            }
        }
        System.out.println("Daftar berhasil diurutkan berdasarkan durasi.");
    }

    // 5. Tampil daftar
    public void tampilDaftar() {
        if (head == null) {
            System.out.println("Daftar kosong.");
            return;
        }

        Node temp = head;
        System.out.println("Daftar Inspirasi Waktu Tidur:");
        while (temp != null) {
            System.out.println("Judul: \"" + temp.judulInspirasi + "\", Kategori: " + temp.kategori + ", Durasi: " + temp.durasi + " menit");
            temp = temp.next;
        }
    }
}

public class MenuInspirasiTidur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList daftarInspirasi = new SingleLinkedList();
        int pilihan;

        do {
            System.out.println("\nMenu Inspirasi Waktu Tidur:");
            System.out.println("1. Tambah Inspirasi");
            System.out.println("2. Hapus Inspirasi");
            System.out.println("3. Pencarian Inspirasi");
            System.out.println("4. Pengurutan Inspirasi");
            System.out.println("5. Tampil daftar");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul inspirasi: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan kategori: ");
                    String kategori = scanner.nextLine();
                    System.out.print("Masukkan durasi (dalam menit): ");
                    int durasi = scanner.nextInt();
                    daftarInspirasi.tambahInspirasi(judul, kategori, durasi);
                    break;
                case 2:
                    System.out.print("Masukkan judul inspirasi yang ingin dihapus: ");
                    String judulHapus = scanner.nextLine();
                    daftarInspirasi.hapusInspirasi(judulHapus);
                    break;
                case 3:
                    System.out.print("Masukkan judul inspirasi yang ingin dicari: ");
                    String judulCari = scanner.nextLine();
                    daftarInspirasi.cariInspirasi(judulCari);
                    break;
                case 4:
                    daftarInspirasi.urutkanInspirasi();
                    break;
                case 5:
                    daftarInspirasi.tampilDaftar();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
