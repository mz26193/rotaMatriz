
/**
* Clase para rotar una matriz en sentido contrario a las manecillas del relog
* 
* @Margarito Zarate Santiago 
* @version (21-04-2017)
*/
public class RotarMatriz
{

private int [][] matrizOriginal;
private int [][] matrizCopia;
private int filas;
private int columnas;
private int rotaciones;

public RotarMatriz(int fil, int cols, int rot)
{
    filas=fil;
    columnas=cols;
    rotaciones=rot;
    matrizOriginal= new int[filas][columnas];
    matrizCopia= new int[filas][columnas];
    cargarMatrizInicial();
    System.out.println("\n\n:::::Matriz Original:::::");
    imprimirOriginal();

    //rotamos el numero de veces indicado
   for (int r=0;r<rotaciones;r++){
     rotar(0,0); 

               for(int i=0; i<filas;i++){
                for (int j=0;j<columnas;j++){
                   matrizOriginal[i][j]=matrizCopia[i][j];
                } 
            }

   }
   System.out.println("\n\n:::::Matriz Rotada "+rotaciones+" veces:::::");
    imprimirMatriz();
}


public  void rotar(int inicioX,int inicioY){
 
    int x=inicioX;
    int y=inicioY;
    int guardarNumero=0;
    int aux=0;
        
  
    while(abajo(x,y)){   
           guardarNumero=matrizOriginal[x][y];
            x++;
            matrizCopia[x][y]=guardarNumero;
            matrizOriginal[x-1][y]=0;
    }
    
    while(derecha(x,y)){
        guardarNumero=matrizOriginal[x][y];
        y++;
        matrizCopia[x][y]=guardarNumero; 
        matrizOriginal[x][y-1]=0;

    }
    
    while(arriba(x,y)){
        guardarNumero=matrizOriginal[x][y];
        x--;
        matrizCopia[x][y]=guardarNumero;
        matrizOriginal[x+1][y]=0;
    }
       
    while(izquierda(x,y)){
      guardarNumero=matrizOriginal[x][y];
        y--;
      matrizCopia[x][y]=guardarNumero;
      matrizOriginal[x][y+1]=0;
    }
    //rrecorrer a la izq una ultima vez 
    y--;
    matrizCopia[x][y]=matrizOriginal[x][y+1];
   
   if(inicioX+1<filas && inicioY+1<columnas){
        inicioX++;
        inicioY++;
        if(matrizOriginal[inicioX][inicioY]!=0){ //si no se ha rotado
            rotar(inicioX,inicioY);
        }
    }

}

public void cargarMatrizInicial(){   
    int numero=1;
               for(int i=0; i<filas;i++){
                for (int j=0;j<columnas;j++){
                   matrizOriginal[i][j]=numero;
                   numero++;
                } 
            }
}
public void imprimirMatriz(){
            System.out.print("\n");
              for(int a=0; a<filas;a++){
                 System.out.print("\n");
                for (int b=0;b<columnas;b++){
                   System.out.print(" "+completaCeros(String.valueOf(matrizCopia[a][b]),2)+" ");
                }
            }
            
        }
        
        public void imprimirOriginal(){
            System.out.print("\n");
              for(int a=0; a<filas;a++){
                 System.out.print("\n");
                for (int b=0;b<columnas;b++){
                   System.out.print(" "+completaCeros(String.valueOf(matrizOriginal[a][b]),2)+" ");
                }
            }
            
        }
        
public static String completaCeros(String cadena, int longitud) {
    String strPivote = "";

    for (int i = cadena.length(); i < longitud; i++) {
        strPivote = strPivote + "0";
    }

    return strPivote + cadena;
}
        
        // metodo para verificar si es posible deszplazar hacia abajo
        public boolean abajo(int x,int y){
           if(x<filas-1){
               if(matrizOriginal[x+1][y]!=0){
                    return true;
                }
            }
                return false;

        }
        
        // metodo para verificar si es posible deszplazar hacia la izquiera
        public boolean izquierda(int x,int y){
             if(y>0){
                 if(matrizOriginal[x][y-1]!=0){
                     return true;
                }
            }
               return false;
            
        }
        
       // metodo para verificar si es posible deszplazar hacia arriba
        public boolean arriba(int x,int y){
            
             if(x>0){
                 if(matrizOriginal[x-1][y]!=0){
                     return true;
                    }
            }
                return false;
        }
        
        // metodo para verificar si es posible deszplazar hacia la derecha
          public boolean derecha(int x,int y){
             if(y<columnas-1 ){
              if(matrizOriginal[x][y+1]!=0){
               return true;
            }
            }
                return false;
            
        }
        
        public static void main (String [] args){
           RotarMatriz rotar=new RotarMatriz(5,4,7);
        }
}
