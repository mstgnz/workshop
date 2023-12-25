import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Comparable<Account>{

    protected User user;
    protected List<Insurance> insurances;
    protected AuthenticationStatus authenticationStatus;

    protected Account(User user) {
        this.user = user;
        this.insurances = new ArrayList<>();
        this.authenticationStatus = null;
    }

    protected User getUser() {
        return user;
    }

    protected void setUser(User user) {
        this.user = user;
    }

    protected List<Insurance> getInsurances() {
        return insurances;
    }

    protected void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    protected void setInsurance(Insurance insurance) {
        this.insurances.add(insurance);
    }

    protected AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    protected void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    @Override
    public int hashCode() {
        return this.user.getEmail().hashCode() * this.user.getPassword().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){ return true; }
        if(obj == null || this.getClass() != obj.getClass()){ return false; }
        Account account = (Account) obj;
        return this.user.getEmail().equals(account.user.getEmail()) && this.user.getPassword().equals(account.user.getPassword());
    }

    public final void showUserInfo(){
        // "Account" sınıfında müşteri bilgilerini ekrana yazdıran "final" tipinde, değer döndürmeyen ve ismi "showUserInfo" bir fonksiyon tanımlayınız.
        System.out.println("Kullanıcı Adı Soyadı : "+this.user.getFirstname()+" "+this.user.getLastname()+"\nKullanılan sigorta sayısı : "+this.getInsurances().size());
    }

    protected  abstract void addToInsure();

}
