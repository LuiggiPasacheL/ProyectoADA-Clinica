package modelo;

public class UsuarioArreglo {

    private Usuario[] usuarios;
    private int valorHash = 2;
    private final int tamano;

    public UsuarioArreglo(int tamano){
        this.tamano = tamano;
        usuarios = new Usuario[tamano];
        valorHash = primoMasCercano(tamano);
    }

    public boolean agregar(Usuario usuario){
        int indice = hash(usuario.getUsername());
        for (int i = 0; i < tamano; i++){
            if(usuarios[indice] != null){
                usuarios[indice] = usuario;
            }
            if(indice < tamano){
                indice++;
            }
            else{
                indice = 0;
            }
        }
        return false;
    }

    //TODO busqueda por dni
    //TODO busqueda por username

    private int hash(String username){
        int hash = 0;
        for(int i = 0; i < username.length(); i++)
        {
            hash += username.charAt(i) - 'a';
        }
        hash = hash % valorHash;
        return hash;
    }

    private int primoMasCercano(int valor){
        if(esPrimo(valor)){
            return valor;
        }

        int valor1;
        int valor2;
        valor1 = valor2 = valor;

        for(int i = valor; i > 2; i--) {
            valor1--;
            valor2++;
            if (esPrimo(valor1)) {
                return valor1;
            }
            if(esPrimo(valor2)){
                return valor2;
            }
        }

        return 2;
    }

    private boolean esPrimo(int valor){
        for(int i = 2; i < valor; i++){
            if(valor % i == 0){
                return false;
            }
        }
        return true;
    }

}
