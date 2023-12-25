import java.util.TreeSet;

public class AccountManager {

    private TreeSet<Account> accounts;

    public AccountManager() {
        this.accounts = new TreeSet<>();
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }

    public void setAccount(Account account) {
        this.accounts.add(account);
    }

    public Account login(String email, String password) throws InvalidAuthenticationException{
        for (Account account : accounts) {
            if(account.user.getEmail().equals(email) && account.user.getPassword().equals(password)){
                account.setAuthenticationStatus(AuthenticationStatus.SUCCESS);
                return account;
            }
        }
        throw new InvalidAuthenticationException("Account Not Found!");
        // bu sınıf içinde login isminde bir fonksiyon tanımlayınız. Bu fonksiyon dışarıdan verilen email ve şifre bilgisini alıp Account listesi üzerinde dolaşıp uygun bir giriş işlemi bulursa Account nesnesini çağrıldığı yere dönecektir. Bu fonksiyon Account nesnesi üzerindeki "login" olma fonksiyonunu çağıracaktır. Unutmayın bu fonksiyon "InvalidAuthenticationException" tipinde hata fırlatabiliyordu. Bu nedenle burada try-catch mekanizması kurmayı unutmayınız.
    }

}
