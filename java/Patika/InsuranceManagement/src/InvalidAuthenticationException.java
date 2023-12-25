public class InvalidAuthenticationException extends Exception {

    public InvalidAuthenticationException(String message){
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println("Invalid Authentication Exception");
    }
}
