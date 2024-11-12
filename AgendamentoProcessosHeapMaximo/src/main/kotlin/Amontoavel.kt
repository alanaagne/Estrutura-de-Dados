public interface Amontoavel {
    fun inserir(dado: Processo)  //c  // Inserir um processo
    fun extrair(): Processo?     //d  // Extrair o processo de maior prioridade
    fun obter(): Processo?       //r  // Obter o processo de maior prioridade sem removê-lo
    fun atualizar(dado: Long)    //u  //Atualizar a prioridade de um processo

    fun imprimir(): String       // Imprimir o estado da heap
    fun estaVazia(): Boolean     // Verificador
    fun estaCheia(): Boolean     // Verificador
}
