(function(e){function n(n){for(var c,o,u=n[0],i=n[1],s=n[2],l=0,d=[];l<u.length;l++)o=u[l],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&d.push(r[o][0]),r[o]=0;for(c in i)Object.prototype.hasOwnProperty.call(i,c)&&(e[c]=i[c]);f&&f(n);while(d.length)d.shift()();return a.push.apply(a,s||[]),t()}function t(){for(var e,n=0;n<a.length;n++){for(var t=a[n],c=!0,o=1;o<t.length;o++){var u=t[o];0!==r[u]&&(c=!1)}c&&(a.splice(n--,1),e=i(i.s=t[0]))}return e}var c={},o={app:0},r={app:0},a=[];function u(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-03e02152":"39311d34","chunk-0f5bfb34":"e3e44efd","chunk-26347e98":"a5d35a99","chunk-16883390":"4f415adb","chunk-212c57b3":"1cdbc922","chunk-6c5de766":"8b5dcea5","chunk-6f632b36":"380f3d14","chunk-d3d28444":"c832292b","chunk-276f1eac":"fab3f090","chunk-2c15e702":"f57f6393","chunk-2d0cfcd5":"a51ec4e5","chunk-31a11574":"b7482f04","chunk-3a13cba6":"e2fa9f28","chunk-42d08411":"0dd535e2","chunk-4c308e42":"107cf569","chunk-4c60840a":"28eb61f7","chunk-5562f610":"7e45a6e1","chunk-5a01504f":"fda87287","chunk-60685b43":"8b42e11b","chunk-6099f35c":"5d31b0af","chunk-61670627":"004e1f59","chunk-6a0e6790":"3a76dc35","chunk-6de542e7":"c5edbac8","chunk-70f61768":"a182db45","chunk-749d6a1a":"6201b248","chunk-78a0a935":"44123d72","chunk-97de0c14":"494bf37b","chunk-efcdcd6a":"559ddae4","chunk-f336db08":"0f595a01"}[e]+".js"}function i(n){if(c[n])return c[n].exports;var t=c[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,i),t.l=!0,t.exports}i.e=function(e){var n=[],t={"chunk-03e02152":1,"chunk-0f5bfb34":1,"chunk-26347e98":1,"chunk-16883390":1,"chunk-212c57b3":1,"chunk-6c5de766":1,"chunk-6f632b36":1,"chunk-d3d28444":1,"chunk-276f1eac":1,"chunk-2c15e702":1,"chunk-31a11574":1,"chunk-3a13cba6":1,"chunk-42d08411":1,"chunk-4c308e42":1,"chunk-4c60840a":1,"chunk-5562f610":1,"chunk-5a01504f":1,"chunk-60685b43":1,"chunk-6099f35c":1,"chunk-61670627":1,"chunk-6a0e6790":1,"chunk-6de542e7":1,"chunk-70f61768":1,"chunk-749d6a1a":1,"chunk-78a0a935":1,"chunk-97de0c14":1,"chunk-efcdcd6a":1,"chunk-f336db08":1};o[e]?n.push(o[e]):0!==o[e]&&t[e]&&n.push(o[e]=new Promise((function(n,t){for(var c="css/"+({}[e]||e)+"."+{"chunk-03e02152":"a4f3e4e7","chunk-0f5bfb34":"fa93f3b3","chunk-26347e98":"1bfd45a9","chunk-16883390":"47417986","chunk-212c57b3":"eb2f7e13","chunk-6c5de766":"679401c3","chunk-6f632b36":"f2da29f6","chunk-d3d28444":"75f09320","chunk-276f1eac":"4c448cbb","chunk-2c15e702":"924bfd51","chunk-2d0cfcd5":"31d6cfe0","chunk-31a11574":"80f82d1e","chunk-3a13cba6":"b8d34d85","chunk-42d08411":"3f188170","chunk-4c308e42":"e8d60159","chunk-4c60840a":"fcfae90d","chunk-5562f610":"a6703114","chunk-5a01504f":"12d7a1a5","chunk-60685b43":"98391270","chunk-6099f35c":"bb9ab66f","chunk-61670627":"3ef66df6","chunk-6a0e6790":"444a4f0c","chunk-6de542e7":"df8fd5dc","chunk-70f61768":"5858b227","chunk-749d6a1a":"9b1b0748","chunk-78a0a935":"441df61f","chunk-97de0c14":"c7a8e657","chunk-efcdcd6a":"2bba4f6c","chunk-f336db08":"b405c503"}[e]+".css",r=i.p+c,a=document.getElementsByTagName("link"),u=0;u<a.length;u++){var s=a[u],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===c||l===r))return n()}var d=document.getElementsByTagName("style");for(u=0;u<d.length;u++){s=d[u],l=s.getAttribute("data-href");if(l===c||l===r)return n()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=n,f.onerror=function(n){var c=n&&n.target&&n.target.src||r,a=new Error("Loading CSS chunk "+e+" failed.\n("+c+")");a.code="CSS_CHUNK_LOAD_FAILED",a.request=c,delete o[e],f.parentNode.removeChild(f),t(a)},f.href=r;var h=document.getElementsByTagName("head")[0];h.appendChild(f)})).then((function(){o[e]=0})));var c=r[e];if(0!==c)if(c)n.push(c[2]);else{var a=new Promise((function(n,t){c=r[e]=[n,t]}));n.push(c[2]=a);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,i.nc&&l.setAttribute("nonce",i.nc),l.src=u(e);var d=new Error;s=function(n){l.onerror=l.onload=null,clearTimeout(f);var t=r[e];if(0!==t){if(t){var c=n&&("load"===n.type?"missing":n.type),o=n&&n.target&&n.target.src;d.message="Loading chunk "+e+" failed.\n("+c+": "+o+")",d.name="ChunkLoadError",d.type=c,d.request=o,t[1](d)}r[e]=void 0}};var f=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(n)},i.m=e,i.c=c,i.d=function(e,n,t){i.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,n){if(1&n&&(e=i(e)),8&n)return e;if(4&n&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(i.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var c in e)i.d(t,c,function(n){return e[n]}.bind(null,c));return t},i.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(n,"a",n),n},i.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=n,s=s.slice();for(var d=0;d<s.length;d++)n(s[d]);var f=l;a.push([0,"chunk-vendors"]),t()})({0:function(e,n,t){e.exports=t("56d7")},"17e1":function(e,n,t){"use strict";var c=t("260b"),o=(t("e71f"),{apiKey:"AIzaSyCY-UrWAhIekYvrVfrdMLpX9hXuStFDG6o",authDomain:"frontend-69a53.firebaseapp.com",projectId:"frontend-69a53",storageBucket:"frontend-69a53.appspot.com",messagingSenderId:"566533900429",appId:"1:566533900429:web:1f6d6c09f2461d8a09fac4s"}),r=c["a"].initializeApp(o);n["a"]=r.firestore()},"365c":function(e,n,t){"use strict";t.d(n,"a",(function(){return i})),t.d(n,"b",(function(){return s}));t("99af");var c=t("bc3a"),o=t.n(c),r=(t("d3b7"),t("4360"));function a(e){return e.interceptors.request.use((function(e){return e.headers.Authorization=r["a"].state.token,e}),(function(e){return Promise.reject(e)})),e.interceptors.response.use((function(e){return e}),(function(e){return Promise.reject(e)})),e}var u=function(e){return o.a.create({baseURL:"".concat("https://porest.kr").concat(e)})},i=u("/api"),s=a(u("/api"))},3786:function(e,n,t){"use strict";t.d(n,"e",(function(){return r})),t.d(n,"d",(function(){return a})),t.d(n,"a",(function(){return u})),t.d(n,"c",(function(){return i})),t.d(n,"b",(function(){return s})),t.d(n,"f",(function(){return l}));var c=t("365c"),o=void 0,r=function(e){return c["a"].post("/signup",e)},a=function(e){return c["a"].post("/login",e)},u=function(e){return c["a"].post("/email-check",e)},i=function(e){return c["a"].post("/find-password",e).then((function(e){alert("이메일을 확인해주세요."),o.$router.push({name:"Login"})})).catch((function(e){alert(e.response.data.message)}))},s=function(e){return c["a"].post("/email-verify",e).then((function(e){alert("이메일을 확인해 주세요")})).catch((function(e){alert(e.response.data.message)}))},l=function(e){return c["a"].post("/verify-check",e).then((function(e){return e.data.verify})).catch((function(e){alert(e.response.data.message)}))}},4360:function(e,n,t){"use strict";var c=t("2b0e"),o=t("2f62"),r=(t("99af"),t("ac1f"),t("5319"),new Date(Date.now()+864e5)),a=r.toUTCString(),u=";path=/;secure; expires=".concat(a);function i(e){document.cookie="login_id=".concat(e).concat(u)}function s(e){console.log("cookie 저장",e,"value"),document.cookie="login_uid=".concat(e).concat(u)}function l(e){document.cookie="login_name=".concat(e).concat(u)}function d(e){document.cookie="login_email=".concat(e).concat(u)}function f(e){document.cookie="login_token=".concat(e).concat(u)}function h(e){document.cookie="login_img=".concat(e).concat(u)}function m(e){document.cookie="login_temperature=".concat(e).concat(u)}function p(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/,"$1")}function k(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_uid\s*=\s*([^;]*).*$)|^.*$/,"$1")}function b(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_name\s*=\s*([^;]*).*$)|^.*$/,"$1")}function g(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/,"$1")}function v(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/,"$1")}function y(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_temperature\s*=\s*([^;]*).*$)|^.*$/,"$1")}function S(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/,"$1")}var I={id:p()||"",uid:k()||"",email:g()||"",nickname:b()||"",token:S()?"".concat(S()):"",profileImg:v()||"",temperature:y()||"",thisMonthFeelings:[],targetDateId:0,targetDateDetail:"",stickerindex:0,selectedSticker:"",emotionIndex:0,diaryModalStatus:"",targetDate:[],modalControl:!1,refreshCalendar:!1,thisMonth:[],thisMonthWithEmoji:[],counselId:null,selectedStory:null,allLetters:null},w=(t("a9e3"),t("1276"),{getFeeling:function(e){return Number(e.targetDateDetail["feeling"])-1},getStickerIndex:function(e){var n=e.targetDateDetail["imageUrl"];return Number(n.split(".")[0])-1},getRefreshCalendar:function(e){return e.refreshCalendar},getUpdateFeeling:function(e){return e.emotionIndex},getUpdateEmotion:function(e){return e.selectedSticker},getAuthToken:function(e){return e.token}}),D={setUserId:function(e,n){e.id=n},setUserUid:function(e,n){e.uid=n},setUsername:function(e,n){e.nickname=n},setUserEmail:function(e,n){e.email=n},setToken:function(e,n){e.token=n},setImg:function(e,n){e.profileImg=n},setTemperature:function(e,n){e.temperature=n},getThisMonthFeelings:function(e,n){e.thisMonthFeelings=n},getTargetDateId:function(e,n){e.targetDateId=n},getTargetDateDetail:function(e,n){e.targetDateDetail=n},getStickerIndex:function(e,n){e.stickerindex=n},getSelectedSticker:function(e,n){e.selectedSticker=n},getEmotionIndex:function(e,n){e.emotionIndex=n},getDiaryModalStatus:function(e,n){e.diaryModalStatus=n},getTargetDate:function(e,n){e.targetDate=n},getModalStatus:function(e,n){e.modalControl=n},getCalendarRefreshStatus:function(e,n){e.refreshCalendar=n},getThisMonth:function(e,n){e.thisMonth=n},getThisMonthEmoji:function(e,n){e.thisMonthWithEmoji=n},setCounselId:function(e,n){e.counselId=n},setSelectedStory:function(e,n){e.selectedStory=n},setAllLetters:function(e,n){e.allLetters=n}},x=t("1da1"),$=(t("96cf"),t("3786")),M=t("1232"),U={LOGIN:function(e,n){return Object(x["a"])(regeneratorRuntime.mark((function t(){var c,o,r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return c=e.commit,t.next=3,Object($["d"])(n);case 3:return o=t.sent,r=o.data,a=Object(M["a"])(r.token),c("setUserId",a.id),c("setUsername",a.nickname),c("setUserEmail",a.email),c("setToken","Bearer "+r.token),c("setImg",a.profile_img),c("setTemperature",a.temperature),i(a.id),l(a.nickname),d(a.email),f("Bearer "+r.token),h(a.profile_img),m(a.temperature),t.abrupt("return",r);case 19:case"end":return t.stop()}}),t)})))()},LOGOUT:function(e){return Object(x["a"])(regeneratorRuntime.mark((function n(){var t;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:t=e.commit,t("setUserId",""),t("setUsername",""),t("setUserEmail",""),t("setToken",""),t("setImg",""),t("setTemperature",""),t("setUserUid",""),i(""),l(""),d(""),f(""),h(""),m(""),s("null");case 15:case"end":return n.stop()}}),n)})))()},saveuUserUid:function(e,n){var t=e.commit;console.log("this is actions payload",n.firebaseData.uid),t("setUserUid",n.firebaseData.uid),s(n.firebaseData.uid)},saveSelectedCounselId:function(e,n){var t=e.commit;t("setCounselId",n)},saveSelectedStory:function(e,n){var t=e.commit;t("setSelectedStory",n)},saveAllLetters:function(e,n){var t=e.commit;t("setAllLetters",n)}};c["a"].use(o["a"]);n["a"]=new o["a"].Store({state:I,getters:w,mutations:D,actions:U,modules:{}})},"452c":function(e,n,t){},4557:function(e,n,t){"use strict";t("95f1")},"56d7":function(e,n,t){"use strict";t.r(n);t("e260"),t("e6cf"),t("cca6"),t("a79d");var c=t("2b0e"),o=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{attrs:{id:"app"}},[t("div",{attrs:{id:"nav"}},[t("div",{staticClass:"logout",on:{click:e.logout}},[e._v("로그 아웃")])]),t("router-view",{attrs:{user:e.user}})],1)},r=[],a=(t("b0c0"),t("17e1"),t("260b")),u=(t("ea7b"),{name:"App",data:function(){return{user:null,rooms:[]}},methods:{logout:function(){var e=this;console.log("logout",this.$router.history.current.name),this.$store.dispatch("LOGOUT"),a["a"].auth().signOut().then((function(){console.log("logout"),e.user=null,"Login"!=e.$router.history.current.name&&e.$router.push("/log/login")}))}},mounted:function(){var e=this;a["a"].auth().onAuthStateChanged((function(n){n&&(console.log("user login request"),e.user=n,""!=e.$store.state.uid&&"null"!=e.$store.state.uid||e.$store.dispatch("saveuUserUid",{firebaseData:e.user}))}))}}),i=u,s=(t("4557"),t("b0a0"),t("2877")),l=Object(s["a"])(i,o,r,!1,null,null,null),d=l.exports,f=t("a18c"),h=t("4360"),m=t("9612"),p=t("10bd"),k=t("7de8");Object(k["z"])(!0),c["a"].use(m["a"]),c["a"].use(p["a"]),c["a"].config.productionTip=!1,new c["a"]({router:f["a"],store:h["a"],render:function(e){return e(d)}}).$mount("#app")},"95f1":function(e,n,t){},a18c:function(e,n,t){"use strict";t("d3b7"),t("3ca3"),t("ddb0");var c=t("2b0e"),o=t("8c4f");c["a"].use(o["a"]);var r=[{path:"/",redirect:"/commingsoon"},{path:"/main",name:"Main",component:function(){return t.e("chunk-2d0cfcd5").then(t.bind(null,"64ef"))}},{path:"/main/mainisland",name:"MainIsland",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-212c57b3")]).then(t.bind(null,"2048"))}},{path:"/log/login",name:"Login",component:function(){return t.e("chunk-70f61768").then(t.bind(null,"9905"))}},{path:"/sing/signup",name:"Signup",component:function(){return t.e("chunk-0f5bfb34").then(t.bind(null,"ce61"))}},{path:"/int/intro",name:"Intro",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-6c5de766")]).then(t.bind(null,"db7d"))}},{path:"/find-password",name:"FindPassword",component:function(){return t.e("chunk-efcdcd6a").then(t.bind(null,"64cc"))}},{path:"/test",name:"Test",component:function(){return t.e("chunk-97de0c14").then(t.bind(null,"65d4"))}},{path:"/mailboxplane",name:"MailboxPlane",component:function(){return t.e("chunk-6de542e7").then(t.bind(null,"14fb"))}},{path:"/mailbox",name:"Mailbox",component:function(){return t.e("chunk-749d6a1a").then(t.bind(null,"5132"))}},{path:"/mailbox/letters",name:"WriteLetter",component:function(){return t.e("chunk-f336db08").then(t.bind(null,"2c06"))}},{path:"/mailbox/random-mail",name:"RandomMail",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-6f632b36")]).then(t.bind(null,"8269"))}},{path:"/mailbox/random-mail/rootmail/reply",name:"RootMailReply",component:function(){return t.e("chunk-03e02152").then(t.bind(null,"a0a3"))},props:!0},{path:"/mailbox/my-mailbox/letter-detail/letter-reply",name:"LetterReply",component:function(){return t.e("chunk-5a01504f").then(t.bind(null,"2a81"))}},{path:"/mailbox/received",name:"MyReceivedMail",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-d3d28444")]).then(t.bind(null,"8d70"))},props:!0},{path:"/home",name:"Home",component:function(){return t.e("chunk-4c60840a").then(t.bind(null,"f924"))}},{path:"/rooms",name:"RoomsPage",component:function(){return t.e("chunk-2c15e702").then(t.bind(null,"a2da"))}},{path:"/checkin/:hostID/:roomID",name:"CheckIn",component:function(){return t.e("chunk-4c308e42").then(t.bind(null,"c5a7"))},props:!0},{path:"/chat/:hostID/:roomID",name:"Chat",component:function(){return t.e("chunk-3a13cba6").then(t.bind(null,"a94b"))}},{path:"/profile",name:"Profile",component:function(){return t.e("chunk-60685b43").then(t.bind(null,"3379"))}},{path:"/commingsoon",name:"Commingsoon",component:function(){return t.e("chunk-6099f35c").then(t.bind(null,"eea0"))}},{path:"/feeling-record",name:"FeelingRecord",component:function(){return t.e("chunk-5562f610").then(t.bind(null,"c1c2"))}},{path:"/drawing",name:"Drawing",component:function(){return t.e("chunk-31a11574").then(t.bind(null,"fd81"))}},{path:"/all/rooms",name:"AllRoom",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-16883390")]).then(t.bind(null,"c52a"))}},{path:"/joy/vr",name:"VrRoom",component:function(){return t.e("chunk-42d08411").then(t.bind(null,"372a"))}},{path:"/star3d",name:"Star3D",component:function(){return t.e("chunk-61670627").then(t.bind(null,"73dc"))}},{path:"/mailbox/intro",name:"MailBoxIntro",component:function(){return t.e("chunk-276f1eac").then(t.bind(null,"3368"))}},{path:"/joy",name:"JoyMainPage",component:function(){return t.e("chunk-78a0a935").then(t.bind(null,"7c46"))}},{path:"/joy/healing/music",name:"HealingMusic",component:function(){return t.e("chunk-6a0e6790").then(t.bind(null,"e2a8"))}}],a=new o["a"]({mode:"history",base:"/",routes:r});n["a"]=a},b0a0:function(e,n,t){"use strict";t("452c")}});
//# sourceMappingURL=app.e41f5e06.js.map