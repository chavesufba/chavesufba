(function () {
  'use strict';

  angular.module('BlurAdmin.pages.chave')
    .controller('ChavePageCtrl', ChavePageCtrl)
  
  /** @ngInject */

  function ChavePageCtrl($scope, $filter, $location, editableOptions, editableThemes) {
    return true;
  }

  function DevolucaoPageCtrl($scope, $filter, $location, editableOptions, editableThemes) {

    $scope.smartTableData = [
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 133,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      }
    ];

    $scope.redirect_relatorio = function ( id_sala ) {
        window.location.href = '#/devolucao/chave#' + String(id_sala);
    }

    $scope.salas = $scope.smartTableData.slice(0, 36);
    editableOptions.theme = 'bs3';
  }

  

  

      })();
