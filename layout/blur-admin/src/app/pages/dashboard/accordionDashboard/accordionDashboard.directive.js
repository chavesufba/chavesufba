/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.dashboard')
      .directive('accordionDashboard', accordionDashboard);

  /** @ngInject */
  function accordionDashboard() {
    return {
      restrict: 'E',
      controller: 'AccordionDashboardCtrl',
      templateUrl: 'app/pages/dashboard/accordionDashboard/accordionDashboard.html'
    };
  }
})();
