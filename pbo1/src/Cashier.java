import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayItems() {
        double total = 0.0;
        System.out.println("Daftar Item yang dibeli:");
        System.out.println("Kode\tNama\tHarga\tJumlah\tSubtotal");
        for (Item item : items) {
            double subTotal = item.getPrice() * item.getQuantity();
            System.out.println(item.getCode() + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getQuantity() + "\t" + subTotal);
            total += subTotal;
        }
        System.out.println("Total belanja: " + total);
    }

    public void processPayment() {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total belanja: " + total);
        System.out.print("Masukkan jumlah pembayaran: ");
        double payment = scanner.nextDouble();
        if (payment >= total) {
            double change = payment - total;
            System.out.println("Pembayaran diterima. Kembalian: " + change);
        } else {
            System.out.println("Jumlah pembayaran kurang.");
        }
    }
}
