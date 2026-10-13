import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class ResumeGenerator {

    private String destPath;
    private String imagePath;

    public ResumeGenerator(String destPath, String imagePath) {
        this.destPath = destPath;
        this.imagePath = imagePath;
    }

    public void generatePDF() {
        try {
            PdfWriter writer = new PdfWriter(destPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // TÜRKÇE KARAKTER DESTEĞİ İÇİN FONT AYARI
            // Helvetica fontunu Türkçe (Cp1254) kodlaması ile oluşturuyoruz
            PdfFont turkishFont = PdfFontFactory.createFont(StandardFonts.HELVETICA, "Cp1254");

            // Oluşturduğumuz bu fontu tüm dokümana varsayılan olarak atıyoruz
            document.setFont(turkishFont);

            // Başlık
            Paragraph title = new Paragraph("ÖZGEÇMİŞ")
                    .setFontSize(24)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            // Fotoğraf Ekleme
            try {
                ImageData imageData = ImageDataFactory.create(imagePath);
                Image profileImage = new Image(imageData);
                profileImage.setWidth(100);
                profileImage.setHeight(100);
                profileImage.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.CENTER);
                document.add(profileImage);
            } catch (Exception e) {
                document.add(new Paragraph("(Fotoğraf bulunamadı: " + imagePath + ")").setTextAlignment(TextAlignment.CENTER));
            }

            // Kişisel Bilgiler
            document.add(new Paragraph("\nKİŞİSEL BİLGİLER").setBold().setFontSize(14));
            document.add(new Paragraph("Ad Soyad: Mehmet berke Ünlütürk\n" +
                    "E-posta: pourtier06@gmail.com\n" +
                    "Telefon: +90 551 061 86 24\n" +
                    "Adres: Kırklareli, Türkiye"));

            // Eğitim Bilgileri
            document.add(new Paragraph("\nEĞİTİM BİLGİLERİ").setBold().setFontSize(14));
            document.add(new Paragraph("Kırklareli Üniversitesi - Yazılım Mühendisliği (2025 - Devam Ediyor)"));

            // 3 Hayali İş Deneyimi
            document.add(new Paragraph("\nİŞ DENEYİMİ").setBold().setFontSize(14));

            document.add(new Paragraph("1. Kıdemli Backend Geliştirici - TechNova Çözümleri (2023 - 2025)").setBold());
            document.add(new Paragraph("- Mikroservis mimarisi kullanılarak yüksek trafiğe sahip web uygulamaları geliştirildi.\n- Veritabanı optimizasyonları ile sorgu süreleri %40 azaltıldı."));

            document.add(new Paragraph("\n2. Yazılım Mühendisi - Global Yazılım A.Ş. (2021 - 2023)").setBold());
            document.add(new Paragraph("- Java ve Spring Boot kullanılarak kurumsal RESTful API'ler tasarlandı.\n- CI/CD süreçlerinin entegrasyonu sağlandı."));

            document.add(new Paragraph("\n3. Junior Geliştirici - KodMerkezi Bilişim (2019 - 2021)").setBold());
            document.add(new Paragraph("- Müşteri talepleri doğrultusunda web arayüzü hata çözümleri gerçekleştirildi.\n- Günlük Scrum toplantılarına katılım sağlandı ve çevik (agile) süreçlere uyum sağlandı."));

            // Dokümanı kapatma
            document.close();
            System.out.println("Özgeçmiş başarıyla oluşturuldu: " + destPath);

        } catch (Exception e) {
            System.err.println("PDF oluşturulurken bir hata meydana geldi: " + e.getMessage());
        }
    }
}
