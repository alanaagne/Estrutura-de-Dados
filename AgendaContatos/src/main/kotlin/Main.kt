fun main(){

//insira o contato da seguinte forma: nome: (XX) XXXXXXXXX.

    var agenda: InterfaceAgenda = AgendaContatos(10)

    agenda.adicionarContato("Fulano: (nn) nnnnnnnnn")
    agenda.adicionarContato("Ciclano: (pp) ppppppppp")
    agenda.adicionarContato("beltrano: (tt) ttttttttt")
    println(agenda.imprimir())
    agenda.apagarContato(2)
    agenda.atualizarContato(0,"deltrano: (dd) ddddddddd")
    println(agenda.selecionarContato(1))
    println(agenda.imprimir())
}