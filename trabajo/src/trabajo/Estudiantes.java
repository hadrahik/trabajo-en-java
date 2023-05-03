package trabajo;
import javax.swing.*;

public class Estudiantes {
    
    static String[] nombres;
    static int[] edades;
    static int cantidadEstudiantes;
    
    public static void main(String[] args) {
        
        String opcion = "";
        
        do {
            opcion = JOptionPane.showInputDialog(null, "Seleccione una opción:\n\n"
                    + "1. Ingresar estudiantes\n"
                    + "2. Imprimir lista de estudiantes\n"
                    + "3. Promedio de edades\n"
                    + "4. Estudiantes de mayor edad\n"
                    + "5. Estudiantes de menor edad\n"
                    + "6. Estudiantes mayores de edad\n"
                    + "7. Buscar estudiante por nombre\n"
                    + "8. Buscar estudiantes por edad\n"
                    + "9. Salir");
            
            switch(opcion) {
                
                case "1":
                    ingresarEstudiantes();
                    break;
                    
                case "2":
                    imprimirLista();
                    break;
                    
                case "3":
                    promedioEdades();
                    break;
                    
                case "4":
                    estudiantesMayorEdad();
                    break;
                    
                case "5":
                    estudiantesMenorEdad();
                    break;
                    
                case "6":
                    estudiantesMayoresDeEdad();
                    break;
                    
                case "7":
                    buscarPorNombre();
                    break;
                    
                case "8":
                    buscarPorEdad();
                    break;
                    
                case "9":
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
            
        } while(!opcion.equals("9"));
    }
    
    public static void ingresarEstudiantes() {
        
        cantidadEstudiantes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de estudiantes:"));
        nombres = new String[cantidadEstudiantes];
        edades = new int[cantidadEstudiantes];
        
        for(int i = 0; i < cantidadEstudiantes; i++) {
            nombres[i] = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante #" + (i+1) + ":");
            edades[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad de " + nombres[i] + ":"));
        }
        
        JOptionPane.showMessageDialog(null, "Estudiantes ingresados correctamente.");
    }
    
    public static void imprimirLista() {
        
        String lista = "Lista de estudiantes:\n\n";
        
        for(int i = 0; i < cantidadEstudiantes; i++) {
            lista += nombres[i] + " - " + edades[i] + " años\n";
        }
        
        JOptionPane.showMessageDialog(null, lista);
    }
    
    public static void promedioEdades() {
        
        double sumaEdades = 0;
        
        for(int i = 0; i < cantidadEstudiantes; i++) {
            sumaEdades += edades[i];
        }
        
        double promedio = sumaEdades / cantidadEstudiantes;
        
        JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
    }
    
    public static void estudiantesMayorEdad() {
        
        int mayorEdad = edades[0];
        String estudiantes = "";
        
        for(int i = 0; i < cantidadEstudiantes; i++) {
            if(edades[i] > mayorEdad) {
                mayorEdad = edades[i];
            }
        }
        
        for(int i = 0; i < cantidadEstudiantes; i++) {
        if(edades[i] == mayorEdad) {
            estudiantes += nombres[i] + ", ";
        }
    }
    
    estudiantes = estudiantes.substring(0, estudiantes.length()-2);
    
    JOptionPane.showMessageDialog(null, "El/los estudiantes de mayor edad son: " + estudiantes + " con " + mayorEdad + " años.");
}

public static void estudiantesMenorEdad() {
    
    int menorEdad = edades[0];
    String estudiantes = "";
    
    for(int i = 0; i < cantidadEstudiantes; i++) {
        if(edades[i] < menorEdad) {
            menorEdad = edades[i];
        }
    }
    
    for(int i = 0; i < cantidadEstudiantes; i++) {
        if(edades[i] == menorEdad) {
            estudiantes += nombres[i] + ", ";
        }
    }
    
    estudiantes = estudiantes.substring(0, estudiantes.length()-2);
    
    JOptionPane.showMessageDialog(null, "El/los estudiantes de menor edad son: " + estudiantes + " con " + menorEdad + " años.");
}

public static void estudiantesMayoresDeEdad() {
    
    int mayoresDeEdad = 0;
    
    for(int i = 0; i < cantidadEstudiantes; i++) {
        if(edades[i] >= 18) {
            mayoresDeEdad++;
        }
    }
    
    JOptionPane.showMessageDialog(null, "Hay " + mayoresDeEdad + " estudiantes mayores de edad.");
}

public static void buscarPorNombre() {
    
    String nombreABuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante a buscar:");
    boolean encontrado = false;
    
    for(int i = 0; i < cantidadEstudiantes; i++) {
        if(nombres[i].equalsIgnoreCase(nombreABuscar)) {
            JOptionPane.showMessageDialog(null, "El estudiante " + nombres[i] + " tiene " + edades[i] + " años.");
            encontrado = true;
            break;
        }
    }
    
    if(!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con ese nombre.");
    }
}

public static void buscarPorEdad() {
    
    int edadABuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad a buscar:"));
    String estudiantes = "";
    
    for(int i = 0; i < cantidadEstudiantes; i++) {
        if(edades[i] == edadABuscar) {
            estudiantes += nombres[i] + ", ";
        }
    }
    
    if(estudiantes.equals("")) {
        JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con esa edad.");
    } else {
        estudiantes = estudiantes.substring(0, estudiantes.length()-2);
        JOptionPane.showMessageDialog(null, "Los estudiantes con " + edadABuscar + " años son: " + estudiantes);
    }
}
}