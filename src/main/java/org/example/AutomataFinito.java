package org.example;

public abstract class AutomataFinito {
    private int numEstados;
    private boolean[] finales;
    private int tamAlfabeto;
    private int estActual;

    //Constructores: con y sin finales
    public AutomataFinito(int num, int alfabeto) {
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
    }

    public AutomataFinito(int num, int alfabeto, boolean[] finales) {
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
        this.finales = finales;
    }

    //Otros métodos
    protected void marcarFinal(int estado) {
        this.finales[estado] = true;
    }

    protected void setFinales(boolean[] estadosFinales) {
        this.finales=estadosFinales;
    }

    protected int getNumEstados() {
        return numEstados;
    }

    protected boolean[] getFinales() {
        return this.finales;
    }

    //Método para ver si un estado es final
    protected boolean esEstadoFinal(int estado) {
        return this.finales[estado];
    }

    /*Método de transición. Informa del estado que se alcanza partiendo
     de un estado (estadoActual) y recibiendo una entrada*/
    protected abstract void transicion(int entrada);

    //Método de extension de la trasicion a cadenas
    //Esto es para ver donde cierra desde donde quieras
    protected void cierreTransicion(int estado, int cadena[]){
        int tamC = cadena.length;
        this.estActual=estado;
        for (int i = 0;i<tamC;i++){
            transicion(cadena[i]);
            if (estActual == -1)return;
        }
    }
    //Metodo que informa si una cadena perteneca al lenguaje definido por el automata
    protected boolean perteneceLenguaje(int cadena[]){
       cierreTransicion(0,cadena);
       return esEstadoFinal(estActual);
    }























}
