fun main() {
    val carrinho = CarrinhoDeCompras()

    val item1 = Item("Notebook", 2500.00)
    val item2 = Item("Mouse", 150.00)
    val item3 = Item("Teclado", 300.00)

    carrinho.adicionarItem(item1)
    carrinho.adicionarItem(item2)
    carrinho.adicionarItem(item3)

    println("Itens no carrinho:")
    carrinho.listarItens().forEach { if (it != null) println("${(it as Item).nome} - R$${it.preco}") }

    carrinho.removerItem(1)

    println("Itens no carrinho após remoção:")
    carrinho.listarItens().forEach { if (it != null) println("${(it as Item).nome} - R$${it.preco}") }

    carrinho.limparCarrinho()

    println("Itens no carrinho após limpeza:")
    carrinho.listarItens().forEach { if (it != null) println("${(it as Item).nome} - R$${it.preco}") }
}
