class NoDuplo(var dado: Any?, var anterior: NoDuplo? = null, var proximo: NoDuplo? = null)

class CarrinhoDeCompras(private val tamanho: Int = 10) : Armazenamento {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun adicionarItem(item: Any?) {
        if (!estaCheia()) {
            val noTemp = NoDuplo(item)
            noTemp.anterior = ponteiroFim                
            if (!estaVazia())
                ponteiroFim?.proximo = noTemp
            else
                ponteiroInicio = noTemp
            
            ponteiroFim = noTemp
            quantidade = quantidade.inc()
        } else {
            println("Carrinho Cheio!")
        }
    }

    override fun listarItens(): Array<Any?> {        
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until quantidade) {
                dadosAux[i] = ponteiroAuxiliar?.dado    
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
        } else {
            println("Carrinho Vazio!")
        }
        return dadosAux
    }

    override fun removerItem(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAuxiliar = ponteiroInicio
                for (i in 0 until posicao)
                    ponteiroAuxiliar = ponteiroAuxiliar?.proximo
                
                dadoAux = ponteiroAuxiliar?.dado

                val ponteiroAnterior = ponteiroAuxiliar?.anterior
                val ponteiroProximo  = ponteiroAuxiliar?.proximo

                if (ponteiroAnterior != null) 
                    ponteiroAnterior.proximo = ponteiroProximo
                else
                    ponteiroInicio = ponteiroInicio?.proximo
                
                if (ponteiroProximo != null) 
                    ponteiroProximo.anterior = ponteiroAnterior
                else
                    ponteiroFim = ponteiroFim?.anterior

                quantidade = quantidade.dec()
            } else {
                println("Indice Inválido!")
            }
        } else {
            println("Carrinho Vazio!")
        }
        return dadoAux
    }

    override fun limparCarrinho() {
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }
    
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
}
