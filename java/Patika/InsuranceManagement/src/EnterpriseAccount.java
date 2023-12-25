import java.util.List;

// Kurumsal
public class EnterpriseAccount extends Account{

    public EnterpriseAccount(User user) {
        super(user);
    }

    @Override
    protected void addToInsure() {

    }

    @Override
    public int compareTo(Account account) {
        if(super.hashCode() < account.hashCode()){
            return -1;
        }else if(super.hashCode() > account.hashCode()){
            return 1;
        }
        return 0;
    }
}
