package org.example.models; // İstenen paket yapısı

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    // 1. public static ArrayList<String> tipinde groceryList tanımlandı
    public static List<String> groceryList = new ArrayList<>();

    // main metodu, uygulamayı başlatmak için bir giriş noktası sağlar
    public static void main(String[] args) {
        Grocery app = new Grocery();
        app.startGrocery();
    }

    // Konsol uygulamasını başlatan metot
    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int choice;

        System.out.println("--- Bakkal Uygulamasına Hoş Geldiniz ---");

        while (!quit) {
            System.out.println("\nSeçiminizi yapın:");
            System.out.println("0 - Çıkış");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün çıkar"); // İstenen seçenek 2 olmalıydı, liste görme değil
            System.out.print("Seçiminiz (0, 1, 2): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Tamponu temizle

                switch (choice) {
                    case 0:
                        System.out.println("Uygulamadan çıkılıyor...");
                        quit = true;
                        break;
                    case 1:
                        System.out.print("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırarak): ");
                        String addInput = scanner.nextLine();
                        addItems(addInput);
                        break;
                    case 2:
                        System.out.print("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırarak): ");
                        String removeInput = scanner.nextLine();
                        removeItems(removeInput);
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 girin.");
                        break;
                }
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                scanner.nextLine(); // Hatalı girişi temizle
            }
        }
        scanner.close();
    }

    // 4. statik metot: addItems(String input)
    public static void addItems(String input) {
        // Girdiyi virgüllerle ayır, boşlukları temizle ve küçük harfe çevir
        String[] items = input.split(",");
        boolean added = false;

        for (String item : items) {
            String product = item.trim().toLowerCase();

            // Eğer ürün boş değilse ve listede yoksa ekle
            if (!product.isEmpty() && !checkItemIsInList(product)) {
                groceryList.add(product);
                added = true;
            }
        }

        if (added) {
            System.out.println("Ürün(ler) başarıyla eklendi.");
            printSorted(); // Operasyon sonrası listeyi sırala ve yazdır
        } else {
            System.out.println("Yeni ürün eklenmedi (Hepsi zaten listede olabilir).");
            printSorted();
        }
    }

    // 4. statik metot: removeItems(String input)
    public static void removeItems(String input) {
        String[] items = input.split(",");
        boolean removed = false;

        for (String item : items) {
            String product = item.trim().toLowerCase();

            // Ürün listede varsa kaldır
            if (groceryList.remove(product)) {
                removed = true;
            }
        }

        if (removed) {
            System.out.println("Ürün(ler) başarıyla kaldırıldı.");
            printSorted(); // Operasyon sonrası listeyi sırala ve yazdır
        } else {
            System.out.println("Listeden hiçbir ürün kaldırılamadı (Ürün(ler) listede mevcut olmayabilir).");
            printSorted();
        }
    }

    // 4. statik metot: checkItemIsInList(String product)
    // Listede eleman olup olmadığını kontrol eder. Tekrarlanan veri olmamasını sağlar.
    public static boolean checkItemIsInList(String product) {
        // List.contains metodu en verimli yöntemdir
        return groceryList.contains(product);
    }

    // 4. statik metot: printSorted()
    // Listeyi sıralar ve ekrana basar.
    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("Pazar listesi boştur.");
            return;
        }

        // Collections sınıfını kullanarak listeyi alfabetik olarak sırala
        Collections.sort(groceryList);

        System.out.println("--- Güncel Pazar Listesi (" + groceryList.size() + " ürün) ---");

        // Elemanları numaralandırarak alt alta yazdır
        for (int i = 0; i < groceryList.size(); i++) {
            // İlk harfi büyük, geri kalanı küçük formatında gösterim (opsiyonel)
            String item = groceryList.get(i);
            String formattedItem = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println((i + 1) + ". " + formattedItem);
        }
        System.out.println("----------------------------------------");
    }
}