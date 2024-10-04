
package Model;

public class Tutor extends User{

    public Tutor(String cpf, String name, String email, String address, String password) {
        super(cpf, name, email, address, password);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Tutor";
    }
}
