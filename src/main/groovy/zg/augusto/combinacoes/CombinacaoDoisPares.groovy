package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.Carta
import zg.augusto.dominio.PokerHand

class CombinacaoDoisPares extends Combinacao<CombinacaoDoisPares> {

	CombinacaoDoisPares(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.DOIS_PARES)
	}

	@Override
	Boolean temCombinacao() {
		return mao.grupos.findAll {
			return it instanceof MesmoValor && it.cartas.size() == QUANTIDADE_CARTAS_PAR
		}.size() == QUANTIDADE_CARTAS_PAR
	}

	@Override
	int compararCom(CombinacaoDoisPares alvo) {
		MesmoValor[] paresAtuais = mao.grupos
			.findAll { it instanceof MesmoValor }
			.collect { it as MesmoValor }
			.sort(false) { (it as MesmoValor).valor }
			.reverse()

		MesmoValor[] paresAlvo = alvo.mao.grupos
			.findAll { it instanceof MesmoValor }
			.collect { it as MesmoValor }
			.sort(false) { it.valor }
			.reverse()

		int comparacaoParMaisAlto = paresAtuais[0].valor <=> paresAlvo[0].valor
		if (comparacaoParMaisAlto != 0) {
			return comparacaoParMaisAlto
		}

		int comparacaoSegundoPar = paresAtuais[1].valor <=> paresAlvo[1].valor
		if (comparacaoSegundoPar != 0) {
			return comparacaoSegundoPar
		}

		Carta kickerAtual = (mao.cartas - paresAtuais.collect { it.cartas }.inject { acc, it -> acc + it })[0]
		Carta kickerAlvo = (alvo.mao.cartas - paresAlvo.collect { it.cartas }.inject { acc, it -> acc + it })[0]

		return kickerAtual <=> kickerAlvo
	}

}
