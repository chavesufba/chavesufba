(function () {
  'use strict';

  angular.module('BlurAdmin.pages.devolucao', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('devolucao', {
          url: '/devolucao',
          title: 'Devolução',
          templateUrl: 'app/pages/devolucao/devolucao.html',
          controller: 'DevolucaoPageCtrl',
          sidebarMeta: {
            icon: 'ion-android-home',
            order: 0,
          },
        });
  }

})();