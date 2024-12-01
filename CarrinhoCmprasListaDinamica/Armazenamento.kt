interface Armazenamento {
    fun adicionarItem(item: Item)
    fun removerItem(item: Item): Boolean
    fun listarItens(): List<Item>
    fun limparCarrinho()
}

//interface para implementar um carinho de compras online
//usando a estrutura de dados: lista dinâmica