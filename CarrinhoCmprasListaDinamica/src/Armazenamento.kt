interface Armazenamento {
    fun adicionarItem(item: Any?)
    fun removerItem(posicao: Int): Any?
    fun listarItens(): Array<Any?>
    fun limparCarrinho()
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}

//interface para implementar um carinho de compras online
//usando a estrutura de dados: lista dinâmica