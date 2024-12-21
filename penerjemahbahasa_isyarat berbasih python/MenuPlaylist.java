import java.util.Scanner;

class SingleLinkedList {
    // Node class
    private class Node {
        String judulLagu;
        String artis;
        int durasi; // durasi dalam detik
        Node next;

        Node(String judulLagu, String artis, int durasi) {
            this.judulLagu = judulLagu;
            this.artis = artis;
            this.durasi = durasi;
            this.next = null;
        }
    }

    private Node head;

    public SingleLinkedList() {
        head = null;
    }

    // 1. Tambah lagu
    public void tambahLagu(String judulLagu, String artis, int durasi) {
        Node newNode = new Node(judulLagu, artis, durasi);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Lagu berhasil ditambahkan.");
    }

    // 2. Hapus lagu
    public void hapusLagu(String judulLagu) {
        if (head == null) {
            System.out.println("Playlist kosong, tidak ada lagu untuk dihapus.");
            return;
        }

        if (head.judulLagu.equalsIgnoreCase(judulLagu)) {
            head = head.next;
            System.out.println("Lagu \"" + judulLagu + "\" berhasil dihapus.");
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.judulLagu.equalsIgnoreCase(judulLagu)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Lagu tidak ditemukan.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Lagu \"" + judulLagu + "\" berhasil dihapus.");
        }
    }

    // 3. Pencarian lagu
    public void cariLagu(String judulLagu) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.judulLagu.equalsIgnoreCase(judulLagu)) {
                System.out.println("Lagu ditemukan: \"" + judulLagu + "\", Artis: " + temp.artis + ", Durasi: " + temp.durasi + " detik, Posisi: " + index);
                return;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("Lagu tidak ditemukan.");
    }

    // 4. Pengurutan lagu (berdasarkan durasi)
    public void urutkanLagu() {
        if (head == null || head.next == null) {
            System.out.println("Playlist kosong atau hanya satu lagu, tidak perlu diurutkan.");
            return;
        }

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.durasi > j.durasi) {
                    // Tukar data
                    String tempJudul = i.judulLagu;
                    String tempArtis = i.artis;
                    int tempDurasi = i.durasi;

                    i.judulLagu = j.judulLagu;
                    i.artis = j.artis;
                    i.durasi = j.durasi;

                    j.judulLagu = tempJudul;
                    j.artis = tempArtis;
                    j.durasi = tempDurasi;
                }
            }
        }
        System.out.println("Playlist berhasil diurutkan berdasarkan durasi.");
    }

    // 5. Tampil playlist
    public void tampilPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Node temp = head;
        System.out.println("Playlist:");
        while (temp != null) {
            System.out.println("Judul: \"" + temp.judulLagu + "\", Artis: " + temp.artis + ", Durasi: " + temp.durasi + " detik");
            temp = temp.next;
        }
    }
}

public class MenuPlaylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList playlist = new SingleLinkedList();
        int pilihan;

        do {
            System.out.println("\nMenu Playlist:");
            System.out.println("1. Tambah lagu");
            System.out.println("2. Hapus lagu");
            System.out.println("3. Pencarian lagu");
            System.out.println("4. Pengurutan lagu");
            System.out.println("5. Tampil playlist");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama artis: ");
                    String artis = scanner.nextLine();
                    System.out.print("Masukkan durasi lagu (dalam detik): ");
                    int durasi = scanner.nextInt();
                    playlist.tambahLagu(judul, artis, durasi);
                    break;
                case 2:
                    System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                    String judulHapus = scanner.nextLine();
                    playlist.hapusLagu(judulHapus);
                    break;
                case 3:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    String judulCari = scanner.nextLine();
                    playlist.cariLagu(judulCari);
                    break;
                case 4:
                    playlist.urutkanLagu();
                    break;
                case 5:
                    playlist.tampilPlaylist();
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
