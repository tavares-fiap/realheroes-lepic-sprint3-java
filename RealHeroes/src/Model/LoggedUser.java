package Model;

public class LoggedUser {

    private String cpf;
    private String name;
    private String email;
    private String address;
    private String password;

    public LoggedUser(String cpf, String name, String email, String address, String password) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
