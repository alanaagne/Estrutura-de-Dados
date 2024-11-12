fun main() {

    val agendador = AgendadorDeProcessos(10)

    val p1 = Processo("Processo1", 4)
    val p2 = Processo("Processo2", 8)
    val p3 = Processo("Processo3", 2)
    val p4 = Processo("Processo4", 7)
    val p5 = Processo("Processo5", 6)

    agendador.inserir(p1)
    agendador.inserir(p2)
    agendador.inserir(p3)
    agendador.inserir(p4)
    agendador.inserir(p5)

    println(agendador.imprimir())
    println(agendador.extrair())
    println(agendador.imprimir())
    println(agendador.obter())
    agendador.atualizar(10)
    println(agendador.imprimir())
    println(agendador.extrair())
}

//esse codigo é a mesma coisa do outro a unica alteração é que esse implementa um heap minimo.
