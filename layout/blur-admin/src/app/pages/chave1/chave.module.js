/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
    'use strict';

    angular.module('BlurAdmin.pages.chave', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('chave', {
                url: '/chave',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: 'Chave',
                sidebarMeta: {
                    icon: 'ion-key',
                    order: 300,
                },
            }).state('chave.chave', {
                url: '/chave',
                templateUrl: 'app/pages/chave/chave/chave.html',
                title: 'Chave',
                controller: 'ChavePageCtrl',
                sidebarMeta: {
                    order: 300,
                }
            }).state('chave.devolucao', {
                url: '/devolucao',
                templateUrl: 'app/pages/chave/devolucao/devolucao.html',
                title: 'Devolucao',
                controller: 'DevolucaoPageCtrl',
                sidebarMeta: {
                    order: 300,
                }
            }).state('chave.mail', {
                url: '/mail',
                templateUrl: 'app/pages/chave/mail/mail.html',
                title: 'Mail',
                controller: 'MailTabCtrl',
                sidebarMeta: {
                    order: 300,
                }
            });
        $urlRouterProvider.when('/chave', '/chave/buscar_chave');
    }

})();
