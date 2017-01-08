'use strict';

/**
 * @ngdoc overview
 * @name newsClientApp
 * @description
 * # newsClientApp
 *
 * Main module of the application.
 */
angular
  .module('newsClientApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'RESTService'
  ]).config(['$locationProvider', function($locationProvider) {
    $locationProvider.hashPrefix('');
  }])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'newsCrtl',
        controllerAs: 'newsDashBoard'
      })
      .when('/add',{
        templateUrl: 'views/add.html',
        controller: 'newsCrtl',
        controllerAs: 'newsDashBoard'
      })
      .when('/displayNews/:id', {
        templateUrl: 'views/display.html',
        controller: 'newsDisplayCtrl',
        controllerAs: 'displayDash'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
