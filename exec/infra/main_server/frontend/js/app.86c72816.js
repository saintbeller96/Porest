(function(n){function e(e){for(var c,r,u=e[0],i=e[1],f=e[2],s=0,d=[];s<u.length;s++)r=u[s],Object.prototype.hasOwnProperty.call(o,r)&&o[r]&&d.push(o[r][0]),o[r]=0;for(c in i)Object.prototype.hasOwnProperty.call(i,c)&&(n[c]=i[c]);h&&h(e);while(d.length)d.shift()();return a.push.apply(a,f||[]),t()}function t(){for(var n,e=0;e<a.length;e++){for(var t=a[e],c=!0,r=1;r<t.length;r++){var u=t[r];0!==o[u]&&(c=!1)}c&&(a.splice(e--,1),n=i(i.s=t[0]))}return n}var c={},r={app:0},o={app:0},a=[];function u(n){return i.p+"js/"+({}[n]||n)+"."+{"chunk-04605efa":"3122ffa9","chunk-09655e21":"a7822641","chunk-1f46150e":"09287935","chunk-26347e98":"a3a5d13a","chunk-096196c9":"80b1687b","chunk-2aaafce6":"acfc390a","chunk-43248cd1":"a67c07c6","chunk-284c59b5":"1f6aa27e","chunk-2d0ba4c9":"fd77900c","chunk-2d0c76f1":"2eda9b67","chunk-2d0cfcd5":"806f3fd9","chunk-339a19a3":"51d698fc","chunk-343b74a6":"b967c625","chunk-385749fb":"18937288","chunk-3f127a9a":"adf61a27","chunk-4c60840a":"85f29ba9","chunk-5384c96e":"a429570d","chunk-5683ef42":"372927f5","chunk-5b5e1cf4":"8e0112bf","chunk-5c535ecc":"86086052","chunk-6099f35c":"be8dc62a","chunk-61670627":"29fc9dfd","chunk-62e04e57":"a5a892f4","chunk-764cbc65":"cdaff1df","chunk-97de0c14":"5b34be32","chunk-efcdcd6a":"978aeb3c"}[n]+".js"}function i(e){if(c[e])return c[e].exports;var t=c[e]={i:e,l:!1,exports:{}};return n[e].call(t.exports,t,t.exports,i),t.l=!0,t.exports}i.e=function(n){var e=[],t={"chunk-04605efa":1,"chunk-09655e21":1,"chunk-1f46150e":1,"chunk-26347e98":1,"chunk-096196c9":1,"chunk-2aaafce6":1,"chunk-43248cd1":1,"chunk-284c59b5":1,"chunk-339a19a3":1,"chunk-343b74a6":1,"chunk-385749fb":1,"chunk-3f127a9a":1,"chunk-4c60840a":1,"chunk-5384c96e":1,"chunk-5683ef42":1,"chunk-5b5e1cf4":1,"chunk-5c535ecc":1,"chunk-6099f35c":1,"chunk-61670627":1,"chunk-62e04e57":1,"chunk-764cbc65":1,"chunk-97de0c14":1,"chunk-efcdcd6a":1};r[n]?e.push(r[n]):0!==r[n]&&t[n]&&e.push(r[n]=new Promise((function(e,t){for(var c="css/"+({}[n]||n)+"."+{"chunk-04605efa":"0a607f3d","chunk-09655e21":"a0bb8002","chunk-1f46150e":"f88f60f2","chunk-26347e98":"1bfd45a9","chunk-096196c9":"01695bdf","chunk-2aaafce6":"1aec22db","chunk-43248cd1":"a54b4701","chunk-284c59b5":"3bdae0cf","chunk-2d0ba4c9":"31d6cfe0","chunk-2d0c76f1":"31d6cfe0","chunk-2d0cfcd5":"31d6cfe0","chunk-339a19a3":"1c7218c0","chunk-343b74a6":"98391270","chunk-385749fb":"1340bd28","chunk-3f127a9a":"09f54e86","chunk-4c60840a":"fcfae90d","chunk-5384c96e":"7fae1151","chunk-5683ef42":"c93a580d","chunk-5b5e1cf4":"70f5e84c","chunk-5c535ecc":"bc7ef383","chunk-6099f35c":"bb9ab66f","chunk-61670627":"3ef66df6","chunk-62e04e57":"25d25d12","chunk-764cbc65":"55441276","chunk-97de0c14":"c7a8e657","chunk-efcdcd6a":"2bba4f6c"}[n]+".css",o=i.p+c,a=document.getElementsByTagName("link"),u=0;u<a.length;u++){var f=a[u],s=f.getAttribute("data-href")||f.getAttribute("href");if("stylesheet"===f.rel&&(s===c||s===o))return e()}var d=document.getElementsByTagName("style");for(u=0;u<d.length;u++){f=d[u],s=f.getAttribute("data-href");if(s===c||s===o)return e()}var h=document.createElement("link");h.rel="stylesheet",h.type="text/css",h.onload=e,h.onerror=function(e){var c=e&&e.target&&e.target.src||o,a=new Error("Loading CSS chunk "+n+" failed.\n("+c+")");a.code="CSS_CHUNK_LOAD_FAILED",a.request=c,delete r[n],h.parentNode.removeChild(h),t(a)},h.href=o;var l=document.getElementsByTagName("head")[0];l.appendChild(h)})).then((function(){r[n]=0})));var c=o[n];if(0!==c)if(c)e.push(c[2]);else{var a=new Promise((function(e,t){c=o[n]=[e,t]}));e.push(c[2]=a);var f,s=document.createElement("script");s.charset="utf-8",s.timeout=120,i.nc&&s.setAttribute("nonce",i.nc),s.src=u(n);var d=new Error;f=function(e){s.onerror=s.onload=null,clearTimeout(h);var t=o[n];if(0!==t){if(t){var c=e&&("load"===e.type?"missing":e.type),r=e&&e.target&&e.target.src;d.message="Loading chunk "+n+" failed.\n("+c+": "+r+")",d.name="ChunkLoadError",d.type=c,d.request=r,t[1](d)}o[n]=void 0}};var h=setTimeout((function(){f({type:"timeout",target:s})}),12e4);s.onerror=s.onload=f,document.head.appendChild(s)}return Promise.all(e)},i.m=n,i.c=c,i.d=function(n,e,t){i.o(n,e)||Object.defineProperty(n,e,{enumerable:!0,get:t})},i.r=function(n){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(n,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(n,"__esModule",{value:!0})},i.t=function(n,e){if(1&e&&(n=i(n)),8&e)return n;if(4&e&&"object"===typeof n&&n&&n.__esModule)return n;var t=Object.create(null);if(i.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:n}),2&e&&"string"!=typeof n)for(var c in n)i.d(t,c,function(e){return n[e]}.bind(null,c));return t},i.n=function(n){var e=n&&n.__esModule?function(){return n["default"]}:function(){return n};return i.d(e,"a",e),e},i.o=function(n,e){return Object.prototype.hasOwnProperty.call(n,e)},i.p="/",i.oe=function(n){throw console.error(n),n};var f=window["webpackJsonp"]=window["webpackJsonp"]||[],s=f.push.bind(f);f.push=e,f=f.slice();for(var d=0;d<f.length;d++)e(f[d]);var h=s;a.push([0,"chunk-vendors"]),t()})({0:function(n,e,t){n.exports=t("56d7")},"17e1":function(n,e,t){"use strict";var c=t("260b"),r=(t("e71f"),{apiKey:"AIzaSyCY-UrWAhIekYvrVfrdMLpX9hXuStFDG6o",authDomain:"frontend-69a53.firebaseapp.com",projectId:"frontend-69a53",storageBucket:"frontend-69a53.appspot.com",messagingSenderId:"566533900429",appId:"1:566533900429:web:1f6d6c09f2461d8a09fac4s"}),o=c["a"].initializeApp(r);e["a"]=o.firestore()},"365c":function(n,e,t){"use strict";t.d(e,"a",(function(){return i})),t.d(e,"b",(function(){return f}));t("99af");var c=t("bc3a"),r=t.n(c),o=(t("d3b7"),t("4360"));function a(n){return n.interceptors.request.use((function(n){return n.headers.Authorization=o["a"].state.token,n}),(function(n){return Promise.reject(n)})),n.interceptors.response.use((function(n){return n}),(function(n){return Promise.reject(n)})),n}var u=function(n){return r.a.create({baseURL:"".concat("https://porest.kr").concat(n)})},i=u("/api"),f=a(u("/api"))},3786:function(n,e,t){"use strict";t.d(e,"e",(function(){return o})),t.d(e,"d",(function(){return a})),t.d(e,"a",(function(){return u})),t.d(e,"c",(function(){return i})),t.d(e,"b",(function(){return f})),t.d(e,"f",(function(){return s}));var c=t("365c"),r=void 0,o=function(n){return c["a"].post("/signup",n)},a=function(n){return c["a"].post("/login",n)},u=function(n){return c["a"].post("/email-check",n)},i=function(n){return c["a"].post("/find-password",n).then((function(n){alert("이메일을 확인해주세요."),r.$router.push({name:"Login"})})).catch((function(n){alert(n.response.data.message)}))},f=function(n){return c["a"].post("/email-verify",n).then((function(n){alert("이메일을 확인해 주세요")})).catch((function(n){alert(n.response.data.message)}))},s=function(n){return c["a"].post("/verify-check",n).then((function(n){return n.data.verify})).catch((function(n){alert(n.response.data.message)}))}},4360:function(n,e,t){"use strict";var c=t("2b0e"),r=t("2f62");t("ac1f"),t("5319");function o(n){document.cookie="login_id=".concat(n)}function a(n){console.log("cookie 저장"),document.cookie="login_uid=".concat(n)}function u(n){document.cookie="login_name=".concat(n)}function i(n){document.cookie="login_email=".concat(n)}function f(n){document.cookie="login_token=".concat(n)}function s(n){document.cookie="login_img=".concat(n)}function d(n){document.cookie="login_temperature=".concat(n)}function h(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/,"$1")}function l(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_uid\s*=\s*([^;]*).*$)|^.*$/,"$1")}function m(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_name\s*=\s*([^;]*).*$)|^.*$/,"$1")}function p(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/,"$1")}function k(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/,"$1")}function b(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_temperature\s*=\s*([^;]*).*$)|^.*$/,"$1")}function g(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/,"$1")}var v={id:h()||"",uid:l()||"",email:p()||"",nickname:m()||"",token:g()?"".concat(g()):"",profileImg:k()||"",temperature:b()||""},y=t("94d5"),w=t.n(y),$={setUserId:function(n,e){n.id=e},setUserUid:function(n,e){n.uid=e},setUsername:function(n,e){n.nickname=e},setUserEmail:function(n,e){n.email=e},setToken:function(n,e){n.token=e},setImg:function(n,e){n.profileImg=e},setTemperature:function(n,e){n.temperature=e}},_=t("1da1"),O=(t("96cf"),t("3786")),U=t("1232"),I={LOGIN:function(n,e){return Object(_["a"])(regeneratorRuntime.mark((function t(){var c,r,a,h;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return c=n.commit,t.next=3,Object(O["d"])(e);case 3:return r=t.sent,a=r.data,h=Object(U["a"])(a.token),c("setUserId",h.id),c("setUsername",h.nickname),c("setUserEmail",h.email),c("setToken","Bearer "+a.token),c("setImg",h.profile_img),c("setTemperature",h.temperature),o(h.id),u(h.nickname),i(h.email),f("Bearer "+a.token),s(h.profile_img),d(h.temperature),t.abrupt("return",a);case 19:case"end":return t.stop()}}),t)})))()},LOGOUT:function(n){return Object(_["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:t=n.commit,t("setUserId",""),t("setUsername",""),t("setUserEmail",""),t("setToken",""),t("setImg",""),t("setTemperature",""),t("setUserUid",""),o(""),u(""),i(""),f(""),s(""),d(""),a("");case 15:case"end":return e.stop()}}),e)})))()},saveuUserUid:function(n,e){var t=n.commit;console.log("this is actions payload",e.firebaseData.uid),t("setUserUid",e.firebaseData.uid),a(e.firebaseData.uid)}};c["a"].use(r["a"]);e["a"]=new r["a"].Store({state:v,getters:w.a,mutations:$,actions:I,modules:{}})},"452c":function(n,e,t){},4557:function(n,e,t){"use strict";t("95f1")},"56d7":function(n,e,t){"use strict";t.r(e);t("e260"),t("e6cf"),t("cca6"),t("a79d");var c=t("2b0e"),r=function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{attrs:{id:"app"}},[t("div",{attrs:{id:"nav"}}),t("router-view",{attrs:{user:n.user}})],1)},o=[],a=(t("b0c0"),t("17e1"),t("260b")),u=(t("ea7b"),{name:"App",data:function(){return{user:null,rooms:[]}},methods:{logout:function(){var n=this;console.log(this.$router.history.current.name),this.$store.dispatch("LOGOUT"),a["a"].auth().signOut().then((function(){console.log("logout"),n.user=null,"Login"!=n.$router.history.current.name&&n.$router.push("/login")}))}},mounted:function(){var n=this;a["a"].auth().onAuthStateChanged((function(e){e&&(console.log("user login request"),n.user=e,""==n.$store.state.uid&&n.$store.dispatch("saveuUserUid",{firebaseData:n.user}))}))}}),i=u,f=(t("4557"),t("b0a0"),t("2877")),s=Object(f["a"])(i,r,o,!1,null,null,null),d=s.exports,h=t("a18c"),l=t("4360"),m=t("9612"),p=t("10bd"),k=t("7de8");Object(k["z"])(!0),c["a"].use(m["a"]),c["a"].use(p["a"]),c["a"].config.productionTip=!1,new c["a"]({router:h["a"],store:l["a"],render:function(n){return n(d)}}).$mount("#app")},"94d5":function(n,e){},"95f1":function(n,e,t){},a18c:function(n,e,t){"use strict";t("d3b7"),t("3ca3"),t("ddb0");var c=t("2b0e"),r=t("8c4f");c["a"].use(r["a"]);var o=[{path:"/",redirect:"/commingsoon"},{path:"/main",name:"Main",component:function(){return t.e("chunk-2d0cfcd5").then(t.bind(null,"64ef"))}},{path:"/main/mainisland",name:"MainIsland",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-2aaafce6")]).then(t.bind(null,"2048"))}},{path:"/login",name:"Login",component:function(){return t.e("chunk-284c59b5").then(t.bind(null,"9905"))}},{path:"/signup",name:"Signup",component:function(){return t.e("chunk-09655e21").then(t.bind(null,"ce61"))}},{path:"/intro",name:"Intro",component:function(){return t.e("chunk-1f46150e").then(t.bind(null,"db7d"))}},{path:"/find-password",name:"FindPassword",component:function(){return t.e("chunk-efcdcd6a").then(t.bind(null,"64cc"))}},{path:"/test",name:"Test",component:function(){return t.e("chunk-97de0c14").then(t.bind(null,"65d4"))}},{path:"/mailbox",name:"Mailbox",component:function(){return t.e("chunk-2d0c76f1").then(t.bind(null,"5132"))}},{path:"/mailbox/letters",name:"WriteLetter",component:function(){return t.e("chunk-5c535ecc").then(t.bind(null,"2c06"))}},{path:"/mailbox/random-mail",name:"RandomMail",component:function(){return t.e("chunk-04605efa").then(t.bind(null,"8269"))}},{path:"/mailbox/random-mail/rootmail/reply/:storyId",name:"RootMailReply",component:function(){return t.e("chunk-764cbc65").then(t.bind(null,"a0a3"))}},{path:"/mailbox/my-mailbox/letter-detail/letter-reply",name:"LetterReply",component:function(){return t.e("chunk-339a19a3").then(t.bind(null,"2a81"))}},{path:"/mailbox/received",name:"MyReceivedMail",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-43248cd1")]).then(t.bind(null,"8d70"))}},{path:"/home",name:"Home",component:function(){return t.e("chunk-4c60840a").then(t.bind(null,"f924"))}},{path:"/rooms",name:"RoomsPage",component:function(){return t.e("chunk-5683ef42").then(t.bind(null,"a2da"))}},{path:"/checkin/:hostID/:roomID",name:"CheckIn",component:function(){return t.e("chunk-5b5e1cf4").then(t.bind(null,"c5a7"))},props:!0},{path:"/chat/:hostID/:roomID",name:"Chat",component:function(){return t.e("chunk-385749fb").then(t.bind(null,"a94b"))}},{path:"/profile",name:"Profile",component:function(){return t.e("chunk-343b74a6").then(t.bind(null,"3379"))}},{path:"/commingsoon",name:"Commingsoon",component:function(){return t.e("chunk-6099f35c").then(t.bind(null,"eea0"))}},{path:"/feeling-record",name:"FeelingRecord",component:function(){return t.e("chunk-3f127a9a").then(t.bind(null,"c1c2"))}},{path:"/feeling-record/dairy",name:"Dairy",component:function(){return t.e("chunk-62e04e57").then(t.bind(null,"9a62"))}},{path:"/drawing",name:"Drawing",component:function(){return t.e("chunk-5384c96e").then(t.bind(null,"fd81"))}},{path:"/all/rooms",name:"AllRoom",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-096196c9")]).then(t.bind(null,"c52a"))}},{path:"/joy/vr",name:"VrRoom",component:function(){return t.e("chunk-2d0ba4c9").then(t.bind(null,"372a"))}},{path:"/star3d",name:"Star3D",component:function(){return t.e("chunk-61670627").then(t.bind(null,"73dc"))}}],a=new r["a"]({mode:"history",base:"/",routes:o});e["a"]=a},b0a0:function(n,e,t){"use strict";t("452c")}});
//# sourceMappingURL=app.86c72816.js.map