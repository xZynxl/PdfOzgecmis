public class Main {
    public static void main(String[] args) {
        // Çıktı dosyasının ve profil fotoğrafının yolları
        String pdfDestination = "Ozgecmis.pdf";
        // DİKKAT: Proje klasörünün içine "profil.jpg" adında bir fotoğraf eklemelisin.
        String photoPath = "profil.jpg";

        // PDF oluşturucu nesnenin örneklendirilmesi (Instantiation)
        ResumeGenerator resumeGen = new ResumeGenerator(pdfDestination, photoPath);

        // PDF oluşturma metodunun çağrılması
        resumeGen.generatePDF();
    }
}
