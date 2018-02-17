/**
 * Arquivo que mantém a lista o estado da lista de phrases. 
 */
(function() {

	angular.module('phraseService', []);
	
	function carro() {
		// lista de carros
		var carros = [];

		function setCarros(carros) {
			this.carros = carros;
		}
		
		function getCarros() {
			return this.carros;
		}
		
		return {
			carros: carros,
			set : setCarros,
			get : getCarros
		}
	}
	
	angular.module('phraseService').factory('phraseService', carro);
}());