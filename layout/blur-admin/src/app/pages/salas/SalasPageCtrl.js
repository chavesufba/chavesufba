(function () {
    'use strict';

    angular.module('BlurAdmin.pages.salas')
        .controller('BuscarSalasPageCtrl', BuscarSalasPageCtrl)
        .controller('VisualizarSalaPageCtrl', VisualizarSalaPageCtrl)
        .controller('CadastrarSalaPageCtrl', CadastrarSalaPageCtrl)
        .controller('ReservarSalaPageCtrl', CadastrarSalaPageCtrl);

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
        numero: 143,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 123,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 144,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 145,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 146,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      },
      {
        numero: 147,
        local: 'IM',
        tipo: 'Laboratório',
        cadeiras: 40,
      }
    ];


    $scope.redirect_relatorio = function (id_sala) {
        window.location.href = '#/salas/visualizar_sala#' + String(id_sala);
    }

    $scope.salas = $scope.smartTableData.slice(0, 36);
        editableOptions.theme = 'bs3';
    }

    function VisualizarSalaPageCtrl($scope, $filter, $location, editableOptions, editableThemes, toastr) {


        $scope.get_sala = function () {
            $scope.id = $location.hash()
        }

        $scope.get_status_form = function () {
            $scope.disabledField = true; // desabilitar campo para edição
            $scope.nameButton = "Alterar Reserva"
        }

        $scope.update_reserva = function(){
          if ($scope.disabledField) {
            $scope.disabledField = false;
            $scope.nameButton = "Salvar Reserva"
          } else {
            $scope.disabledField = true;
            toastr.success('As informações foram salvas com sucesso!');
            $scope.nameButton = "Alterar Reserva";
            window.location.href = '#/salas/buscar_salas';
          }
        }

        $scope.cancel_reserva = function(){
          toastr.success('Reserva cancelada com sucesso!');
          window.location.href = '#/salas/buscar_salas'
        }
    }



    function CadastrarSalaPageCtrl($scope, $filter, $location, editableOptions, editableThemes, toastr) {
        return true;
    }

    function ReservarSalaPageCtrl($scope, $filter, $location, editableOptions, editableThemes, toastr) {
        
    }

})();
