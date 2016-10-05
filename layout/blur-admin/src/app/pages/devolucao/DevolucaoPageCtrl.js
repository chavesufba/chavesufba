(function () {
  'use strict';

  angular.module('BlurAdmin.pages.devolucao')
      .controller('DevolucaoPageCtrl', DevolucaoPageCtrl);

  /** @ngInject */
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

  // function VisualizarSalaPageCtrl($scope, $filter, $location, editableOptions, editableThemes, toastr) {



  //   $scope.get_sala = function(){
  //       $scope.id = $location.hash()
  //   }

  //   $scope.get_status_form = function(){
  //     $scope.disabledField = true; // desabilitar campo para edição
  //     $scope.nameButton = "Alterar Reserva"
  //   }

  //   $scope.update_reserva = function(){
  //     if ($scope.disabledField) {
  //       $scope.disabledField = false;
  //       $scope.nameButton = "Salvar Reserva"
  //     } else {
  //       $scope.disabledField = true;
  //       toastr.success('As informações foram salvas com sucesso!');
  //       $scope.nameButton = "Alterar Reserva"
  //     }
  //   }

  //   $scope.isDisabledDate = function(currentDate, mode) {
  //     return mode === 'day' && (currentDate.getDay() === 0 || currentDate.getDay() === 6);
  //   };

  // }

})();
