package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Seçiminizi yapın (0 - Çıkış, 1 - Ekle, 2 - Sil): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Çıkılıyor...");
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz. (virgül ile ayırabilirsiniz): ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz. (virgül ile ayırabilirsiniz): ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            groceryList.remove(trimmedItem);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);

    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

}
