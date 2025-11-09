package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private final String myNumber;
    private final List<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // myNumber için getter
    public String getMyNumber() {
        return myNumber;
    }
    // 2. YENİ Constructor (İki argümanlı - Test gereksinimi)
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = contacts; // Başlangıç listesi atanıyor
    }

    // myContacts için getter (Güvenli olması için List döndürülebilir)
    public List<Contact> getMyContacts() {
        // Orijinal listeye dışarıdan müdahaleyi engellemek için yeni bir ArrayList döndürmek güvenlidir.
        // Ancak gereksinimde sadece getter istendiği için doğrudan listeyi döndürelim:
        return myContacts;
    }

    // 1. Metot: addNewContact
    public boolean addNewContact(Contact contact) {
        // İletişim zaten listede var mı kontrolü yapılır
        if (findContact(contact) >= 0) {
            System.out.println("Hata: " + contact.getName() + " zaten rehberde kayıtlı.");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    // 2. Metot: updateContact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);

        if (position < 0) {
            System.out.println("Hata: " + oldContact.getName() + " rehberde bulunamadı.");
            return false;
        }

        // Yeni kişi zaten listede var mı kontrolü (adı farklı, numarası aynı olabilir vb.)
        // Basitlik için sadece eski pozisyondaki veriyi güncelleyelim.

        this.myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " başarıyla " + newContact.getName() + " olarak güncellendi.");
        return true;
    }

    // 3. Metot: removeContact
    public boolean removeContact(Contact contact) {
        int position = findContact(contact);

        if (position < 0) {
            System.out.println("Hata: " + contact.getName() + " rehberde bulunamadı.");
            return false;
        }

        this.myContacts.remove(position);
        System.out.println(contact.getName() + " başarıyla silindi.");
        return true;
    }

    // 4. Metot: findContact (Contact parametresi ile)
    public int findContact(Contact contact) {
        // Contact objesi yerine sadece ismini kullanarak aramak daha temizdir:
        return findContact(contact.getName());
    }

    // 5. Metot: findContact (String parametresi ile)
    public int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                return i; // Bulundu, indeksi dön
            }
        }
        return -1; // Bulunamadı
    }

    // 6. Metot: queryContact
    public Contact queryContact(String name) {
        int position = findContact(name);

        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null; // Yoksa null dön
    }

    // 7. Metot: printContact
    public void printContact() {
        System.out.println("\nContact List:");
        if (myContacts.isEmpty()) {
            System.out.println("Rehber boş.");
            return;
        }

        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}