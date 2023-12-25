import java.util.Scanner;

public class KullaniciGirisi {
    // https://app.patika.dev/moduller/java101/pratik-login-1
    public static void main(String[] args) {
        String username;
        String password;
        String setPass;

        Scanner scanner = new Scanner(System.in);

       try {
           System.out.print("Kullanıcı Adınız : ");
           username = scanner.nextLine();

           System.out.print("Şifreniz : ");
           password = scanner.nextLine();

           if(username.equals("patika") && password.equals("java123")){
               System.out.println("Giriş Başarılı.");
           }else{
               System.out.print("Şifrenizi sıfırlamak ister misiniz? (yes or no) : ");
               setPass = scanner.nextLine();
               if(setPass.equals("yes")){
                   System.out.print("Yeni Şifreniz : ");
                   password = scanner.nextLine();
                   if(password.equals("java123")){
                       System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                   }else{
                       System.out.println("Şifre oluşturuldu");
                   }
               }else{
                   System.out.println("Giriş başarısız!");
               }
           }
       }catch (Exception e){
           System.out.println("Lütfen bilgileri doğru giriniz");
       }
    }
}
