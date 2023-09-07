import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Pila {
    //cadena de ejemplo "(8-4) * (8+6)"
    static Scanner scanner= new Scanner(System.in); //ingresar oracion

    static StringBuilder cadenaRes = new StringBuilder(); //oracion posfija
    static Stack <String> pila= new Stack<String>(); //pila

    //inicio main
    public static void main(String[] args) {
        System.out.println("Ingrese una oración: ");
        String cadena = scanner.nextLine();
        StringTokenizer st= new StringTokenizer(cadena, "()", true); //delimitar la pila

        //checar la longitud de la pila
        while (st.hasMoreTokens()){
            String token= st.nextToken(); //convetir a tokens los caracteres de la pila

//checar si contiene el parentesis de apertura y empujarlo a la pila
            if (token.contains("(") || token.contains("{") || token.contains("[")){
                pila.push(token);
            }

            //si empieza con el de cierre y la punta de la pila no es el de apertura, va metiendo lo demás al String
           if (token.contains(")") || token.contains("}") || token.contains("]")){
                while (!pila.isEmpty() && pila.peek() != "(" && pila.peek() != "{" && pila.peek() != "[") {
                    cadenaRes.append(pila.pop());
                }
            }

           //si en la punta tiene el de apertura, lo mete a la pila
            if (!pila.isEmpty() && pila.peek().equals("(") && pila.peek().equals("{") && pila.peek().equals("[")) {
                pila.pop();
            }
            //si detecta operadores los mete al String
            else {
                while (!pila.isEmpty() && (token.contains("+") || token.contains("-")
                        || token.contains("*" )|| token.contains("/"))) {
                    cadenaRes.append(pila.pop());
                }
               pila.push(token);
            }
            if (pila.isEmpty() == false) {
                cadenaRes.append(pila.pop());
            }



        }// while
        System.out.println(cadenaRes.toString());

    }//end main

}
