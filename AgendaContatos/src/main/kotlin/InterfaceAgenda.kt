interface InterfaceAgenda {

//metodos principais para a agenda:

    fun adicionarContato(contato: String?)                 //adiciona um novo contato
    fun apagarContato(posicao: Int)                        //apaga um contato da agenda
    fun selecionarContato(posicao: Int): String?           //seleciona um contato existente
    fun atualizarContato(posicao: Int, contato: String?)   //atualiza um contato existente

//metodos auxiliares

    fun estaCheia(): Boolean    //verificador
    fun estaVazia(): Boolean    //verificador
    fun imprimir(): String      //exibir agenda

}