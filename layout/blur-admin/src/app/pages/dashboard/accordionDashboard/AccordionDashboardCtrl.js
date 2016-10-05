/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.dashboard')
      .controller('AccordionDashboardCtrl', AccordionDashboardCtrl);

  /** @ngInject */
  function AccordionDashboardCtrl($scope, baConfig) {
      $scope.accordionData = [
          {
              titulo: "IME - Sala 143",
              descricao: "Cabos de rede partidos."
          },
          {
              titulo: "PAF 3 - Auditório",
              descricao: "Ar condionado com defeito."
          },
          {
              titulo: "PAF 1 - Sala 212",
              descricao: "Ventilador muito sujo.."
          },
          {
              titulo: "PAF 1 - Sala 12",
              descricao: "Janela quebrada.."
          }
         ];
  }
    
})();
