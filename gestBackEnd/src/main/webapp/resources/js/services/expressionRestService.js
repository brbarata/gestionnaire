/**
 * API para acessar os web services REST das expressions
 */
(function() {
	angular
		.module('expressionRestService', []);
	
	expressionRestService = function($http, Upload, APP_CONFIG) {
		var urlApi = APP_CONFIG.API_REST + '/gestionnaire/phrases';

		function findAll() {
			return $http.get(this.api);
		}
		
		function save(carro) {
			if(carro.id) {
				return $http.put(this.api, carro);
			}
			return $http.post(this.api, carro);
		}
		
		function find(id) {
			return $http.get(this.api + '/' + id);
		}
		
		function deleteCarro(carro, file) {
			return $http.delete(this.api + '/' + carro.id);
		}
		
		function uploadFoto(file) {
			return Upload.upload({
                url: this.api,
                file: file
            });
		}
		
//		function findByTipo(tipo) {
//			return $http.get(this.api + '/tipo/' + tipo);
//		}
//		
//		function findByNome(nome) {
//			return $http.get(this.api + '/nome/' + nome);
//		}
//		
//		function searchByNome(nome) {
//			return $http.get(this.api + '/nome/' + nome);
//		}
		
		function findByDescricao(descricao) {
			return $http.get(this.api + '/descricao/' + descricao);
		}
		
		function searchByDescricao(descricao) {
			return $http.get(this.api + '/descricao/' + descricao);
		}
		
		function searchByStatus(status) {
			return $http.get(this.api + '/status/' + status);
		}
		
		return {
			api: urlApi,
			save: save,
			findAll: findAll,
			find: find,
			findByNome: findByDescricao,
			delete: deleteCarro,
			searchByNome: searchByDescricao,
			searchByStatus: searchByStatus,

			uploadFoto: uploadFoto
		}
	}
	angular
		.module('expressionRestService')
		.service('expressionRestService', expressionRestService);
} ());