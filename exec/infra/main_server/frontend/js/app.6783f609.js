(function(e){function n(n){for(var c,o,i=n[0],u=n[1],s=n[2],l=0,d=[];l<i.length;l++)o=i[l],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&d.push(a[o][0]),a[o]=0;for(c in u)Object.prototype.hasOwnProperty.call(u,c)&&(e[c]=u[c]);f&&f(n);while(d.length)d.shift()();return r.push.apply(r,s||[]),t()}function t(){for(var e,n=0;n<r.length;n++){for(var t=r[n],c=!0,o=1;o<t.length;o++){var i=t[o];0!==a[i]&&(c=!1)}c&&(r.splice(n--,1),e=u(u.s=t[0]))}return e}var c={},o={app:0},a={app:0},r=[];function i(e){return u.p+"js/"+({}[e]||e)+"."+{"chunk-148888f8":"dac4e8bc","chunk-17044a77":"0283a27b","chunk-1f660c7d":"4b8308ba","chunk-2116d17a":"5e9c95ad","chunk-26347e98":"a5d35a99","chunk-2a7fb79e":"73dc1885","chunk-37df14db":"1b9f708b","chunk-6ab7c09a":"cdca08fb","chunk-6f9cd3b9":"bb3888f6","chunk-82954288":"a913a139","chunk-273412c6":"2cb2041d","chunk-276f1eac":"fab3f090","chunk-2e4bee54":"95510430","chunk-31fb1bc2":"7f98519c","chunk-42cdc37b":"d1d437d3","chunk-4ca85523":"238c053e","chunk-5942e4de":"1df32374","chunk-6099f35c":"5d31b0af","chunk-61670627":"004e1f59","chunk-6bf72382":"dfd21432","chunk-75fc0030":"e5d44f89","chunk-900bdfc0":"847e1dae","chunk-e7352610":"c9ca7248","chunk-efcdcd6a":"559ddae4"}[e]+".js"}function u(n){if(c[n])return c[n].exports;var t=c[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,u),t.l=!0,t.exports}u.e=function(e){var n=[],t={"chunk-148888f8":1,"chunk-17044a77":1,"chunk-1f660c7d":1,"chunk-2116d17a":1,"chunk-26347e98":1,"chunk-2a7fb79e":1,"chunk-37df14db":1,"chunk-6ab7c09a":1,"chunk-6f9cd3b9":1,"chunk-82954288":1,"chunk-273412c6":1,"chunk-276f1eac":1,"chunk-2e4bee54":1,"chunk-31fb1bc2":1,"chunk-42cdc37b":1,"chunk-4ca85523":1,"chunk-5942e4de":1,"chunk-6099f35c":1,"chunk-61670627":1,"chunk-6bf72382":1,"chunk-75fc0030":1,"chunk-900bdfc0":1,"chunk-e7352610":1,"chunk-efcdcd6a":1};o[e]?n.push(o[e]):0!==o[e]&&t[e]&&n.push(o[e]=new Promise((function(n,t){for(var c="css/"+({}[e]||e)+"."+{"chunk-148888f8":"197e5299","chunk-17044a77":"b462f90b","chunk-1f660c7d":"0736494b","chunk-2116d17a":"bf00800b","chunk-26347e98":"1bfd45a9","chunk-2a7fb79e":"07ffb9e6","chunk-37df14db":"07a81aa9","chunk-6ab7c09a":"b074efe5","chunk-6f9cd3b9":"0d778246","chunk-82954288":"d7b01f80","chunk-273412c6":"cad79632","chunk-276f1eac":"4c448cbb","chunk-2e4bee54":"b08eb57c","chunk-31fb1bc2":"bcfed19a","chunk-42cdc37b":"ba7ff3e2","chunk-4ca85523":"45abbb10","chunk-5942e4de":"b5ed882e","chunk-6099f35c":"bb9ab66f","chunk-61670627":"3ef66df6","chunk-6bf72382":"f5b1fb2c","chunk-75fc0030":"d98cbd72","chunk-900bdfc0":"171bc695","chunk-e7352610":"83a5f378","chunk-efcdcd6a":"2bba4f6c"}[e]+".css",a=u.p+c,r=document.getElementsByTagName("link"),i=0;i<r.length;i++){var s=r[i],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===c||l===a))return n()}var d=document.getElementsByTagName("style");for(i=0;i<d.length;i++){s=d[i],l=s.getAttribute("data-href");if(l===c||l===a)return n()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=n,f.onerror=function(n){var c=n&&n.target&&n.target.src||a,r=new Error("Loading CSS chunk "+e+" failed.\n("+c+")");r.code="CSS_CHUNK_LOAD_FAILED",r.request=c,delete o[e],f.parentNode.removeChild(f),t(r)},f.href=a;var m=document.getElementsByTagName("head")[0];m.appendChild(f)})).then((function(){o[e]=0})));var c=a[e];if(0!==c)if(c)n.push(c[2]);else{var r=new Promise((function(n,t){c=a[e]=[n,t]}));n.push(c[2]=r);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,u.nc&&l.setAttribute("nonce",u.nc),l.src=i(e);var d=new Error;s=function(n){l.onerror=l.onload=null,clearTimeout(f);var t=a[e];if(0!==t){if(t){var c=n&&("load"===n.type?"missing":n.type),o=n&&n.target&&n.target.src;d.message="Loading chunk "+e+" failed.\n("+c+": "+o+")",d.name="ChunkLoadError",d.type=c,d.request=o,t[1](d)}a[e]=void 0}};var f=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(n)},u.m=e,u.c=c,u.d=function(e,n,t){u.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},u.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},u.t=function(e,n){if(1&n&&(e=u(e)),8&n)return e;if(4&n&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(u.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var c in e)u.d(t,c,function(n){return e[n]}.bind(null,c));return t},u.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return u.d(n,"a",n),n},u.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},u.p="/",u.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=n,s=s.slice();for(var d=0;d<s.length;d++)n(s[d]);var f=l;r.push([0,"chunk-vendors"]),t()})({0:function(e,n,t){e.exports=t("56d7")},"17e1":function(e,n,t){"use strict";var c=t("260b"),o=(t("e71f"),{apiKey:"AIzaSyCY-UrWAhIekYvrVfrdMLpX9hXuStFDG6o",authDomain:"frontend-69a53.firebaseapp.com",projectId:"frontend-69a53",storageBucket:"frontend-69a53.appspot.com",messagingSenderId:"566533900429",appId:"1:566533900429:web:1f6d6c09f2461d8a09fac4s"}),a=c["a"].initializeApp(o);n["a"]=a.firestore()},"365c":function(e,n,t){"use strict";t.d(n,"a",(function(){return u})),t.d(n,"b",(function(){return s}));t("99af");var c=t("bc3a"),o=t.n(c),a=(t("d3b7"),t("4360"));function r(e){return e.interceptors.request.use((function(e){return e.headers.Authorization=a["a"].state.token,e}),(function(e){return Promise.reject(e)})),e.interceptors.response.use((function(e){return e}),(function(e){return Promise.reject(e)})),e}var i=function(e){return o.a.create({baseURL:"".concat("https://porest.kr").concat(e)})},u=i("/api"),s=r(i("/api"))},3786:function(e,n,t){"use strict";t.d(n,"e",(function(){return a})),t.d(n,"d",(function(){return r})),t.d(n,"a",(function(){return i})),t.d(n,"c",(function(){return u})),t.d(n,"b",(function(){return s})),t.d(n,"f",(function(){return l}));var c=t("365c"),o=void 0,a=function(e){return c["a"].post("/signup",e)},r=function(e){return c["a"].post("/login",e)},i=function(e){return c["a"].post("/email-check",e)},u=function(e){return c["a"].post("/find-password",e).then((function(e){alert("이메일을 확인해주세요."),o.$router.push({name:"Login"})})).catch((function(e){alert(e.response.data.message)}))},s=function(e){return c["a"].post("/email-verify",e).then((function(e){alert("이메일을 확인해 주세요")})).catch((function(e){alert(e.response.data.message)}))},l=function(e){return c["a"].post("/verify-check",e).then((function(e){return e.data.verify})).catch((function(e){alert(e.response.data.message)}))}},4360:function(e,n,t){"use strict";var c=t("2b0e"),o=t("2f62"),a=t("6a1d"),r={id:Object(a["c"])()||"",uid:Object(a["g"])()||"",email:Object(a["b"])()||"",nickname:Object(a["e"])()||"",token:Object(a["a"])()?"".concat(Object(a["a"])()):"",profileImg:Object(a["d"])()||"",temperature:Object(a["f"])()||"",thisMonthFeelings:[],targetDateId:0,targetDateDetail:"",stickerindex:0,selectedSticker:"",emotionIndex:0,diaryModalStatus:"",targetDate:[],modalControl:!1,refreshCalendar:!1,thisMonth:[],thisMonthWithEmoji:[],counselId:null,selectedStory:null,allLetters:null,modalProfileSetting:!1,profileImgToShow:0,logoStatus:!0},i=(t("a9e3"),t("ac1f"),t("1276"),{getFeeling:function(e){return Number(e.targetDateDetail["feeling"])-1},getStickerIndex:function(e){var n=e.targetDateDetail["imageUrl"];return Number(n.split(".")[0])-1},getRefreshCalendar:function(e){return e.refreshCalendar},getUpdateFeeling:function(e){return e.emotionIndex},getUpdateEmotion:function(e){return e.selectedSticker},getAuthToken:function(e){return e.token},getUpdateProfileImg:function(e){return e.profileImg},getUpdateProfileImgFinal:function(e){return e.profileImgToShow}}),u={setUserId:function(e,n){e.id=n},setUserUid:function(e,n){e.uid=n},setUsername:function(e,n){e.nickname=n},setUserEmail:function(e,n){e.email=n},setToken:function(e,n){e.token=n},setImg:function(e,n){e.profileImg=n},setTemperature:function(e,n){e.temperature=n},getThisMonthFeelings:function(e,n){e.thisMonthFeelings=n},getTargetDateId:function(e,n){e.targetDateId=n},getTargetDateDetail:function(e,n){e.targetDateDetail=n},getStickerIndex:function(e,n){e.stickerindex=n},getSelectedSticker:function(e,n){e.selectedSticker=n},getEmotionIndex:function(e,n){e.emotionIndex=n},getDiaryModalStatus:function(e,n){e.diaryModalStatus=n},getTargetDate:function(e,n){e.targetDate=n},getModalStatus:function(e,n){e.modalControl=n},getCalendarRefreshStatus:function(e,n){e.refreshCalendar=n},getThisMonth:function(e,n){e.thisMonth=n},getThisMonthEmoji:function(e,n){e.thisMonthWithEmoji=n},setCounselId:function(e,n){e.counselId=n},setSelectedStory:function(e,n){e.selectedStory=n},setAllLetters:function(e,n){e.allLetters=n},setModalProfile:function(e,n){e.modalProfileSetting=n},setProfileImgToShow:function(e,n){e.profileImgToShow=n},setLogoStatus:function(e,n){e.logoStatus=n}},s=t("1da1"),l=(t("96cf"),t("3786")),d=t("1232"),f={LOGIN:function(e,n){return Object(s["a"])(regeneratorRuntime.mark((function t(){var c,o,r,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return c=e.commit,t.next=3,Object(l["d"])(n);case 3:return o=t.sent,r=o.data,i=Object(d["a"])(r.token),c("setUserId",i.id),c("setUsername",i.nickname),c("setUserEmail",i.email),c("setToken","Bearer "+r.token),c("setImg",i.profile_img_number),c("setTemperature",i.temperature),Object(a["j"])(i.id),Object(a["l"])(i.nickname),Object(a["i"])(i.email),Object(a["h"])("Bearer "+r.token),Object(a["k"])(i.profile_img_number),Object(a["m"])(i.temperature),t.abrupt("return",r);case 19:case"end":return t.stop()}}),t)})))()},LOGOUT:function(e){return Object(s["a"])(regeneratorRuntime.mark((function n(){var t;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:t=e.commit,t("setUserId",""),t("setUsername",""),t("setUserEmail",""),t("setToken",""),t("setImg",""),t("setTemperature",""),t("setUserUid",""),Object(a["j"])(""),Object(a["l"])(""),Object(a["i"])(""),Object(a["h"])(""),Object(a["k"])(""),Object(a["m"])(""),Object(a["n"])("null");case 15:case"end":return n.stop()}}),n)})))()},saveuUserUid:function(e,n){var t=e.commit;t("setUserUid",n.firebaseData.uid),Object(a["n"])(n.firebaseData.uid)},saveSelectedCounselId:function(e,n){var t=e.commit;t("setCounselId",n)},saveSelectedStory:function(e,n){var t=e.commit;t("setSelectedStory",n)},saveAllLetters:function(e,n){var t=e.commit;t("setAllLetters",n)}};c["a"].use(o["a"]);n["a"]=new o["a"].Store({state:r,getters:i,mutations:u,actions:f,modules:{}})},"452c":function(e,n,t){},4557:function(e,n,t){"use strict";t("95f1")},"56d7":function(e,n,t){"use strict";t.r(n);t("e260"),t("e6cf"),t("cca6"),t("a79d");var c=t("2b0e"),o=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{attrs:{id:"app"}},[e._m(0),t("div",{staticClass:"music__player"},[t("div",{staticClass:"music-player__wrapper"},[t("div",{staticClass:"music-player music-player--disabled",attrs:{id:"music-container"}},[e._m(1),t("div",{staticClass:"music-player__bar music-player__bar1"}),t("div",{staticClass:"music-player__bar music-player__bar2"}),t("div",{staticClass:"music-player__bar music-player__bar3"}),t("div",{staticClass:"music-player__bar music-player__bar4"}),t("button",{staticClass:"music-player__button music-player__play",on:{click:function(n){return n.preventDefault(),e.controlMusic("play")}}},[t("span",{staticClass:"sr-only"},[e._v("Play")])]),t("button",{staticClass:"music-player__button music-player__pause",on:{click:function(n){return n.preventDefault(),e.controlMusic("pause")}}},[t("span",{staticClass:"sr-only"},[e._v("Pause")])])])])]),t("nav",{attrs:{id:"nav"}},[e._m(2),e.$store.state.id?t("ul",{staticClass:"nav_ul"},[t("li",[t("span",{staticClass:"nav-detail",on:{click:e.goToMain}},[e._v("홈")])]),t("li",[t("span",{staticClass:"nav-detail",on:{click:e.goToMailbox}},[e._v("우체통")])]),t("li",[t("span",{staticClass:"nav-detail",on:{click:e.goToFeelingRecord}},[e._v("하루일기")])]),t("li",[t("span",{staticClass:"nav-detail",on:{click:e.goToVideoChat}},[e._v("마음나눔")])]),e._m(3),t("li",[t("span",{staticClass:"nav-detail",on:{click:e.goToJoy}},[e._v("쉼터")])]),t("li",{staticClass:"nav-detail",on:{click:e.logout}},[e._v("로그아웃")])]):t("ul",{staticClass:"nav_ul"},[t("li",[e._v("로그인")])])]),t("router-view",{attrs:{user:e.user},on:{introState:e.introState,introPlay:e.introPlay,controlMusic:e.controlMusic,skip:e.skip}})],1)},a=[function(){var e=this,n=e.$createElement,c=e._self._c||n;return c("audio",{attrs:{id:"audio-player1",loop:"false"}},[c("source",{attrs:{src:t("aa34"),type:"audio/mpeg"}}),c("p",{staticClass:"sr-only"},[e._v(" Your browser does not support the audio element. ")])])},function(){var e=this,n=e.$createElement,c=e._self._c||n;return c("audio",{attrs:{id:"audio-player",loop:""}},[c("source",{attrs:{src:t("9e04"),type:"audio/mpeg"}}),c("p",{staticClass:"sr-only"},[e._v(" Your browser does not support the audio element. ")])])},function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("button",{staticClass:"nav-icon",attrs:{id:"nav-icon"}},[t("span")])},function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("li",[t("span",{staticClass:"nav-detail"},[e._v("하소연")])])}],r=(t("b0c0"),t("17e1"),t("260b")),i=(t("ea7b"),function(){var e=document.getElementById("nav"),n=e.getElementsByTagName("a");function t(){e.classList.contains("active")?e.classList.remove("active"):e.classList.add("active")}document.getElementById("nav-icon").addEventListener("click",(function(e){e.preventDefault(),t()}));for(var c=0;c<n.length;c++)n[c].addEventListener("click",(function(){t()}))}),u={name:"App",data:function(){return{user:null,rooms:[],loginState:!1,introState:!1}},methods:{skip:function(){var e=document.querySelector("#audio-player1");e.pause(),this.$router.push({name:"MainIsland"})},logout:function(){var e=this;this.loginState=!1,this.$store.dispatch("LOGOUT"),r["a"].auth().signOut().then((function(){e.user=null,"Login"!=e.$router.history.current.name&&e.$router.push({name:"Login"})}))},goToMain:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push({name:"MainIsland"})},goToMailbox:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/mailbox")},goToFeelingRecord:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/feeling-record")},goToVideoChat:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/all/rooms")},goToJoy:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/joy")},controlMusic:function(e){var n=document.querySelector("#audio-player"),t=document.querySelector("#music-container");"play"!=e?(t.classList.add("music-player--disabled"),n.pause()):(n.play(),t.classList.remove("music-player--disabled"))},introPlay:function(){var e=document.querySelector("#audio-player1");setTimeout((function(){e.play()}),150),setTimeout((function(){e.pause()}),5650)}},mounted:function(){var e=this;i();document.querySelector("#audio-player"),document.querySelector("#audio-player1");r["a"].auth().onAuthStateChanged((function(n){n&&(e.loginState=!e.loginState,e.user=n,""!=e.$store.state.uid&&"null"!=e.$store.state.uid||e.$store.dispatch("saveuUserUid",{firebaseData:e.user}))}))},created:function(){var e=this.$store.getters.getAuthToken;""==e||null==e?this.$router.push({name:"Login"}):this.loginState=!0,this.$store.commit("setLogoStatus",!0)}},s=u,l=(t("4557"),t("b0a0"),t("2877")),d=Object(l["a"])(s,o,a,!1,null,null,null),f=d.exports,m=t("a18c"),h=t("4360"),p=t("9612"),b=t("10bd"),g=t("7de8");Object(g["z"])(!0),c["a"].use(p["a"]),c["a"].use(b["a"]),c["a"].config.productionTip=!1,new c["a"]({router:m["a"],store:h["a"],render:function(e){return e(f)}}).$mount("#app")},"6a1d":function(e,n,t){"use strict";t.d(n,"h",(function(){return l})),t.d(n,"j",(function(){return r})),t.d(n,"n",(function(){return i})),t.d(n,"l",(function(){return u})),t.d(n,"i",(function(){return s})),t.d(n,"k",(function(){return d})),t.d(n,"m",(function(){return f})),t.d(n,"a",(function(){return v})),t.d(n,"c",(function(){return m})),t.d(n,"g",(function(){return h})),t.d(n,"e",(function(){return p})),t.d(n,"b",(function(){return b})),t.d(n,"d",(function(){return g})),t.d(n,"f",(function(){return k}));t("99af"),t("ac1f"),t("5319");var c=new Date(Date.now()+864e5),o=c.toUTCString(),a=";path=/;secure; expires=".concat(o);function r(e){document.cookie="login_id=".concat(e).concat(a)}function i(e){document.cookie="login_uid=".concat(e).concat(a)}function u(e){document.cookie="login_name=".concat(e).concat(a)}function s(e){document.cookie="login_email=".concat(e).concat(a)}function l(e){document.cookie="login_token=".concat(e).concat(a)}function d(e){document.cookie="login_img=".concat(e).concat(a)}function f(e){document.cookie="login_temperature=".concat(e).concat(a)}function m(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/,"$1")}function h(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_uid\s*=\s*([^;]*).*$)|^.*$/,"$1")}function p(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_name\s*=\s*([^;]*).*$)|^.*$/,"$1")}function b(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/,"$1")}function g(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/,"$1")}function k(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_temperature\s*=\s*([^;]*).*$)|^.*$/,"$1")}function v(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/,"$1")}},"95f1":function(e,n,t){},"9e04":function(e,n,t){e.exports=t.p+"media/backgroundMusic.b78f82d0.mp3"},a18c:function(e,n,t){"use strict";t("d3b7"),t("3ca3"),t("ddb0");var c=t("2b0e"),o=t("8c4f");c["a"].use(o["a"]);var a=[{path:"/",redirect:"/commingsoon"},{path:"/main",name:"MainIsland",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-37df14db")]).then(t.bind(null,"2048"))}},{path:"/login",name:"Login",component:function(){return t.e("chunk-148888f8").then(t.bind(null,"9905"))}},{path:"/signup",name:"Signup",component:function(){return t.e("chunk-4ca85523").then(t.bind(null,"ce61"))}},{path:"/intro",name:"Intro",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-2a7fb79e")]).then(t.bind(null,"db7d"))}},{path:"/find-password",name:"FindPassword",component:function(){return t.e("chunk-efcdcd6a").then(t.bind(null,"64cc"))}},{path:"/mailbox",name:"Mailbox",component:function(){return t.e("chunk-e7352610").then(t.bind(null,"5132"))}},{path:"/mailbox/letters",name:"WriteLetter",component:function(){return t.e("chunk-2116d17a").then(t.bind(null,"2c06"))}},{path:"/mailbox/random-mail",name:"RandomMail",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-82954288")]).then(t.bind(null,"8269"))}},{path:"/mailbox/random-mail/rootmail/reply",name:"RootMailReply",component:function(){return t.e("chunk-6bf72382").then(t.bind(null,"a0a3"))},props:!0},{path:"/mailbox/received",name:"MyReceivedMail",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-6ab7c09a")]).then(t.bind(null,"8d70"))},props:!0},{path:"/rooms",name:"RoomsPage",component:function(){return t.e("chunk-31fb1bc2").then(t.bind(null,"a2da"))}},{path:"/checkin/:hostID/:roomID",name:"CheckIn",component:function(){return t.e("chunk-900bdfc0").then(t.bind(null,"c5a7"))},props:!0},{path:"/profile",name:"Profile",component:function(){return t.e("chunk-17044a77").then(t.bind(null,"3379"))}},{path:"/commingsoon",name:"Commingsoon",component:function(){return t.e("chunk-6099f35c").then(t.bind(null,"eea0"))}},{path:"/feeling-record",name:"FeelingRecord",component:function(){return t.e("chunk-42cdc37b").then(t.bind(null,"c1c2"))}},{path:"/drawing",name:"Drawing",component:function(){return t.e("chunk-1f660c7d").then(t.bind(null,"fd81"))}},{path:"/all/rooms",name:"AllRoom",component:function(){return Promise.all([t.e("chunk-26347e98"),t.e("chunk-6f9cd3b9")]).then(t.bind(null,"c52a"))}},{path:"/joy/vr",name:"VrRoom",component:function(){return t.e("chunk-5942e4de").then(t.bind(null,"372a"))}},{path:"/star3d",name:"Star3D",component:function(){return t.e("chunk-61670627").then(t.bind(null,"73dc"))}},{path:"/mailbox/intro",name:"MailBoxIntro",component:function(){return t.e("chunk-276f1eac").then(t.bind(null,"3368"))}},{path:"/joy",name:"JoyMainPage",component:function(){return t.e("chunk-273412c6").then(t.bind(null,"7c46"))}},{path:"/joy/healing/music",name:"HealingMusic",component:function(){return t.e("chunk-75fc0030").then(t.bind(null,"e2a8"))}},{path:"/admin/ban-report",name:"BanReport",component:function(){return t.e("chunk-2e4bee54").then(t.bind(null,"d1e4"))}}],r=new o["a"]({mode:"history",base:"/",routes:a});n["a"]=r},aa34:function(e,n,t){e.exports=t.p+"media/introvoice.22721559.mp3"},b0a0:function(e,n,t){"use strict";t("452c")}});
//# sourceMappingURL=app.6783f609.js.map