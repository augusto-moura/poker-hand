package zg.augusto.dominio

class Carta implements Comparable<Carta> {

	final Naipe naipe
	final ValorCarta valor

	Carta(Naipe naipe, ValorCarta valor) {
		this.naipe = naipe
		this.valor = valor
	}

	Carta(String carta) {
		def (String valor, String naipe) = carta.toCharArray()

		this.naipe = Naipe.encontrarPorCodigo(naipe)
		this.valor = ValorCarta.encontrarPorCodigo(valor)
	}

	static Carta[] fromString(final String strMao) {
		return strMao.split(/\s/).collect({ new Carta(it) })
	}

	@Override
	int compareTo(Carta o) {
		int valorCarta = this.valor <=> o.valor;
		return valorCarta == 0 ? (this.naipe <=> o.naipe) : valorCarta
	}

	@Override
	String toString() {
		return "$valor.codigo$naipe.codigo"
	}
}
