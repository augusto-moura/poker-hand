package zg.augusto.dominio

enum ValorCarta {

	DOIS('2'),
	TRES('3'),
	QUATRO('4'),
	CINCO('5'),
	SEIS('6'),
	SETE('7'),
	OITO('8'),
	NOVE('9'),
	DEZ('T'),
	VALETE('J'),
	RAINHA('Q'),
	REI('K'),
	AS('A'),

	final String codigo

	ValorCarta(String codigo) {
		this.codigo = codigo
	}

	static ValorCarta encontrarPorCodigo(String codigo) {
		return values().find { ValorCarta it -> it.codigo == codigo }
	}

}
