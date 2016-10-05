(function () {
  'use strict';

  angular.module('BlurAdmin.pages.sugestoes', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('sugestoes', {
          url: '/sugestoes',
          title: 'Sugestões',
          templateUrl: 'app/pages/sugestoes/sugestoes.html',
          controller: 'SugestoesPageCtrl',
          sidebarMeta: {
            icon: 'ion-ios-paperplane',
            order: 0,
          },
        });
  }

})();