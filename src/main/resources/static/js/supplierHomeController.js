(function () {
    'use strict';

    angular
        .module('app')
        .controller('supplierHomeController', supplierHomeController);

    supplierHomeController.$inject = ['$location','UserService', 'AuthenticationService', '$rootScope', 'FlashService'];
    function supplierHomeController($location,UserService,AuthenticationService, $rootScope, FlashService) {
        var vm = this;

        vm.user = null;
        vm.realUser = {};
        vm.allUsers = [];
        vm.deleteUser = deleteUser;

        
        vm.logout = logout;
        vm.biding = biding;
        vm.allOffers = allOffers;
        vm.supplierProfil = supplierProfil;
        
        (function initController() {
        	loadCurrentUser();
            loadAllUsers();
        })();

        function supplierProfil(){
        	
        	AuthenticationService.SetCredentials(vm.user.email, vm.user.password, "supplierProfil");
        	$location.path('/supplierProfil');
        }
        
        function biding(){
        	AuthenticationService.SetCredentials(vm.user.email, vm.user.password, "biding");
        	$location.path('/biding');
        }
        function allOffers(){
        	AuthenticationService.SetCredentials(vm.user.email, vm.user.password, "allOffers");
        	$location.path('/allOffers');
        }
        function logout(){
            AuthenticationService.ClearCredentials();
            $location.path('/login');
        }
        function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.email)
                .then(function (response) {
                    vm.user = response.data;
                });
        }
        
        
        
        
        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function deleteUser(id) {
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        }
    }

})();