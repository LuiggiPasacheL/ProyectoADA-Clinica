
public class Sistema{

    private Clinica[] clinica;
    private int indexClinica = 0;

    private Usuario[] usuario;
    private int indexUsuario = 0;

    public Sistema(int nUsuarios, int nClinicas){
        clinica = new Clinica[nClinicas];
        usuario = new Usuario[nUsuarios];
    }

    public Sistema(){
        clinica = new Clinica[100];
        usuario = new Usuario[100];
    }

    public boolean agregarClinica(Clinica clinica){
        try{
            this.clinica[indexClinica] = clinica;
            this.indexClinica++;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean agregarUsuario(Usuario usuario){
        try{
            this.usuario[indexUsuario] = usuario;
            this.indexUsuario++;
            return true;
        }
        catch(Excepcion e){
            return false;
        }
    }

}
