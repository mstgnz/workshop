import java.util.List;

public class AddressManager {

    public static List<Address> addToAddress(User user, Address address){
        user.setAddress(address);
        return user.getAddresses();
    }

    public static List<Address> deleteToAddress(User user, Address address){
        for (int i = 0; i < user.getAddresses().size(); i++) {
            if(user.getAddresses().get(i).hashCode() == address.hashCode()){
                user.getAddresses().remove(i);
                break;
            }
        }
        return user.getAddresses();
    }
}
