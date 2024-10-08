
package Model;


public class Resident extends User{
    private Tutor tutor;
    
    public Resident(String cpf, String name, String email, String address, String password, Tutor tutor) {
        super(cpf, name, email, address, password);
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Residente\nTutor: " + this.tutor.getCpf() + " || " + this.tutor.getName();
    }
}
