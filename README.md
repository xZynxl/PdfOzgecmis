# Java PDF Resume Generator

Bu proje, Java programlama dili ve nesne yönelimli programlama (OOP) prensipleri kullanılarak PDF formatında profesyonel bir özgeçmiş (CV) üreten bir konsol uygulamasıdır. Projede arayüz (GUI) kullanılmamış olup, PDF üretimi arka planda gerçekleşmektedir.

## Kullanılan Teknolojiler ve Bileşenler

*   **Java (JDK 11+):** Uygulamanın temel programlama dilidir. Nesne yönelimli yapısı sayesinde kodun modüler olması sağlanmıştır.
*   **iText 7 Kütüphanesi:** PDF oluşturma ve formatlama işlemleri için sektörde en çok tercih edilen, güvenilir ve esnek yapısı nedeniyle iText 7 kullanılmıştır.
*   **ResumeGenerator Sınıfı:** *Single Responsibility (Tek Sorumluluk)* prensibine uygun olarak tasarlanmıştır. PDF oluşturma mantığı `Main` sınıfından ayrıştırılarak bu sınıfa aktarılmıştır. Bu sayede kod okunabilirliği ve bakımı kolaylaştırılmıştır.
*   **Main Sınıfı:** Uygulamanın giriş noktasıdır. Yalnızca dosya yollarını belirler ve `ResumeGenerator` nesnesini örnekleyerek yaşam döngüsünü başlatır.

## Projenin Özellikleri

*   Belirtilen dizine `Ozgecmis.pdf` adında bir dosya oluşturur.
*   Kişisel bilgileri ve vesikalık bir profil fotoğrafını belgeye otomatik ekler.
*   Hayali 3 farklı profesyonel iş deneyimini kronolojik sırayla yapılandırır.
*   Dışa kapalı (private) değişkenler ve kurucu metotlar aracılığıyla Kapsülleme (Encapsulation) mantığını uygular.

## Kurulum ve Çalıştırma

1. Repoyu bilgisayarınıza klonlayın:
   `git clone [REPO_LINKINIZ]`
2. Proje dizinine `profil.jpg` adında bir resim dosyası ekleyin.
3. Pom.xml üzerinden Maven bağımlılıklarını güncelleyin (iText 7).
4. `Main.java` dosyasını çalıştırın. `Ozgecmis.pdf` dosyası proje ana dizininde oluşturulacaktır.