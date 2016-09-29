/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.salas', [])
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('salas', {
          url: '/salas',
          template : '<ui-view></ui-view>',
          abstract: true,
          title: 'Salas',
          sidebarMeta: {
            icon: 'ion-ios-book',
            order: 300,
          },
	  }).state('salas.buscar_salas', {
          url: '/buscar_salas',
          templateUrl: 'app/pages/salas/buscar_salas/buscar_salas.html',
          title: 'Buscar Salas',
          controller: 'BuscarSalasPageCtrl',
          sidebarMeta: {
            order: 300,
          },
      }).state('salas.visualizar_sala', {
          url: '/visualizar_sala',
          templateUrl: 'app/pages/salas/visualizar_sala/visualizar_sala.html',
          title: 'Visualizar Sala',
          controller: 'VisualizarSalaPageCtrl'
        });
    $urlRouterProvider.when('/salas','/salas/buscar_salas');
  }

})();
