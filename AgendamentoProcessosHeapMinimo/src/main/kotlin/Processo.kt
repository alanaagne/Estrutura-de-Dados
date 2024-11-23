// Definindo a classe Processo
class Processo(val nome: String, var prioridade: Long) {
    // Função que exibe as informações do processo 
    fun exibirInfo() { 
        println("Nome do Processo: $nome") 
        println("Prioridade: $prioridade") 
        }

    // Função que altera a prioridade do processo 
    fun alterarPrioridade(novaPrioridade: Long) { 
        prioridade = novaPrioridade 
        } 
    }
