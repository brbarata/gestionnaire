/**
 * Controller responsável pelo distribuição das funcionalidades do sistema.
 */
(function() {
	angular
		.module('PhraseControllers', ['phraseRestService', 'phraseService']);
	
	var tipo = [{
		tipo: "Classico",
		id: "classicos"
	}, 
	{
		tipo: "Esportivo",
		id: "esportivos"
	},
	{
		tipo: "Luxo",
		id: "luxo"
	}]
	
	var CARROS_CONFIG = {
		tipo: tipo
	}
	
	angular
		.module('PhraseControllers')
		.constant("CARROS_CONFIG", CARROS_CONFIG);
	
	angular
		.module('PhraseControllers')
		.controller("CarroFiltroController", CarroFiltroController);

	function CarroFiltroController($scope, ngDialog, phraseRestService, phraseService) {
		$scope.carroService = phraseService;
		$scope.findCarroByNome = function () {
			if($scope.nome) {
				var $promise = phraseRestService.searchByNome($scope.nome);
				$promise.success(function(response, status) {
					if(status == 204) {
						//$scope.phraseService.carros = null;
					}
					phraseService.set(response);
					$scope.carroService = phraseService;
					console.log("PHRASES: ", $scope.carroService.carros);
				});
				return;
			}
			var $promise = phraseRestService.findAll();
			$promise.success(function(response) {
				$scope.phraseService.carros = response;
			});
		};
		
		$scope.findPhraseByStatus = function () {
			if($scope.inactive) {
				var $promise = phraseRestService.searchByStatus($scope.inactive);
				console.log('SCOPE:', $scope);
				$promise.success(function(response, status) {
					if(status == 204) {
						//$scope.phraseService.carros = null;
					}
					phraseService.set(response);
					$scope.carroService = phraseService;
				});
				return;
			}
			var $promise = phraseRestService.findAll();
			$promise.success(function(response) {
			//	$scope.phraseService.carros = response;
			});
		};
	}
	
	angular
		.module('PhraseControllers')
		.controller('CarroListController', CarroListController);
	
	function CarroListController($scope, ngDialog, phraseRestService, phraseService) {
		$scope.carroService = phraseService;
		$scope.tab = 0;
		
		$scope.deletarCarro = function(carro) {
			$scope.carro = carro;
			ngDialog.open({ 
				template: './pages/gestionnaire/modal.confirm.html',
				scope: $scope,
				showClose: false,
				closeByEscape: false,
				closeByDocument : false
			});
		}
		
		$scope.confirmDeletar = function() {
			phraseRestService.delete($scope.carro).success(function() {
				ngDialog.closeAll();
				ngDialog.open({
					template:'\
						<p>Carro deletado com sucesso</p>\
		                <div class="ngdialog-buttons">\
		                    <button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="closeThisDialog(0)">OK</button>\
		                    \</div>',
		            plain: true
				});
				$scope.carro = null;
				carregarCarros();
			});
		}
		
		$scope.openModalEditar = function(carro) {
			ngDialog.open({ 
				template: './pages/gestionnaire/modal.form.html',
				showClose: false,
		        closeByDocument: false,
		        closeByEscape: false,
		        controller: 'PhraseEditController',
		        resolve: {
		            carro: function() {
		                return carro;
		            }
		        }
			});
		}
		
		var carregarCarros = function() {
			var $promise = phraseRestService.findAll();
			$promise.success(function(response) {
			//	$scope.carroService.carros = response;
			});
		}
		carregarCarros();

		$scope.changeFilter = function(tipo, tab) {
			$scope.tab = tab;
			if(tipo) {
				var $promise = phraseRestService.findByTipo(tipo);
				$promise.success(function(response) {
					//$scope.prhaseService.carros = response;
				});
				return;
			}
			carregarCarros();
		}
	}
	
	
	
	angular
		.module('PhraseControllers')
		.controller('CarroNewController', CarroNewController);
	function CarroNewController($scope, $window, ngDialog, phraseRestService, CARROS_CONFIG, Upload) {
		$scope.tipos = CARROS_CONFIG.tipo;
		$scope.carro = {};
		$scope.openModalCadasro = function() {
			ngDialog.open({ 
				template: './pages/gestionnaire/modal.form.html',
				scope: $scope,
				showClose: false,
		        closeByDocument: false,
		        closeByEscape: false
			});
		}
		
		$scope.upload = function(file) {
			if(file) {
				$scope.progress = true;
				$scope.progressFoto = true;
				var $promise = phraseRestService.uploadFoto(file);
	    		$promise.success(function(response) {
	    			if(response.status == 'OK') {
	    				$scope.carro.urlFoto = response.url;
	    				$scope.progress = false;
	    				$scope.progressFoto = false;
	    				return;
	    			}
	    			console.log($scope.carro.urlFoto);
	    			alert("Não foi possível realizar o upload do arquivo. Verifique se configurou todos os dados do Bucket do Google corretamente. ");
	    		});
			}
		}
		
	    $scope.salvar = function (carro) {
	    	var $promise = carroRestService.save(carro);
			console.log("AAA", $scope.carro.urlFoto);

    		$promise.success(function() {
    			$scope.progress = false;
    			$window.location.reload();
    		});
	    };
	}
	angular
		.module('PhraseControllers')
		.controller('PhraseEditController', PhraseEditController);
	
	function PhraseEditController($scope, $window, ngDialog, carroRestService, CARROS_CONFIG, carro) {
		$scope.carro = carro;
		$scope.tipos = CARROS_CONFIG.tipo;
		$scope.upload = function(file) {
			if(file) {
				$scope.progress = true;
				$scope.progressFoto = true;
				var $promise = carroRestService.uploadFoto(file);
	    		$promise.success(function(response) {
	    			if(response.status == 'OK') {
	    				$scope.carro.urlFoto = response.url;
	    				$scope.progress = false;
	    				$scope.progressFoto = false;
	    				return;
	    			}
    				console.log("AAA", $scope.carro.urlFoto);
	    			alert("Não foi possível realiazr o upload do arquivo. Verifique se configurou todos os dados do Bucket do Google corretamente.");
	    		});
			}
		}
		
	    $scope.salvar = function (carro) {
	    	var $promise = carroRestService.save(carro);
    		$promise.success(function() {
    			$scope.progress = false;
    			$window.location.reload();
    		});
	    };
	}
} ());