class FilaClientes : Enfileiravel {
    //variaveis necessárias

    private var ponteiroInicio : Int
    private var ponteiroFim : Int
    private var nomes: Array<String?>
    private var quantidade : Int

    //construtor
    constructor(tamanho : Int) {
        ponteiroInicio = 0
        ponteiroFim = -1
        nomes = arrayOfNulls(tamanho)
        quantidade = 0
    }

    //implementação de métodos auxiliares

    override fun estaCheia(): Boolean {
        return quantidade == nomes.size
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var retorno = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 .. quantidade-1){
            if (i == quantidade-1){
                retorno += "${nomes[ponteiroAux % nomes.size]}"
            }else {
                retorno += "${nomes[ponteiroAux % nomes.size]},"
            }
            ponteiroAux++
        }
        return "$retorno]"
    }

    //implementação dos métodos principais

    override fun enfileirar(nome: String?) {
        if (!estaCheia()) {
            ponteiroFim++
            if (ponteiroFim == nomes.size)
                ponteiroFim = 0
            quantidade++
            nomes[ponteiroFim] = nome
        } else {
            println("Queue is full!")
        }
    }

    override fun desenfileirar(): String? {
        var nomeInicio: String? = null
        if (!estaVazia()) {
            nomeInicio = nomes[ponteiroInicio]
            ponteiroInicio++
            if (ponteiroInicio == nomes.size)
                ponteiroInicio = 0
            quantidade--
        } else {
            println("Queue is empty!")
        }
        return nomeInicio
    }

    override fun frente(): String? {
        var nomeInicio: String? = null
        if (!estaVazia()) {
            nomeInicio = nomes[ponteiroInicio]
        } else {
            println("Queue is empty!")
        }
        return "primeiro da fila: $nomeInicio"
    }

    override fun atualizar(nome: String?) {
        if (!estaVazia())
            nomes[ponteiroInicio] = nome
        else
            println("Queue is empty!")
    }
}