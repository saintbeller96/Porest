(function(e){function n(n){for(var r,o,a=n[0],i=n[1],l=n[2],d=0,s=[];d<a.length;d++)o=a[d],Object.prototype.hasOwnProperty.call(c,o)&&c[o]&&s.push(c[o][0]),c[o]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(e[r]=i[r]);f&&f(n);while(s.length)s.shift()();return u.push.apply(u,l||[]),t()}function t(){for(var e,n=0;n<u.length;n++){for(var t=u[n],r=!0,o=1;o<t.length;o++){var a=t[o];0!==c[a]&&(r=!1)}r&&(u.splice(n--,1),e=i(i.s=t[0]))}return e}var r={},o={app:0},c={app:0},u=[];function a(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-2d0bd52d":"7a50d909","chunk-2d0c76f1":"4f67389e","chunk-2d0cc628":"9c360223","chunk-2d0cfcd5":"2169a4d5","chunk-2d0e17a2":"95a6bb09","chunk-789b01c0":"1a6755b3","chunk-b13c1238":"53df36e1","chunk-e83d6788":"700bff22"}[e]+".js"}function i(n){if(r[n])return r[n].exports;var t=r[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,i),t.l=!0,t.exports}i.e=function(e){var n=[],t={"chunk-789b01c0":1,"chunk-b13c1238":1,"chunk-e83d6788":1};o[e]?n.push(o[e]):0!==o[e]&&t[e]&&n.push(o[e]=new Promise((function(n,t){for(var r="css/"+({}[e]||e)+"."+{"chunk-2d0bd52d":"31d6cfe0","chunk-2d0c76f1":"31d6cfe0","chunk-2d0cc628":"31d6cfe0","chunk-2d0cfcd5":"31d6cfe0","chunk-2d0e17a2":"31d6cfe0","chunk-789b01c0":"611d329b","chunk-b13c1238":"868b9f3e","chunk-e83d6788":"c16eb4a4"}[e]+".css",c=i.p+r,u=document.getElementsByTagName("link"),a=0;a<u.length;a++){var l=u[a],d=l.getAttribute("data-href")||l.getAttribute("href");if("stylesheet"===l.rel&&(d===r||d===c))return n()}var s=document.getElementsByTagName("style");for(a=0;a<s.length;a++){l=s[a],d=l.getAttribute("data-href");if(d===r||d===c)return n()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=n,f.onerror=function(n){var r=n&&n.target&&n.target.src||c,u=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");u.code="CSS_CHUNK_LOAD_FAILED",u.request=r,delete o[e],f.parentNode.removeChild(f),t(u)},f.href=c;var m=document.getElementsByTagName("head")[0];m.appendChild(f)})).then((function(){o[e]=0})));var r=c[e];if(0!==r)if(r)n.push(r[2]);else{var u=new Promise((function(n,t){r=c[e]=[n,t]}));n.push(r[2]=u);var l,d=document.createElement("script");d.charset="utf-8",d.timeout=120,i.nc&&d.setAttribute("nonce",i.nc),d.src=a(e);var s=new Error;l=function(n){d.onerror=d.onload=null,clearTimeout(f);var t=c[e];if(0!==t){if(t){var r=n&&("load"===n.type?"missing":n.type),o=n&&n.target&&n.target.src;s.message="Loading chunk "+e+" failed.\n("+r+": "+o+")",s.name="ChunkLoadError",s.type=r,s.request=o,t[1](s)}c[e]=void 0}};var f=setTimeout((function(){l({type:"timeout",target:d})}),12e4);d.onerror=d.onload=l,document.head.appendChild(d)}return Promise.all(n)},i.m=e,i.c=r,i.d=function(e,n,t){i.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,n){if(1&n&&(e=i(e)),8&n)return e;if(4&n&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(i.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var r in e)i.d(t,r,function(n){return e[n]}.bind(null,r));return t},i.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(n,"a",n),n},i.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},i.p="/",i.oe=function(e){throw console.error(e),e};var l=window["webpackJsonp"]=window["webpackJsonp"]||[],d=l.push.bind(l);l.push=n,l=l.slice();for(var s=0;s<l.length;s++)n(l[s]);var f=d;u.push([0,"chunk-vendors"]),t()})({0:function(e,n,t){e.exports=t("56d7")},"56d7":function(e,n,t){"use strict";t.r(n);t("e260"),t("e6cf"),t("cca6"),t("a79d");var r=t("2b0e"),o=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{attrs:{id:"app"}},[t("div",{attrs:{id:"nav"}},[t("router-link",{attrs:{to:"/"}},[e._v("메인페이지")]),e._v(" | "),t("router-link",{attrs:{to:"/login"}},[e._v("로그인")]),e._v(" | "),t("router-link",{attrs:{to:"/signup"}},[e._v("회원가입")]),e._v(" | "),t("router-link",{attrs:{to:"/auth"}},[e._v("디자인 적용")])],1),t("router-view")],1)},c=[],u=t("2877"),a={},i=Object(u["a"])(a,o,c,!1,null,"17fd75c4",null),l=i.exports,d=(t("d3b7"),t("3ca3"),t("ddb0"),t("8c4f"));r["a"].use(d["a"]);var s=[{path:"/",redirect:"/main"},{path:"/main",name:"Main",component:function(){return t.e("chunk-2d0cfcd5").then(t.bind(null,"64ef"))}},{path:"/login",name:"Login",component:function(){return t.e("chunk-789b01c0").then(t.bind(null,"9905"))}},{path:"/signup",name:"Signup",component:function(){return t.e("chunk-e83d6788").then(t.bind(null,"ce61"))}},{path:"/auth",name:"Auth",component:function(){return t.e("chunk-2d0e17a2").then(t.bind(null,"7b34"))}},{path:"/mailbox",name:"Mailbox",component:function(){return t.e("chunk-2d0c76f1").then(t.bind(null,"5132"))}},{path:"/mailbox/letters",name:"WriteLetter",component:function(){return t.e("chunk-2d0bd52d").then(t.bind(null,"2c06"))}},{path:"/mailbox/my-mailbox",name:"MyMailbox",component:function(){return t.e("chunk-b13c1238").then(t.bind(null,"ea5f"))}},{path:"/mailbox/my-mailbox/letter-detail",name:"LetterDetail",component:function(){return t.e("chunk-2d0cc628").then(t.bind(null,"4e67"))}}],f=new d["a"]({mode:"history",base:"/",routes:s}),m=f,p=t("2f62");t("ac1f"),t("5319");function h(e){document.cookie="login_id=".concat(e)}function b(e){document.cookie="login_username=".concat(e)}function k(e){document.cookie="login_email=".concat(e)}function g(e){document.cookie="login_token=".concat(e)}function v(e){document.cookie="login_img=".concat(e)}function y(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/,"$1")}function _(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_username\s*=\s*([^;]*).*$)|^.*$/,"$1")}function w(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/,"$1")}function x(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/,"$1")}function $(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/,"$1")}var O={id:y()||"",email:w()||"",username:_()||"",token:$()?"Token ".concat($()):"",profileImg:x()||""},j=t("94d5"),T=t.n(j),E={setUserId:function(e,n){e.id=n},setUsername:function(e,n){e.username=n},setUserEmail:function(e,n){e.email=n},setToken:function(e,n){e.token="Token ".concat(n)},setImg:function(e,n){e.profileImg=n}},S=t("1da1"),L=(t("96cf"),{LOGOUT:function(e){return Object(S["a"])(regeneratorRuntime.mark((function n(){var t;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:t=e.commit,t("setUserId",""),t("setUsername",""),t("setUserEmail",""),t("setToken",""),t("setUserLocation",""),t("setImg",""),h(""),b(""),k(""),g(""),v("");case 12:case"end":return n.stop()}}),n)})))()}});r["a"].use(p["a"]);var P=new p["a"].Store({state:O,getters:T.a,mutations:E,actions:L,modules:{}});r["a"].config.productionTip=!1,new r["a"]({router:m,store:P,render:function(e){return e(l)}}).$mount("#app")},"94d5":function(e,n){}});
//# sourceMappingURL=app.d0e1e0da.js.map