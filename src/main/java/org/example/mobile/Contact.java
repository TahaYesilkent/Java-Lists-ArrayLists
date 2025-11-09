package org.example.mobile;

import java.util.Objects;

public class Contact {

    private final String name;
    private final String phoneNumber;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        // İki Contact, isimleri ve telefon numaraları aynıysa eşit kabul edilir.
        return Objects.equals(name, contact.name) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    // Constructor metodu
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // getName getter metodu
    public String getName() {
        return name;
    }

    // getPhoneNumber getter metodu
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // createContact metodu (static)
    // Yeni bir Contact nesnesi oluşturur ve döndürür.
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);


    }



}