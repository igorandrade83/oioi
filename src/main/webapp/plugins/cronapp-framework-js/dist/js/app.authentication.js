var cronappModules=["ui.router","ui.select","ui-select-infinity","ngResource","ngSanitize","custom.controllers","custom.services","datasourcejs","chart.js","ngJustGage","pascalprecht.translate","tmh.dynamicLocale","ui-notification","ui.bootstrap","ngFileUpload","report.services","upload.services","ui.tinymce"];window.customModules&&(cronappModules=cronappModules.concat(window.customModules));var app=function(){return angular.module("MyApp",cronappModules).constant("LOCALES",{locales:{pt_br:"Portugues (Brasil)",en_us:"English"},preferredLocale:"pt_br",urlPrefix:""}).config(["$httpProvider",function(e){var r=["$q","$rootScope",function(e,r){return{request:function(e){var r=JSON.parse(localStorage.getItem("_u"));return r&&r.token&&(e.headers["X-AUTH-TOKEN"]=r.token,window.uToken=r.token),e}}}];e.interceptors.push(r)}]).config(["$stateProvider","$urlRouterProvider","NotificationProvider",function(e,r,t){t.setOptions({delay:5e3,startTop:20,startRight:10,verticalSpacing:20,horizontalSpacing:20,positionX:"right",positionY:"top"}),window.customStateProvider?window.customStateProvider(e):e.state("login",{url:"",controller:"LoginController",templateUrl:"views/login.view.html"}).state("social",{url:"/connected",controller:"SocialController",templateUrl:"views/login.view.html"}).state("socialError",{url:"/notconnected",controller:"SocialController",templateUrl:"views/login.view.html"}).state("main",{url:"/",controller:"LoginController",templateUrl:"views/login.view.html"}).state("publicRoot",{url:"/public/{name:.*}",controller:"PageController",templateUrl:function(e){return"views/public/"+e.name+".view.html"}}).state("public",{url:"/home/public",controller:"PublicController",templateUrl:function(e){return"views/public/home.view.html"}}).state("public.pages",{url:"/{name:.*}",controller:"PageController",templateUrl:function(e){return"views/public/"+e.name+".view.html"}}).state("home",{url:"/home",controller:"HomeController",templateUrl:"views/logged/home.view.html"}).state("home.pages",{url:"/{name:.*}",controller:"PageController",templateUrl:function(e){return"views/"+e.name+".view.html"}}).state("404",{url:"/error/404",controller:"PageController",templateUrl:function(e){return"views/error/404.view.html"}}).state("403",{url:"/error/403",controller:"PageController",templateUrl:function(e){return"views/error/403.view.html"}}),r.otherwise("/error/404")}]).factory("originPath",["$location",function(e){return{request:function(r){return r.headers["origin-path"]=e.path(),r}}}]).config(["$httpProvider",function(e){e.interceptors.push("originPath")}]).config(["$translateProvider","tmhDynamicLocaleProvider",function(e,r){e.useMissingTranslationHandlerLog(),e.useLoader("customTranslateLoader",{files:[{prefix:"i18n/locale_",suffix:".json"},{prefix:"plugins/cronapp-framework-js/i18n/locale_",suffix:".json"}]}),e.registerAvailableLanguageKeys(window.translations.localesKeys,window.translations.localesRef);var t=(window.navigator.userLanguage||window.navigator.language||"pt_br").replace("-","_");e.use(t.toLowerCase()),e.useSanitizeValueStrategy("escaped"),r.localeLocationPattern("plugins/angular-i18n/angular-locale_{{locale}}.js"),moment&&moment.locale(t)}]).directive("crnValue",["$parse",function(e){return{restrict:"A",require:"^ngModel",link:function(r,t,o,n){var i;i=o.value?o.value:e(o.crnValue)(r),t.attr("data-evaluated",JSON.stringify(i)),t.bind("click",function(e){r.$apply(function(){n.$setViewValue(i)}.bind(t))})}}}]).decorator("$xhrFactory",["$delegate","$injector",function(e,r){return function(t,o){var n=e(t,o),i=r.get("$http"),a=i.pendingRequests[i.pendingRequests.length-1];return angular.isFunction(a.onProgress)&&n.upload.addEventListener("progress",a.onProgress),n}}]).controller("PageController",["$controller","$scope","$stateParams","$location","$http","$rootScope","$translate","Notification","UploadService",function(e,r,t,o,n,i,a,l,s){r.params=t,r.$http=n,r.Notification=l,r.UploadService=s,app.registerEventsCronapi(r,a);var c=o.search();for(var u in c)c.hasOwnProperty(u)&&(r.params[u]=c[u]);r.registerComponentScripts=function(){$(".carousel-indicators li").on("click",function(){var e="#"+$(this).parent().parent().parent().attr("id"),r=$(e+" .carousel-indicators li").index(this);$(e+" #carousel-example-generic").carousel(r)})},r.registerComponentScripts();try{var p=e("AfterPageController",{$scope:r});app.copyContext(p,this,"AfterPageController")}catch(e){}try{r.blockly.events.afterPageRender&&r.blockly.events.afterPageRender()}catch(e){}}]).run(["$rootScope","$state",function(e,r){e.$on("$stateChangeError",function(){if(arguments.length>=6){var e=arguments[5];404!==e.status&&403!==e.status||(localStorage.removeItem("_u"),r.go("login"))}else r.go("404")})}])}(window);app.userEvents={},app.config={},app.config.datasourceApiVersion=2,app.bindScope=function(e,r){var t={};for(var o in r)"string"==typeof r[o]?t[o]=r[o]:"function"==typeof r[o]?t[o]=r[o].bind(e):t[o]=app.bindScope(e,r[o]);return t},app.registerEventsCronapi=function(e,r){for(var t in app.userEvents)e[t]=app.userEvents[t].bind(e);e.vars={};try{cronapi&&(e.cronapi=app.bindScope(e,cronapi),e.cronapi.$scope=e,e.safeApply=safeApply,r&&(e.cronapi.$translate=r))}catch(e){console.info("Not loaded cronapi functions"),console.info(e)}try{blockly&&(e.blockly=app.bindScope(e,blockly))}catch(e){console.info("Not loaded blockly functions"),console.info(e)}},app.copyContext=function(e,r,t){if(e)for(var o in e)r[o]?r[o+t]=e[o]:r[o]=e[o]},app.factory("customTranslateLoader",["$http","$q",function(e,r){return function(t){if(!(t&&(angular.isArray(t.files)||angular.isString(t.prefix)&&angular.isString(t.suffix))))throw new Error("Couldn't load static files, no files and prefix or suffix specified!");t.files||(t.files=[{prefix:t.prefix,suffix:t.suffix}]);for(var o=r.defer(),n=[],i=t.files.length,a=0;a<i;a++)n.push(function(o){if(!o||!angular.isString(o.prefix)||!angular.isString(o.suffix))throw new Error("Couldn't load static file, no prefix or suffix specified!");var n=r.defer();return e(angular.extend({url:[o.prefix,t.key,o.suffix].join(""),method:"GET",params:""},t.$http)).success(function(e){n.resolve(e)}).error(function(){n.resolve({})}),n.promise}({prefix:t.files[a].prefix,key:t.key,suffix:t.files[a].suffix}));return r.all(n).then(function(e){for(var r=e.length,t={},n=0;n<r;n++)for(var i in e[n])t[i]=e[n][i];o.resolve(t)},function(e){o.reject(e)}),o.promise}}]),window.safeApply=function(e){var r=this.$root.$$phase;"$apply"==r||"$digest"==r?e&&"function"==typeof e&&e():this.$apply(e)};