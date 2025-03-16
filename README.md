#Ates ve Su - Oyun Projesi
Bu proje, "Ates ve Su" adlı 2D platform oyununu Java kullanarak geliştirilmiş bir projedir. Oyuncu, farklı düşmanlarla mücadele ederek ve engelleri aşarak ilerlemeye çalışır. Zorlu haritalarda puanlar toplar ve en kısa sürede hedefe ulaşmaya çalışır. Oyun, Java ve Java Swing kütüphanelerini kullanarak geliştirilmiştir.

#Özellikler
2D Platform Oyun: Oyuncu, engelleri aşarak hedefe ulaşmaya çalışır.
Karakter Kontrolü: Klavye ile oyuncu hareketlerini ve zıplama işlemlerini kontrol etme.
Düşmanlar: Düşmanlar eklenmiştir ve oyuncuyla çarpışma mekanizması vardır.
Çarpışma Algılama: Oyuncu ile engeller arasındaki çarpışmalar dinamik olarak kontrol edilir.
Renkli Harita: Her seviyede harita renkleri değişebilir, "f" tuşu ile renk değiştirme özelliği.

#Teknolojiler ve Araçlar
Java 8+
Java Swing (GUI için)
Threading (Oyun döngüsü ve animasyonlar için)

#Kurulum ve Çalıştırma
1. Adım: Depoyu Klonlama
Projeyi bilgisayarınıza klonlamak için terminalde aşağıdaki komutu çalıştırabilirsiniz:
git clone https://github.com/kullaniciadi/ates-ve-su.git

2. Adım: Bağımlılıkları Yükleyin
Projede ek bir bağımlılık yönetimi (Maven, Gradle vb.) kullanılmamaktadır, ancak Java'yı yüklemeniz gerekecektir. Projeyi çalıştırmak için JDK'nın yüklü olduğundan emin olun.

3. Adım: Uygulamayı Çalıştırma
Projenin ana sınıfı Main.java'dır. Uygulamayı çalıştırmak için şu komutu kullanabilirsiniz:
java Main
Ya da IDE (Eclipse, IntelliJ IDEA vb.) üzerinden projeyi açıp çalıştırabilirsiniz.

Oynanış
Hareketler: Oyuncu W, A, S, D tuşlarıyla hareket eder.
W: Zıplama.
A: Sola hareket.
D: Sağa hareket.
Renk Değiştirme: Harita üzerinde renk değiştirmek için F tuşuna basın.
Düşmanlarla Çarpışma: Oyuncunun düşmanlarla çarpışması durumunda oyun sıfırlanır.
Skor: Oyuncu, haritada bulunan puanları toplayarak skor kazanır. Skor ekranın üst kısmında görüntülenir.
