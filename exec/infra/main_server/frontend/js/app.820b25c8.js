(function(e){function t(t){for(var a,c,u=t[0],i=t[1],s=t[2],l=0,d=[];l<u.length;l++)c=u[l],Object.prototype.hasOwnProperty.call(o,c)&&o[c]&&d.push(o[c][0]),o[c]=0;for(a in i)Object.prototype.hasOwnProperty.call(i,a)&&(e[a]=i[a]);f&&f(t);while(d.length)d.shift()();return r.push.apply(r,s||[]),n()}function n(){for(var e,t=0;t<r.length;t++){for(var n=r[t],a=!0,c=1;c<n.length;c++){var u=n[c];0!==o[u]&&(a=!1)}a&&(r.splice(t--,1),e=i(i.s=n[0]))}return e}var a={},c={app:0},o={app:0},r=[];function u(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-02223004":"c7a0a896","chunk-1e11af32":"891fc671","chunk-1f660c7d":"4b8308ba","chunk-1f9537b8":"c7faa511","chunk-26347e98":"a5d35a99","chunk-20838f2f":"056cee90","chunk-2f68c9d4":"392629fd","chunk-3cdb7792":"056ca6f1","chunk-44352516":"354d1958","chunk-cf8d7028":"9c0d01ba","chunk-273412c6":"2cb2041d","chunk-35d42017":"0b7a3f1e","chunk-36acf952":"b954f56b","chunk-3aced1a4":"ce03208c","chunk-51ee938e":"29f21048","chunk-5bd3232c":"eb244180","chunk-61670627":"004e1f59","chunk-6562fa0a":"95ed24dd","chunk-742e0a9a":"24511a18","chunk-759f3c02":"6be9bc3d","chunk-84c131f2":"f3acf16b","chunk-900bdfc0":"847e1dae","chunk-b5573d9c":"6445e717","chunk-c3e8de5c":"64ae2ba1","chunk-fe17b4fe":"95d6828a"}[e]+".js"}function i(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n={"chunk-02223004":1,"chunk-1e11af32":1,"chunk-1f660c7d":1,"chunk-1f9537b8":1,"chunk-26347e98":1,"chunk-20838f2f":1,"chunk-2f68c9d4":1,"chunk-3cdb7792":1,"chunk-44352516":1,"chunk-cf8d7028":1,"chunk-273412c6":1,"chunk-35d42017":1,"chunk-36acf952":1,"chunk-3aced1a4":1,"chunk-51ee938e":1,"chunk-5bd3232c":1,"chunk-61670627":1,"chunk-6562fa0a":1,"chunk-742e0a9a":1,"chunk-759f3c02":1,"chunk-84c131f2":1,"chunk-900bdfc0":1,"chunk-b5573d9c":1,"chunk-c3e8de5c":1,"chunk-fe17b4fe":1};c[e]?t.push(c[e]):0!==c[e]&&n[e]&&t.push(c[e]=new Promise((function(t,n){for(var a="css/"+({}[e]||e)+"."+{"chunk-02223004":"869b6003","chunk-1e11af32":"4350391c","chunk-1f660c7d":"539cca7b","chunk-1f9537b8":"b3ee58fd","chunk-26347e98":"72856240","chunk-20838f2f":"b68fcfdb","chunk-2f68c9d4":"d7b01f80","chunk-3cdb7792":"bf5773bd","chunk-44352516":"2c5d3254","chunk-cf8d7028":"e8d4081e","chunk-273412c6":"37f00a7b","chunk-35d42017":"2cb54b3f","chunk-36acf952":"ba7ff3e2","chunk-3aced1a4":"548be007","chunk-51ee938e":"f7f63438","chunk-5bd3232c":"8e53f7c4","chunk-61670627":"7d857951","chunk-6562fa0a":"82d47c3e","chunk-742e0a9a":"487a8fd5","chunk-759f3c02":"ceeaf701","chunk-84c131f2":"7f1370e2","chunk-900bdfc0":"01eb35d2","chunk-b5573d9c":"bcfed19a","chunk-c3e8de5c":"d38ab05b","chunk-fe17b4fe":"30460836"}[e]+".css",o=i.p+a,r=document.getElementsByTagName("link"),u=0;u<r.length;u++){var s=r[u],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===a||l===o))return t()}var d=document.getElementsByTagName("style");for(u=0;u<d.length;u++){s=d[u],l=s.getAttribute("data-href");if(l===a||l===o)return t()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=t,f.onerror=function(t){var a=t&&t.target&&t.target.src||o,r=new Error("Loading CSS chunk "+e+" failed.\n("+a+")");r.code="CSS_CHUNK_LOAD_FAILED",r.request=a,delete c[e],f.parentNode.removeChild(f),n(r)},f.href=o;var m=document.getElementsByTagName("head")[0];m.appendChild(f)})).then((function(){c[e]=0})));var a=o[e];if(0!==a)if(a)t.push(a[2]);else{var r=new Promise((function(t,n){a=o[e]=[t,n]}));t.push(a[2]=r);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,i.nc&&l.setAttribute("nonce",i.nc),l.src=u(e);var d=new Error;s=function(t){l.onerror=l.onload=null,clearTimeout(f);var n=o[e];if(0!==n){if(n){var a=t&&("load"===t.type?"missing":t.type),c=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+a+": "+c+")",d.name="ChunkLoadError",d.type=a,d.request=c,n[1](d)}o[e]=void 0}};var f=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(t)},i.m=e,i.c=a,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)i.d(n,a,function(t){return e[t]}.bind(null,a));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=t,s=s.slice();for(var d=0;d<s.length;d++)t(s[d]);var f=l;r.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"17e1":function(e,t,n){"use strict";var a=n("260b"),c=(n("e71f"),{apiKey:"AIzaSyCY-UrWAhIekYvrVfrdMLpX9hXuStFDG6o",authDomain:"frontend-69a53.firebaseapp.com",projectId:"frontend-69a53",storageBucket:"frontend-69a53.appspot.com",messagingSenderId:"566533900429",appId:"1:566533900429:web:1f6d6c09f2461d8a09fac4s"}),o=a["a"].initializeApp(c);t["a"]=o.firestore()},"365c":function(e,t,n){"use strict";n.d(t,"a",(function(){return i})),n.d(t,"b",(function(){return s}));n("99af");var a=n("bc3a"),c=n.n(a),o=(n("d3b7"),n("4360"));function r(e){return e.interceptors.request.use((function(e){return e.headers.Authorization=o["a"].state.token,e}),(function(e){return Promise.reject(e)})),e.interceptors.response.use((function(e){return e}),(function(e){return Promise.reject(e)})),e}var u=function(e){return c.a.create({baseURL:"".concat("https://porest.kr").concat(e)})},i=u("/api"),s=r(u("/api"))},3786:function(e,t,n){"use strict";n.d(t,"e",(function(){return c})),n.d(t,"d",(function(){return o})),n.d(t,"a",(function(){return r})),n.d(t,"c",(function(){return u})),n.d(t,"b",(function(){return i})),n.d(t,"f",(function(){return s}));var a=n("365c"),c=function(e){return a["a"].post("/signup",e).then((function(e){return{status:!0,message:"이메일을 확인해주세요"}})).catch((function(e){return{status:!1,message:"다시 시도해 주세요"}}))},o=function(e){return a["a"].post("/login",e).then((function(e){return{status:!0,message:"",data:e.data}})).catch((function(e){return{status:!1,message:"다시 시도해 주세요"}}))},r=function(e){return a["a"].post("/email-check",e).then((function(e){return{status:!0,message:"",data:e.data}})).catch((function(e){return{status:!1,message:"다시 시도해 주세요"}}))},u=function(e){return a["a"].post("/find-password",e).then((function(e){return{status:!0,message:"이메일을 확인해주세요"}})).catch((function(e){return{status:!1,message:err.response.data.message}}))},i=function(e){return a["a"].post("/email-verify",e).then((function(e){return{status:!0,message:"이메일을 확인해 주세요"}})).catch((function(e){return{status:!1,message:e.response.data.message}}))},s=function(e){return a["a"].post("/verify-check",e).then((function(e){return{status:!0,message:"",data:e.data}})).catch((function(e){return{status:!1,message:e.response.data.message}}))}},4360:function(e,t,n){"use strict";var a=n("2b0e"),c=n("2f62"),o=n("6a1d"),r={id:Object(o["c"])()||"",uid:Object(o["g"])()||"",email:Object(o["b"])()||"",nickname:Object(o["e"])()||"",token:Object(o["a"])()?"".concat(Object(o["a"])()):"",profileImg:Object(o["d"])()||"",temperature:Object(o["f"])()||"",thisMonthFeelings:[],targetDateId:0,targetDateDetail:"",stickerindex:0,selectedSticker:"",emotionIndex:0,diaryModalStatus:"",targetDate:[],modalControl:!1,refreshCalendar:!1,thisMonth:[],thisMonthWithEmoji:[],counselId:null,selectedStory:null,allLetters:null,modalProfileSetting:!1,profileImgToShow:0,logoStatus:!0,snackbarStatus:!1},u=(n("a9e3"),n("ac1f"),n("1276"),{getFeeling:function(e){return Number(e.targetDateDetail["feeling"])-1},getStickerIndex:function(e){var t=e.targetDateDetail["imageUrl"];return Number(t.split(".")[0])-1},getRefreshCalendar:function(e){return e.refreshCalendar},getUpdateFeeling:function(e){return e.emotionIndex},getUpdateEmotion:function(e){return e.selectedSticker},getAuthToken:function(e){return e.token},getUpdateProfileImg:function(e){return e.profileImg},getUpdateProfileImgFinal:function(e){return e.profileImgToShow}}),i={setUserId:function(e,t){e.id=t},setUserUid:function(e,t){e.uid=t},setUsername:function(e,t){e.nickname=t},setUserEmail:function(e,t){e.email=t},setToken:function(e,t){e.token=t},setImg:function(e,t){e.profileImg=t},setTemperature:function(e,t){e.temperature=t},getThisMonthFeelings:function(e,t){e.thisMonthFeelings=t},getTargetDateId:function(e,t){e.targetDateId=t},getTargetDateDetail:function(e,t){e.targetDateDetail=t},getStickerIndex:function(e,t){e.stickerindex=t},getSelectedSticker:function(e,t){e.selectedSticker=t},getEmotionIndex:function(e,t){e.emotionIndex=t},getDiaryModalStatus:function(e,t){e.diaryModalStatus=t},getTargetDate:function(e,t){e.targetDate=t},getModalStatus:function(e,t){e.modalControl=t},getCalendarRefreshStatus:function(e,t){e.refreshCalendar=t},getThisMonth:function(e,t){e.thisMonth=t},getThisMonthEmoji:function(e,t){e.thisMonthWithEmoji=t},setCounselId:function(e,t){e.counselId=t},setSelectedStory:function(e,t){e.selectedStory=t},setAllLetters:function(e,t){e.allLetters=t},setModalProfile:function(e,t){e.modalProfileSetting=t},setProfileImgToShow:function(e,t){e.profileImgToShow=t},setLogoStatus:function(e,t){e.logoStatus=t},setSnackbarStatus:function(e,t){e.snackbarStatus=t}},s=n("1da1"),l=(n("96cf"),n("3786")),d=n("1232"),f={LOGIN:function(e,t){return Object(s["a"])(regeneratorRuntime.mark((function n(){var a,c,r;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return a=e.commit,n.next=3,Object(l["d"])(t);case 3:return c=n.sent,r=Object(d["a"])(c.data.token),a("setUserId",r.id),a("setUsername",r.nickname),a("setUserEmail",r.email),a("setToken","Bearer "+c.data.token),a("setImg",r.profile_img_number),a("setTemperature",r.temperature),Object(o["j"])(r.id),Object(o["l"])(r.nickname),Object(o["i"])(r.email),Object(o["h"])("Bearer "+c.data.token),Object(o["k"])(r.profile_img_number),Object(o["m"])(r.temperature),n.abrupt("return",c.data);case 18:case"end":return n.stop()}}),n)})))()},LOGOUT:function(e){return Object(s["a"])(regeneratorRuntime.mark((function t(){var n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:n=e.commit,n("setUserId",""),n("setUsername",""),n("setUserEmail",""),n("setToken",""),n("setImg",""),n("setTemperature",""),n("setUserUid",""),Object(o["j"])(""),Object(o["l"])(""),Object(o["i"])(""),Object(o["h"])(""),Object(o["k"])(""),Object(o["m"])(""),Object(o["n"])("null");case 15:case"end":return t.stop()}}),t)})))()},saveuUserUid:function(e,t){var n=e.commit;n("setUserUid",t.firebaseData.uid),Object(o["n"])(t.firebaseData.uid)},saveSelectedCounselId:function(e,t){var n=e.commit;n("setCounselId",t)},saveSelectedStory:function(e,t){var n=e.commit;n("setSelectedStory",t)},saveAllLetters:function(e,t){var n=e.commit;n("setAllLetters",t)},saveSnackbarStatus:function(e,t){var n=e.commit;n("setSnackbarStatus",t)}};a["a"].use(c["a"]);t["a"]=new c["a"].Store({state:r,getters:u,mutations:i,actions:f,modules:{}})},"452c":function(e,t,n){},4557:function(e,t,n){"use strict";n("95f1")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),c=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app__main",attrs:{id:"app"}},[e._m(0),e._m(1),n("div",{staticClass:"music__player"},[n("div",{staticClass:"music-player__wrapper"},[n("div",{staticClass:"music-player music-player--disabled",attrs:{id:"music-container"}},[e._m(2),n("div",{staticClass:"music-player__bar music-player__bar1"}),n("div",{staticClass:"music-player__bar music-player__bar2"}),n("div",{staticClass:"music-player__bar music-player__bar3"}),n("div",{staticClass:"music-player__bar music-player__bar4"}),n("button",{staticClass:"music-player__button music-player__play",on:{click:function(t){return t.preventDefault(),e.controlMusic("play")}}},[n("span",{staticClass:"sr-only"},[e._v("Play")])]),n("button",{staticClass:"music-player__button music-player__pause",on:{click:function(t){return t.preventDefault(),e.controlMusic("pause")}}},[n("span",{staticClass:"sr-only"},[e._v("Pause")])])])])]),n("nav",{attrs:{id:"nav"}},[e._m(3),e.$store.state.id?n("ul",{staticClass:"nav_ul"},[n("li",{on:{click:e.goToMain}},[n("span",{staticClass:"nav-detail"},[e._v("홈")])]),n("li",{on:{click:e.goToMailbox}},[n("span",{staticClass:"nav-detail"},[e._v("우체통")])]),n("li",{on:{click:e.goToFeelingRecord}},[n("span",{staticClass:"nav-detail"},[e._v("하루일기")])]),n("li",{on:{click:e.goToVideoChat}},[n("span",{staticClass:"nav-detail"},[e._v("마음나눔")])]),n("li",{on:{click:e.goToJoy}},[n("span",{staticClass:"nav-detail"},[e._v("쉼터")])]),n("li",{staticClass:"nav-detail",on:{click:e.logout}},[e._v("로그아웃")])]):n("ul",{staticClass:"nav_ul"},[n("li",[e._v("로그인")])])]),n("router-view",{attrs:{user:e.user},on:{introState:e.introState,introPlay:e.introPlay,controlMusic:e.controlMusic,skip:e.skip,dayoff:e.dayoff,lowvolumn:e.lowvolumn,stopBgm:e.stopBgm}})],1)},o=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"main__background"},[n("div",{staticClass:"day"}),n("div",{staticClass:"night"})])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("audio",{attrs:{id:"audio-player1",loop:"false"}},[a("source",{attrs:{src:n("aa34"),type:"audio/mpeg"}}),a("p",{staticClass:"sr-only"},[e._v(" Your browser does not support the audio element. ")])])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("audio",{attrs:{id:"audio-player",loop:""}},[a("source",{attrs:{src:n("9e04"),type:"audio/mpeg"}}),a("p",{staticClass:"sr-only"},[e._v(" Your browser does not support the audio element. ")])])},function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("button",{staticClass:"nav-icon",attrs:{id:"nav-icon"}},[n("span")])}],r=(n("b0c0"),n("17e1"),n("260b")),u=(n("ea7b"),function(){var e=document.getElementById("nav"),t=e.getElementsByTagName("a");function n(){e.classList.contains("active")?e.classList.remove("active"):e.classList.add("active")}document.getElementById("nav-icon").addEventListener("click",(function(e){e.preventDefault(),n()}));for(var a=0;a<t.length;a++)t[a].addEventListener("click",(function(){n()}))}),i=function(){var e=!0,t=document.querySelector(".main__background");setInterval((function(){var n=new Date,a=n.getHours();a>=7&&a<=19?e||(e=!0,t.classList.remove("dayoff")):e&&(e=!1,t.classList.add("dayoff"))}),1e3)},s={name:"App",data:function(){return{user:null,rooms:[],loginState:!1,introState:!1}},methods:{lowvolumn:function(){var e=document.querySelector("#audio-player");e.volume=.02},dayoff:function(){var e=document.querySelector(".main__background");e.classList.toggle("dayoff")},skip:function(){var e=document.querySelector("#audio-player1");e.pause(),this.$router.push({name:"MainIsland"})},logout:function(){var e=this;this.loginState=!1,this.$store.dispatch("LOGOUT"),r["a"].auth().signOut().then((function(){e.user=null,"Login"!=e.$router.history.current.name&&e.$router.push({name:"Login"})}))},goToMain:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push({name:"MainIsland"})},goToMailbox:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/mailbox")},goToFeelingRecord:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/feeling-record")},goToVideoChat:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/all/rooms")},goToJoy:function(){var e=document.getElementById("nav");e.classList.remove("active"),this.$router.push("/joy")},stopBgm:function(){console.log("stop");var e=document.querySelector("#audio-player"),t=document.querySelector("#music-container");t.classList.add("music-player--disabled"),e.pause()},playBgm:function(){var e=document.querySelector("#audio-player"),t=document.querySelector("#music-container");t.classList.remove("music-player--disabled"),e.volume=.2,e.play()},controlMusic:function(e){var t=document.querySelector("#audio-player");t.volume=.2;var n=document.querySelector("#music-container");if("play"!=e)n.classList.add("music-player--disabled"),t.pause();else{t.play();var a=this.$router.history.current.name;"Intro"!=a&&"Login"!=a&&this.lowvolumn(),n.classList.remove("music-player--disabled")}},introPlay:function(){var e=document.querySelector("#audio-player1");setTimeout((function(){e.play()}),150),setTimeout((function(){e.pause()}),5650)}},mounted:function(){var e=this;u(),i(),r["a"].auth().onAuthStateChanged((function(t){t&&(e.loginState=!e.loginState,e.user=t,""!=e.$store.state.uid&&"null"!=e.$store.state.uid||e.$store.dispatch("saveuUserUid",{firebaseData:e.user}))}))},created:function(){}},l=s,d=(n("4557"),n("b0a0"),n("2877")),f=Object(d["a"])(l,c,o,!1,null,null,null),m=f.exports,h=n("a18c"),p=n("4360"),b=n("9612"),g=n("10bd"),k=n("7de8");Object(k["z"])(!0),a["a"].use(b["a"]),a["a"].use(g["a"]),a["a"].config.productionTip=!1,new a["a"]({router:h["a"],store:p["a"],render:function(e){return e(m)}}).$mount("#app")},"6a1d":function(e,t,n){"use strict";n.d(t,"h",(function(){return l})),n.d(t,"j",(function(){return r})),n.d(t,"n",(function(){return u})),n.d(t,"l",(function(){return i})),n.d(t,"i",(function(){return s})),n.d(t,"k",(function(){return d})),n.d(t,"m",(function(){return f})),n.d(t,"a",(function(){return v})),n.d(t,"c",(function(){return m})),n.d(t,"g",(function(){return h})),n.d(t,"e",(function(){return p})),n.d(t,"b",(function(){return b})),n.d(t,"d",(function(){return g})),n.d(t,"f",(function(){return k}));n("99af"),n("ac1f"),n("5319");var a=new Date(Date.now()+864e5),c=a.toUTCString(),o=";path=/;secure; expires=".concat(c);function r(e){document.cookie="login_id=".concat(e).concat(o)}function u(e){document.cookie="login_uid=".concat(e).concat(o)}function i(e){document.cookie="login_name=".concat(e).concat(o)}function s(e){document.cookie="login_email=".concat(e).concat(o)}function l(e){document.cookie="login_token=".concat(e).concat(o)}function d(e){document.cookie="login_img=".concat(e).concat(o)}function f(e){document.cookie="login_temperature=".concat(e).concat(o)}function m(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/,"$1")}function h(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_uid\s*=\s*([^;]*).*$)|^.*$/,"$1")}function p(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_name\s*=\s*([^;]*).*$)|^.*$/,"$1")}function b(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/,"$1")}function g(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/,"$1")}function k(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_temperature\s*=\s*([^;]*).*$)|^.*$/,"$1")}function v(){return document.cookie.replace(/(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/,"$1")}},"95f1":function(e,t,n){},"9e04":function(e,t,n){e.exports=n.p+"media/backgroundMusic.b78f82d0.mp3"},a18c:function(e,t,n){"use strict";n("d3b7"),n("3ca3"),n("ddb0");var a=n("2b0e"),c=n("8c4f");a["a"].use(c["a"]);var o=[{path:"/",redirect:"/login"},{path:"/main",name:"MainIsland",component:function(){return Promise.all([n.e("chunk-26347e98"),n.e("chunk-cf8d7028")]).then(n.bind(null,"2048"))}},{path:"/login",name:"Login",component:function(){return n.e("chunk-02223004").then(n.bind(null,"9905"))}},{path:"/signup",name:"Signup",component:function(){return n.e("chunk-6562fa0a").then(n.bind(null,"ce61"))}},{path:"/intro",name:"Intro",component:function(){return Promise.all([n.e("chunk-26347e98"),n.e("chunk-3cdb7792")]).then(n.bind(null,"db7d"))}},{path:"/find-password",name:"FindPassword",component:function(){return n.e("chunk-759f3c02").then(n.bind(null,"64cc"))}},{path:"/about",name:"About",component:function(){return n.e("chunk-742e0a9a").then(n.bind(null,"92d2"))}},{path:"/mailbox",name:"Mailbox",component:function(){return n.e("chunk-fe17b4fe").then(n.bind(null,"5132"))}},{path:"/mailbox/letters",name:"WriteLetter",component:function(){return n.e("chunk-84c131f2").then(n.bind(null,"2c06"))}},{path:"/mailbox/random-mail",name:"RandomMail",component:function(){return Promise.all([n.e("chunk-26347e98"),n.e("chunk-2f68c9d4")]).then(n.bind(null,"8269"))}},{path:"/mailbox/random-mail/rootmail/reply",name:"RootMailReply",component:function(){return n.e("chunk-c3e8de5c").then(n.bind(null,"a0a3"))},props:!0},{path:"/mailbox/received",name:"MyReceivedMail",component:function(){return Promise.all([n.e("chunk-26347e98"),n.e("chunk-44352516")]).then(n.bind(null,"8d70"))},props:!0},{path:"/rooms",name:"RoomsPage",component:function(){return n.e("chunk-b5573d9c").then(n.bind(null,"a2da"))}},{path:"/checkin/:hostID/:roomID",name:"CheckIn",component:function(){return n.e("chunk-900bdfc0").then(n.bind(null,"c5a7"))},props:!0},{path:"/profile",name:"Profile",component:function(){return n.e("chunk-35d42017").then(n.bind(null,"3379"))}},{path:"/commingsoon",name:"Commingsoon",component:function(){return n.e("chunk-5bd3232c").then(n.bind(null,"eea0"))}},{path:"/feeling-record",name:"FeelingRecord",component:function(){return n.e("chunk-36acf952").then(n.bind(null,"c1c2"))}},{path:"/drawing",name:"Drawing",component:function(){return n.e("chunk-1f660c7d").then(n.bind(null,"fd81"))}},{path:"/all/rooms",name:"AllRoom",component:function(){return Promise.all([n.e("chunk-26347e98"),n.e("chunk-20838f2f")]).then(n.bind(null,"c52a"))}},{path:"/joy/vr",name:"VrRoom",component:function(){return n.e("chunk-3aced1a4").then(n.bind(null,"372a"))}},{path:"/star3d",name:"Star3D",component:function(){return n.e("chunk-61670627").then(n.bind(null,"73dc"))}},{path:"/mailbox/intro",name:"MailBoxIntro",component:function(){return n.e("chunk-51ee938e").then(n.bind(null,"3368"))}},{path:"/joy",name:"JoyMainPage",component:function(){return n.e("chunk-273412c6").then(n.bind(null,"7c46"))}},{path:"/joy/healing/music",name:"HealingMusic",component:function(){return n.e("chunk-1e11af32").then(n.bind(null,"e2a8"))}},{path:"/admin/ban-report",name:"BanReport",component:function(){return n.e("chunk-1f9537b8").then(n.bind(null,"d1e4"))}}],r=new c["a"]({mode:"history",base:"/",routes:o});t["a"]=r},aa34:function(e,t,n){e.exports=n.p+"media/introvoice.22721559.mp3"},b0a0:function(e,t,n){"use strict";n("452c")}});
//# sourceMappingURL=app.820b25c8.js.map