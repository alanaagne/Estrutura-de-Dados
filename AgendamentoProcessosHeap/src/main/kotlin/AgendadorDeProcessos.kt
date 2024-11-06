class AgendadorDeProcessos(private val tamanho: Int = 10) : Amontoavel {

    private var processos = arrayOfNulls<Processo>(tamanho)
    private var ponteiroFim = -1

    override fun inserir(dado: Processo) {
        if (!estaCheia()) {
            ponteiroFim = ponteiroFim.inc()
            processos[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap está Cheio!")
        }
    }

    private fun ajustarAcima(indice: Int) {
        var indiceAtual = indice
        while (indiceAtual != 0) {
            val indicePai = indicePai(indiceAtual)
            if (processos[indicePai]?.prioridade ?: 0 < processos[indiceAtual]?.prioridade ?: 0) {
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai
            } else {
                break
            }
        }
    }


    private fun indicePai(indiceFilho: Int): Int {
        return (indiceFilho - 1) / 2
    }

    private fun indiceFilhoEsquerda(indicePai: Int): Int {
        return 2 * indicePai + 1
    }

    private fun indiceFilhoDireita(indicePai: Int): Int {
        return 2 * indicePai + 2
    }

    private fun ajustarAbaixo(pai: Int) {
        val filhoEsquerdo = indiceFilhoEsquerda(pai)
        val filhoDireito = indiceFilhoDireita(pai)
        var maior = pai

        if (filhoEsquerdo <= ponteiroFim && processos[maior]?.prioridade ?: 0 < processos[filhoEsquerdo]?.prioridade ?: 0)
            maior = filhoEsquerdo

        if (filhoDireito <= ponteiroFim && processos[maior]?.prioridade ?: 0 < processos[filhoDireito]?.prioridade ?: 0)
            maior = filhoDireito

        if (maior != pai) {
            trocar(pai, maior)
            ajustarAbaixo(maior)
        }
    }


    private fun trocar(i: Int, j: Int) {
        val temp = processos[i]
        processos[i] = processos[j]
        processos[j] = temp
    }

    override fun extrair(): Processo? {
        var processoRaiz: Processo? = null
        if (!estaVazia()) {
            processoRaiz = processos[0]
            processos[0] = processos[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        } else {
            println("Heap está Vazio!")
        }
        return processoRaiz
    }

    override fun atualizar(dado: Long) {
        if (!estaVazia()) {
            processos[0]?.prioridade = dado
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }
    }

    override fun obter(): Processo? {
        var processoRaiz: Processo? = null
        if (!estaVazia())
            processoRaiz = processos[0]
        else
            println("Heap Vazia!")
        return processoRaiz
    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == processos.size - 1
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in 0..ponteiroFim) {
            val processo = processos[i]
            if (processo != null) {
                resultado += "${processo.nome}:${processo.prioridade}"
            }
            if (i != ponteiroFim)
                resultado += ", "
        }
        return "$resultado]"
    }
}