(function () {
  'use strict';

  angular.module('BlurAdmin.pages.salas')
      .controller('BuscarSalasPageCtrl', BuscarSalasPageCtrl)
      .controller('VisualizarSalaPageCtrl', VisualizarSalaPageCtrl);

  /** @ngInject */
  function BuscarSalasPageCtrl($scope, $filter, $location, editableOptions, editableThemes) {

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
        window.location.href = '#/salas/visualizar_sala#' + String(id_sala);
    }

    $scope.salas = $scope.smartTableData.slice(0, 36);
    editableOptions.theme = 'bs3';
  }

  function VisualizarSalaPageCtrl($scope, $filter, $location, editableOptions, editableThemes) {

    $scope.get_sala = function(){
        $scope.id = $location.hash()
    }

  }

})();
