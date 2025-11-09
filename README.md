# Proje Adı: Java OOP Uygulamaları (Rehber ve Pazar Listesi)

Bu depo, Java'da Nesne Yönelimli Programlama (OOP) temel kavramlarını derinlemesine uygulamak amacıyla geliştirilmiştir. Proje, iki ana modül içerir:

1.  **Mobile Phone Uygulaması:** İletişim kişilerini (`Contact`) yönetmek için kullanılan bir sınıf (`MobilePhone`). Arayüz mantığı olmaksızın, tamamen Kalıtım ve Temel Sınıf Tasarımı üzerine odaklanır.
2.  **Pazar Listesi (Grocery List) Uygulaması:** Statik metotlar ve Koleksiyonlar (`ArrayList`) kullanarak bir alışveriş listesini yönetir. Tekrar eden elemanları engeller ve listeyi otomatik olarak sıralar.

---

## Ön Koşullar

* Java Development Kit (JDK) 11 veya üzeri
* JUnit 5 (Testler için)

---

## Modül 1: Mobile Phone Uygulaması (org.example.mobile)

Bu modül, bir cep telefonundaki rehber yönetimini simüle eder.

### Sınıf Yapısı ve Temel Fonksiyonlar

| Sınıf | Alanlar (Fields) | Temel Metotlar | Açıklama |
| :--- | :--- | :--- | :--- |
| `Contact` | `name`, `phoneNumber` | `getName()`, `getPhoneNumber()`, `createContact()` (static), `equals()`, `hashCode()` | Kişi bilgilerini tutar. `equals()` metodu, nesnelerin içerik bazlı karşılaştırılabilmesi için override edilmiştir. |
| `MobilePhone` | `myNumber`, `myContacts` (ArrayList) | `addNewContact()`, `updateContact()`, `removeContact()`, `findContact()` (String/Contact), `queryContact()`, `printContact()` | Rehberi yönetir. Tüm ekleme, silme ve güncelleme işlemleri `myContacts` listesi üzerinde gerçekleştirilir. |

### Önemli Özellikler

* **Tekrarsız Ekleme:** `addNewContact` metodu, aynı isme sahip kişilerin rehbere tekrar eklenmesini engeller.
* **İki Farklı Constructor:** Test senaryolarına uygun olarak, sadece numara alan ve hem numara hem de başlangıç kontakt listesi alan iki farklı constructor mevcuttur.
* **İçerik Eşitliği:** `Contact` sınıfındaki `equals()` metodunun override edilmesi sayesinde, iki `Contact` nesnesi sadece isim ve numara alanları aynı ise eşit kabul edilir (UnitTest gerekliliği).

---

## Modül 2: Pazar Listesi (org.example.models)

Bu modül, kullanıcıdan virgülle ayrılmış girdileri kabul eden ve tekrar etmeyen, sürekli sıralı tutulan bir alışveriş listesini yönetir.

### Sınıf Yapısı ve Temel Fonksiyonlar

| Sınıf | Alanlar (Fields) | Metotlar | Açıklama |
| :--- | :--- | :--- | :--- |
| `Grocery` | `groceryList` (public static ArrayList<String>) | `startGrocery()`, `addItems()`, `removeItems()`, `checkItemIsInList()`, `printSorted()` | Uygulamanın ana mantığını ve statik olarak yönetilen pazar listesini içerir. |

### Önemli Özellikler

* **Çoklu Girdi İşleme:** `addItems` ve `removeItems` metotları, kullanıcıdan gelen virgülle ayrılmış (`tomato, orange`) string girdilerini işler.
* **Tekrar Kontrolü:** `addItems` metodu, `checkItemIsInList` metodunu kullanarak listede zaten mevcut olan elemanların tekrar eklenmesini engeller.
* **Otomatik Sıralama:** Her başarılı ekleme ve çıkarma işleminden sonra `printSorted()` metodu çağrılır ve `Collections.sort()` kullanılarak liste güncel ve alfabetik sırada tutulur.

---

## Testler (JUnit 5)

Projenin doğruluğu, `MainTest.java` sınıfında bulunan kapsamlı JUnit 5 testleri ile sağlanmaktadır. Testler şunları doğrular:

* **`Grocery` İşlevselliği:** Ekleme, çıkarma ve sıralama işlemlerinin doğru çalışması, duplike elemanların engellenmesi.
* **`MobilePhone` İşlevselliği:** Yeni kişi ekleme, güncelleme, silme ve arama (`findContact`, `queryContact`) metotlarının doğruluğu.
* **Nesne Eşitliği:** `queryContact` metodu testinde, `Contact` nesnelerinin içerik bazlı eşitliğinin (`equals` metodu) doğru çalıştığı kanıtlanır.

---

## Lisans

Bu proje lisanslanmamıştır. Eğitim ve kişisel kullanım amaçlıdır.
