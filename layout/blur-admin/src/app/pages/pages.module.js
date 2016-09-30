/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages', [
    'ui.router',

    'BlurAdmin.pages.dashboard',
    //'BlurAdmin.pages.ui',
    //'BlurAdmin.pages.form',
    //'BlurAdmin.pages.tables',
    //'BlurAdmin.pages.charts',
    'BlurAdmin.pages.profile',
    'BlurAdmin.pages.salas',
    'BlurAdmin.pages.devolucao'
  ])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($urlRouterProvider, baSidebarServiceProvider) {
    $urlRouterProvider.otherwise('/dashboard');

    baSidebarServiceProvider.addStaticItem({
      title: 'Conta',
      icon: 'ion-document',
      subMenu: [{
        title: 'Perfil',
        stateRef: 'profile'
      }]
    });
  }

})();
