package zg.augusto.dominio

import zg.augusto.classificacoes.Grupo
import zg.augusto.classificacoes.MesmoNaipe
import zg.augusto.classificacoes.MesmoValor
import zg.augusto.classificacoes.Sequencia
import zg.augusto.combinacoes.Combinacao
import zg.augusto.gerenciador.CategorizadorJogadas

class PokerHand {

	final Carta[] cartas
	final Carta maiorCarta
	final Set<Grupo> grupos
	final Combinacao melhorCombinacao

	PokerHand(String maoStr) {
		this.cartas = Carta.fromString(maoStr).sort(false).reverse()
		this.maiorCarta = cartas[0]
		this.grupos = MesmoNaipe.fromCartas(cartas) + MesmoValor.fromCartas(cartas) + Sequencia.fromCartas(cartas)
		this.melhorCombinacao = calcularMelhorCombinacao()
	}

	Boolean temGrupoComMesmoValor(Integer ocorrenciaMinima = 2) {
		return grupos.any { Grupo it ->
			return it instanceof MesmoValor && it.cartas.size() == ocorrenciaMinima
		}
	}

	private Combinacao calcularMelhorCombinacao() {
		return new CategorizadorJogadas(this).calcularMelhorJogada()
	}

	Result compareWith(PokerHand outraMao) {
		return melhorCombinacao.compararCom(outraMao.melhorCombinacao) < 0 ? Result.LOSS : Result.WIN
	}

}
