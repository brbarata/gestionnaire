/**
 * Arquivo que mantém a lista o estado da lista de expressions. 
 */
(function() {

	angular.module('expressionService', []);
	
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
	
	angular.module('expressionService').factory('expressionService', carro);
}());