
import controlador.CtrlLogin;
import modelo.*;
import vista.FrmLogin;
import general.Datos;


public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            crearHospitales();
            crearMedicos(); 
            Datos.clinicas.deserializarPacientes();
        } catch (Exception e) {
            System.out.println("El archivo no ha sido encontrado");
        }
        
        Usuario usuario = new Usuario("19200114", "nick", "paredes", "carranza",
                "M", "inverttecla@gmail.com", "970385384", "empleado", "123456", "123456", false);
        Usuario usuario2 = new Usuario("19200092", "luiggi", "pasache", "lopera",
                "M", "luiggi.pasache.lopera@gmail.com", "921810963", "empleado", "123456", "luiggip2108", false);
        Usuario usuario3 = new Usuario("19200095", "luis", "Quispe", "Inquil",
                "M", "luis@gmail.com", "983442995", "empleado", "123456", "luis", false);
        Datos.usuarios.agregar(usuario);
        Datos.usuarios.agregar(usuario2);
        Datos.usuarios.agregar(usuario3);
        
        FrmLogin vista = new FrmLogin();
        CtrlLogin login = new CtrlLogin(vista);
        login.iniciar();
    }

    private static void crearMedicos() {
        try {
            Medico medico1 = new Medico("1", "ADRIANA CAROLINA", "HERNANDEZ", "MONTERROZA", "F",
                    "xio190m@hotmail.co.uk", "28746418", "General");
            Medico medico2 = new Medico("2", "PURIFICACION", "TAPIA", "SILVA", "F",
                    "x1i618n2k@hotmail.co.uk", "28746418", "General");
            Medico medico3 = new Medico("3", "NAYARA", "DEL RIO", "GODOY", "F",
                    "lmlxbal3w@lycos.co.uk", "23789407", "General");
            Medico medico4 = new Medico("4", "JORGE", "REY", "ALONSO", "M",
                    "lig58a7may@unforgettable.com", "58149969", "General");
            Medico medico5 = new Medico("5", "ARIADNA", "MILLAN", "MARRERO", "M",
                    "54dg1gbflz@lycos.co.uk", "27755627", "Cardiolog??a");
            Medico medico6 = new Medico("6", "ENRIC", "TAPIA", "MENENDEZ", "M",
                    "9wsjrlk970@netscape.net", "84566452", "Cardiolog??a");
            Medico medico7 = new Medico("7", "IGNACIO", "PACHECO", "GRAU", "M",
                    "jtsjwtyjk@mail.com", "84566452", "Cardiolog??a");
            Medico medico8 = new Medico("7", "IGNACIO", "PACHECO", "GRAU", "M",
                    "jtsjwtyjk@mail.com", "84566452", "Cardiolog??a");

            Datos.clinicas.a??adirMedico("Guillermo Almenara Irigoyen", medico1);
            Datos.clinicas.a??adirMedico("Arzobispo Loayza", medico2);
            Datos.clinicas.a??adirMedico("Cayetano Heredia", medico3);
            Datos.clinicas.a??adirMedico("Jos?? Casimiro Ulloa", medico4);
            Datos.clinicas.a??adirMedico("Edgardo Rebagliati Martins", medico5);
            Datos.clinicas.a??adirMedico("Guillermo Almenara Irigoyen", medico6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearHospitales() {
        Clinica clinica1 = new Clinica("Guillermo Almenara Irigoyen",
                "Jir??n Garc??a Naranjo 840, La Victoria 13, Lima.",
                45, 2500, 40, 2000, 1);

        Clinica clinica2 = new Clinica("Arzobispo Loayza",
                "Avenida Alfonso Ugarte 848, Cercado de Lima 15082.",
                45, 2500, 40, 2000, 2);

        Clinica clinica3 = new Clinica("Cayetano Heredia",
                "1 CV Zac, Av. Honorio Delgado 262, San Mart??n de Porres 15102",
                45, 2500, 40, 2000, 3);

        Clinica clinica4 = new Clinica("Jos?? Casimiro Ulloa",
                "Av. Rep??blica de Panam?? 6399, Miraflores 15048",
                45, 2500, 40, 2000, 4);

        Clinica clinica5 = new Clinica("Edgardo Rebagliati Martins",
                "Av Edgardo Rebagliati 490, Jes??s Mar??a 15072",
                45, 2500, 40, 2000, 5);

        Datos.clinicas.anadirClinica(clinica1);
        Datos.clinicas.anadirClinica(clinica2);
        Datos.clinicas.anadirClinica(clinica3);
        Datos.clinicas.anadirClinica(clinica4);
        Datos.clinicas.anadirClinica(clinica5);
    }

}
