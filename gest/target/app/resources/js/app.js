/**
 * Arquivo que registra o módulo "main" do AngularJS.
 * Registra as dependências, exemplo: ngRoute, ngDialog, ngFileUpload
 * 
 * Define URL base para os web services.
 */
(function() {

	angular.module('AppGestionnaire', [ 'ngRoute', 'ngDialog', 'ngFileUpload', 'PhraseControllers' ]);

	angular.module('AppGestionnaire').constant("APP_CONFIG", {
		"API_REST" : "http://localhost:8080/gest/rest"
	});

	function Config($routeProvider) {
		$routeProvider.when('/', {
			controller : 'CarroListController',
			templateUrl : './pages/gestionnaire/list.html'
		}).otherwise({
			redirectTo : '/'
		});
	}

	angular.module('AppGestionnaire').config(Config);
}());