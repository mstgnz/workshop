import java.util.Scanner;

public class InsuranceManagement {
    public static void main(String[] args) {

        Account mstgnzAccount;
        mstgnzAccount = new IndividualAccount(new User("Mesut","GENEZ","mesutgenez@hotmail.com","asdf1234",36,"Developer"));
        mstgnzAccount.user.setAddress(new HomeAddress("Ev","Türkiye","İstanbul","Ümraniye","çakmak mah. ardıç sok."));
        mstgnzAccount.setInsurance(new CarInsurance("Arabam","2021-01-01","2021-12-12"));
        mstgnzAccount.setInsurance(new HealthInsurance("Sağlık","2021-01-01","2021-12-12"));
        mstgnzAccount.setInsurance(new TravelInsurance("Tatil","2021-01-01","2021-12-12"));
        mstgnzAccount.setInsurance(new ResidenceInsurance("Residance kim kaybetmiş biz bulalım","2021-01-01","2021-01-01"));

        //System.out.println(mstgnzAccount.user.getAddresses().size());

        mstgnzAccount.user.setAddresses(AddressManager.addToAddress(mstgnzAccount.user, new HomeAddress("Memleket","Türkiye","Samsun","Tekkeköy","19 mayıs mahallesi")));

        //System.out.println(mstgnzAccount.user.getAddresses().size());

        AccountManager accountManager = new AccountManager();
        accountManager.setAccount(mstgnzAccount);

        Scanner scanner = new Scanner(System.in);

        System.out.print("E-mail Adresiniz : ");
        String email = scanner.next();

        System.out.print("Şifreniz : ");
        String password = scanner.next();

        Account currenAccount = null;

        try {
            currenAccount = accountManager.login(email, password);
        }catch (InvalidAuthenticationException e){
            System.out.println("Kayıt Bulunamadı!");
            System.exit(0);
        }

        System.out.println("Sayın "+ currenAccount.user.getFirstname()+" "+currenAccount.user.getLastname()+" Hoşgeldiniz..");

        System.out.println(currenAccount.getAuthenticationStatus());


    }



}