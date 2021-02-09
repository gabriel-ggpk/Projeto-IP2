package exceptions;

public class LoginJaExisteException extends Exception {

    private String login;

    public LoginJaExisteException(String login) {
        super("Login Já Existe");
        this.login = login;
    }

}
