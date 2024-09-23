fun main(){
//Código para cenário de ED:
//Implementação de uma fila de espera em um sistema de atendimento ao cliente.
var Fila: Enfileiravel = FilaClientes(10)
    Fila.enfileirar("José")
    Fila.enfileirar("João")
    Fila.desenfileirar() //tira josé
    Fila.enfileirar("Maria")
    Fila.enfileirar("Ana")
    Fila.enfileirar("Pedro")
    println(Fila.frente())
    Fila.atualizar("Josué") //troca joão por josué
    println(Fila.imprimir())
}