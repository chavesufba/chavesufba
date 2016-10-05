/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
    'use strict';

    angular.module('BlurAdmin.pages.cadastrar', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('cadastrar', {
                url: '/cadastrar',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: 'Cadastrar',
                sidebarMeta: {
                    icon: 'ion-ios-compose',
                    order: 300,
                },
            }).state('cadastrar.cadastrar_usuario', {
                url: '/cadastrar_usuario',
                templateUrl: 'app/pages/cadastrar/cadastrar_usuario.html',
                title: 'Cadastrar Usuario',
                controller: 'CadastrarPageCtrl',
                sidebarMeta: {
                    icon: 'ion-ios-list-outline',
                    order: 300,
              },
        });
    }

})();
