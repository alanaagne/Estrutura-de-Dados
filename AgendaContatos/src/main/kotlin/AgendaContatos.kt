class AgendaContatos : InterfaceAgenda {

//variaveis de instancia

   private val agenda: Array<String?>
   private var ponteiroInicio: Int
   private var ponteiroFim: Int
   private var quantidade: Int

//construtor:

   constructor(tamanho: Int){
       ponteiroFim = -1
       ponteiroInicio = 0
       quantidade = 0
       agenda = arrayOfNulls(tamanho)
   }

//metodos auxiliares:

    override fun estaCheia(): Boolean {
        return (quantidade == agenda.size)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {
        var retorno = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade){
           if (i == ponteiroFim){
               retorno += ("${agenda[(ponteiroAux+i)%agenda.size]}")
           }
            else{
                retorno += ("${agenda[(ponteiroAux+i)%agenda.size]}, ")
            }
        }
        return "$retorno]"
    }

//metodos principais

    override fun adicionarContato(contato: String?) {
        if (!estaCheia()){
            ponteiroFim++
            if (ponteiroFim == agenda.size){
                ponteiroFim = 0
            }
            agenda[ponteiroFim] = contato
            quantidade++
        }
        else {
            println("a agenda esta cheia")
        }
    }

    override fun atualizarContato(posicao: Int, contato: String?) {
        if (!estaVazia()){
            if (posicao >= 0 && posicao < quantidade){  //verificar posição fisica
                var posicaoFisica = (ponteiroInicio + posicao)%agenda.size
                agenda[posicaoFisica] = contato
            }
            else {
                println("posição inválida")
            }

        }
        else{
            println("a agenda esta vazia")
        }
    }

    override fun selecionarContato(posicao: Int): String? {
        var contatoAux: String? = null
        if (!estaVazia()){
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao)%agenda.size
                contatoAux = agenda[posicaoFisica]
            }
            else {
                println("posição inválida")
            }
        }
        else{
            println("a agenda esta vazia")
        }
        return contatoAux
    }

    override fun apagarContato(posicao: Int) {
        if (!estaVazia()){
            if (posicao >= 0 && posicao < quantidade){
                var posicaoFisica = (ponteiroInicio + posicao)%agenda.size
                var ponteiroAux = posicaoFisica
                for (i in posicao until quantidade-1){
                    var atual = ponteiroAux
                    var proximo = (ponteiroAux+1)%agenda.size
                    agenda[atual] = agenda[proximo]
                    ponteiroAux++
                }
                ponteiroFim--
                if (ponteiroFim == -1){
                    ponteiroFim = agenda.size-1
                }
                quantidade--
            }
            else {
                println("posição inválida")
            }
        }
        else{
            println("a agenda esta vazia")
        }
    }
}