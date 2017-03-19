
package cinesuacha;

import java.util.Scanner;
import javax.swing.JOptionPane;  //IMPORTE ESTA LIBRERIA PARA MEJORAR EL MENU 

/**
 *
 * @author BRAHAYAM CARDENAS Y FELIPE MARTINEZ
 */
public class CineSuacha {

    private static boolean costo;
    private static boolean costoEntrada;
    private static boolean dinero;
Scanner entrada =new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
      
       //SOLITO LOS DATOS REQUERIDOS PARA GENERAR LA MATRIZ
     int filas=(int)Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de filas del cine:"));
     int columnas=(int)Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de columnas del cine:"));
    
       //CREO LA MATRIZ UTILIZANDO LOS DATOS INGRESADOS POR EL USUARIO
        char salaCine[][]=new char[filas][columnas];
        salaCine=create(filas,columnas);
        //REALIZO UN PEQUEÑO MENU PARA LA FACILIDAD DEL USUARIO O EJECUTOR
        boolean sitio=true; //PARA PODER EJECUTAR EL PROGRAMA
        do{
            int opcion=(int)Integer.parseInt(JOptionPane.showInputDialog("\n SALA DE CINE :\n"+
                "1.- Ver estado de la Sala.\n"+
                "2.- Asignar lugar disponible\n"+
                "3.- Seleccionar lugar especifico\n"+
                "4.- dinero recojido\n"+
                "5.- salir del programa\n"));
             
            switch(opcion){
                case 1: cine(salaCine);
                break;
                case 2: salaCine=asignarLugar(salaCine);
                break;
                case 3: salaCine=escogerLugar(salaCine);
                break;
                default: sitio=false;
            }
        }while(sitio);
    }
     // RECORRO LA MATRIZ HACIENDO QUE TODAS LAS SILLAS QUEDEN CON UNA "V" PARA LUEGO IDENTIFICAR
    //CUANDO ESTAN  LLENAS Y CUANDO ESTAN OCUPADAS
    public static char[][] create(int columnas,int filas){
  
        char matriz[][]=new char[filas][columnas];
        for(int i=0;i<filas;i++)
            for(int j=0;j<columnas;j++)
                matriz[i][j]='v';
        return matriz;
    }
     
    public static void cine(char mat[][]){
        String cad="";
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[i].length; j++){
                cad+=mat[i][j]+" ";
            }
            cad+="\n";
        }
        JOptionPane.showMessageDialog(null,cad);
    }
     //PIDO LOS DATOS AL CLIENTE Y LE ASIGNO UN LUGAR AL AZAR SEÑALANDO QUE EL CLIENTE CON UNA "X" EN LA MATRIZ QUE HACE REFERENCIA A LA SALA
    public static char[][] asignarLugar(char mat[][]){
        
        
        char matriz[][]=mat;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if(matriz[i][j]=='v'){
                   double costoEntrada=(double)Integer.parseInt(JOptionPane.showInputDialog("ingrese el costo de entrada de la pelicu:"));
                   String nombre = JOptionPane.showInputDialog("Cual es el nombre del cliente");
                   String sexo = JOptionPane.showInputDialog("Cual es el sexo del cliente");
                   int edad=(int)Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad del cliente:"));
                   double dinero=(double)Integer.parseInt(JOptionPane.showInputDialog("ingrese el dinero del cliente:"));
                
                
                    
                    JOptionPane.showMessageDialog(null,"Lugar asignado en la fila "+(i+1)+
                        " y columna "+(j+1));//QUEDA POR DEFECTO EN LA SILLA UNO
                        matriz[i][j]='x';
                        return matriz;
                }else continue;
            }
        }
        return matriz;
    }
     //LE DAMOS AL CLIENTE LA OPCION DE ESCOGER SU SILLA 
    public static char[][] escogerLugar(char mat[][]){
        char matriz[][]=mat;
        do{ 
            int fila=(int)Integer.parseInt(JOptionPane.showInputDialog("Selecciona la fila:"));
            int columna=(int)Integer.parseInt(JOptionPane.showInputDialog("Selecciona la Columna:"));
            if(matriz[fila-1][columna-1]=='x') JOptionPane.showMessageDialog(null,"Vuelve a seleccionar, ese lugar ya se encuentra ocupado");
            else{ 
               String nombre = JOptionPane.showInputDialog("Cual es tu nombre del cliente");
                int edad=(int)Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad del cliente:"));
                int dinero=(int)Integer.parseInt(JOptionPane.showInputDialog("ingrese el dinero del cliente:"));
                JOptionPane.showMessageDialog(null,"Lugar asignado a la fila "+fila+" y columna "+columna);
                matriz[fila-1][columna-1]='x';
                break;
            }
        }while(1==1);
        return matriz;
    }
     public static char[][] dineroRecojido(char mat[][]){
       
            
    }
    
    
    
    
}

