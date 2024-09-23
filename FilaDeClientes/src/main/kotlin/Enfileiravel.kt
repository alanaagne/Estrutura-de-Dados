interface Enfileiravel {

    //metodos principais

    fun enfileirar(nome : String?) //adiciona novo cliente a fila
    fun desenfileirar() : String?  //retira o próximo da fila
    fun frente() : String? //mostra quem é o próximo da fila
    fun atualizar(nome : String?) //muda o próximo da fila

    //metodos auxiliares

    fun estaCheia() : Boolean //verificador
    fun estaVazia() : Boolean //verificador
    fun imprimir() : String //mostrar fila de espera
}