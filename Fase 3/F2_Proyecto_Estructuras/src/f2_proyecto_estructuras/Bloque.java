/*
    Este objeto será nuestro nodoe en el block chain
 */
package f2_proyecto_estructuras;

public class Bloque {
    
    
    int INDEX; // número de bloque
    String TIMESTAMP; // hora y fecha de la creación del bloque
    String DATA; // json con la info de cada transacciones
    int NONCE; // número que variamos (i++) hasta encontrar el hash adecuando en la prueba de trabajo
    String PREVIOUSHASH; //Es el hash del bloque previo
    String ROOTMERKLE; //hash de la raiz del árbol de merkle(creo)
    String HASH; // hash del bloque actual
    /*
    
    ● INDEX: representa el número de bloque el bloque génesis tendrá valor de
index 0 , los bloques posteriores deberán tener valores 1, 2, 3, 4 ... etc.
● TIMESTAMP (fecha y hora de creación): Es la fecha y hora exacta en la
que se creó el bloque. Debe de tener el siguiente formato:
(DD-MM-YY-::HH:MM:SS).
● DATA: Contendrá cada una de las entregas realizadas por los clientes los
que serán almacenados en este apartado.
● NONCE: Será el número entero que se debe iterar de uno en uno hasta
encontrar un hash que cumpla con la prueba de trabado, es decir que
contenga como prefijo un numero de 0s configurado por el adminsitrador.
● PREVIOUSHASH: Es el hash del bloque previo, este es necesario para
validar que la cadena de bloques no esté corrupta. En caso del bloque
génesis, el hash anterior debe de ser 0000.
● ROOTMERKLE: En este bloque se almacena el nodo padre del árbol de
Merkle.Este árbol de Merkle se forma con los datos del campo DATA, que son
las operaciones de entrega
● HASH (bloque actual): El hash que protege que la data no se ha
comprometido, el hash deberá generarse aplicando la función SHA256 a las
propiedades: INDEX, TIMESTAMP, PREVIOUSHASH, ROOTMERKLE y
NONCE todas estas propiedades como cadenas concatenadas sin
espacios en blanco ni saltos de línea. Es decir
SHA256(INDEX+TIMESTAMP+PREVIOUSHASH+ROOTMERKLE+NONCE).
Para considerar el hash como válido este debe de tener un prefijo de cuatro
ceros. Es decir que un hash valido sería el siguiente:
000082b12041cb5a7bac8ec90f86b654af6b1ac8bfc5ed08092e217235df0229
    
    */
    
    
}
