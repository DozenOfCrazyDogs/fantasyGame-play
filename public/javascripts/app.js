/**
 * Created by НОЗДОРМУ on 23.07.2016.
 */
(function(angular) {
    'use strict';
    angular.module('ngIndexApp', ['ngAnimate'])
        .controller('ExampleController', ['$scope', '$http', '$timeout', function($scope, $http, $timeout) {

            // DEFAULTS INIT AND GLOBAL VARIABLES
            $scope.loggingPage = true;
            $scope.mainFrame = false;
            $scope.username = "";
            $scope.healthBarSizePlayer = {
                width: '100%'
            };
            $scope.healthBarSizeBoss = {
                width: '100%'
            };
            $scope.fireBallAction = true;
            $scope.defendAction = true;
            $scope.attackAction = true;
            $scope.mainData = {};

            // INIT GET METHOD
            var getInitDate = function(){
                $http({
                    method: 'GET',
                    url: '/initGame'
                }).then(function successCallback(response) {
                    $scope.mainData = response.data;
                }, function errorCallback(response) {
                    alert( "failure message: " + JSON.stringify({data: response}));
                });
            };

            // ATTACK METHOD
            var attackPost = function(){
                $http({
                    method: 'POST',
                    url: '/heroTurn',
                    data: {"actionName" : 'attack',
                            "target" : 'enemy'
                    }
                }).then(function successCallback(response) {
                    $scope.mainData = response.data;
                    healthBarCount();
                }, function errorCallback(response) {
                    alert( "failure message: " + JSON.stringify({data: response}));
                });
            };

            // HEALTH BAR COUNTING
            var healthBarCount = function() {
                $scope.enemyBarLength = (100/$scope.mainData.enemy.maxHealth)*$scope.mainData.enemy.currentHealth;
                $scope.heroBarLength = (100/$scope.mainData.hero.maxHealth)*$scope.mainData.hero.currentHealth;
                $scope.healthBarSizeBoss = {
                    width : $scope.enemyBarLength+"%"
                };
                $scope.healthBarSizePlayer = {
                    width : $scope.heroBarLength+"%"
                };
            };

            // LOGGING BUTTON
            $scope.logIn = function(){
                getInitDate();
                if ($scope.username==""){
                    alert("Enter a username!");
                } else {
                    $scope.loggingPage = false;
                    $scope.mainFrame = true;
                }
            };

            $scope.fireBall = function() {
                $scope.fireBallAction = false;
                $timeout(function(){
                    $scope.fireBallAction = true;
                }, 1000);
            };

            $scope.attack = function() {
                attackPost();
                /*$scope.attackAction = false;
                $timeout(function(){
                    $scope.attackAction = true;
                }, 1000);*/
            }

        }]);

})(window.angular);