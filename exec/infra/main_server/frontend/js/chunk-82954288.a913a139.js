(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-82954288"],{"159b":function(t,e,n){var r=n("da84"),a=n("fdbc"),i=n("17c2"),o=n("9112");for(var c in a){var s=r[c],u=s&&s.prototype;if(u&&u.forEach!==i)try{o(u,"forEach",i)}catch(l){u.forEach=i}}},1723:function(t,e,n){t.exports=n.p+"img/postbox_1.6a5f49e0.svg"},"17c2":function(t,e,n){"use strict";var r=n("b727").forEach,a=n("a640"),i=a("forEach");t.exports=i?[].forEach:function(t){return r(this,t,arguments.length>1?arguments[1]:void 0)}},"546b":function(t,e,n){"use strict";n("ed8a")},"71ea":function(t,e,n){"use strict";n.d(e,"b",(function(){return a})),n.d(e,"e",(function(){return i})),n.d(e,"c",(function(){return o})),n.d(e,"d",(function(){return c})),n.d(e,"a",(function(){return s}));var r=n("365c"),a=function(){return r["b"].get("/stories").then((function(t){return t.data}))},i=function(t){return r["b"].post("/stories",t)},o=function(t){return r["b"].get("/stories/".concat(t,"/counsels")).then((function(t){return t.data}))},c=function(t){return r["b"].post("/stories/".concat(t)).then((function(t){return t.data}))},s=function(){return r["b"].get("/stories/candidates").then((function(t){return t.data}))}},"81d5":function(t,e,n){"use strict";var r=n("7b0b"),a=n("23cb"),i=n("50c4");t.exports=function(t){var e=r(this),n=i(e.length),o=arguments.length,c=a(o>1?arguments[1]:void 0,n),s=o>2?arguments[2]:void 0,u=void 0===s?n:a(s,n);while(u>c)e[c++]=t;return e}},8269:function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"random-mail"},[r("span",{staticClass:"back",on:{click:t.goOneStepBack}},[r("i",{staticClass:"fas fa-arrow-left"})]),r("div",{staticClass:"random_title"},[t._v("당신을 기다리고 있는 편지가 있습니다.")]),r("div",{staticClass:"random_subtitle"},[t._v("아래 우체통을 클릭해주세요.")]),t._m(0),r("Star",{staticClass:"star"}),r("canvas",{staticClass:"fireworks"}),r("div",{staticClass:"random-ball-wrapper",on:{click:t.pop}},[r("object",{attrs:{data:t.post_box_svg,type:"image/svg+xml"}})]),t._m(1),r("div",{staticClass:"mystery"},t._l(t.stories,(function(e,a){return r("div",{key:a,on:{click:function(n){return t.goToRootMailReply(e)}}},[r("img",{attrs:{src:n("f944"),alt:""}})])})),0)],1)},a=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"click_arrow"},[r("img",{attrs:{src:n("c046"),alt:""}})])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"big"},[n("div"),n("div")])}],i=n("1da1"),o=(n("96cf"),n("53f2")),c=(n("cb29"),n("a434"),n("159b"),function(){var t=function(){return parseFloat(getComputedStyle(document.documentElement).fontSize)},e=document.querySelector(".fireworks"),n=e.getContext("2d"),r=24,a=200,i=0,o=0,c=[],s=function(){e.width=window.innerWidth,e.height=window.innerHeight},u=function(t){i=t.clientX||t.touches[0].clientX,o=t.clientY||t.touches[0].clientY},l=["#b721ff","#00dbde","#ff758c","#0fd850"],d=function(t,e){var r={};return r.x=t,r.y=e,r.color=l[anime.random(0,l.length-1)],r.color="#FFF",r.radius=0,r.alpha=1,r.lineWidth=6,r.draw=function(){n.globalAlpha=r.alpha,n.beginPath(),n.arc(Math.abs(r.x),Math.abs(r.y),Math.abs(r.radius),0,2*Math.PI,!0),n.lineWidth=r.lineWidth,n.strokeStyle=r.color,n.stroke(),n.globalAlpha=1},r},f=function(e,r){var a={};a.x=e,a.y=r,a.color=l[anime.random(0,l.length-1)],a.radius=anime.random(t(),2*t());while(a.radius<0)a.radius=anime.random(t(),2*t());return a.draw=function(){n.beginPath(),n.arc(a.x,a.y,a.radius,0,2*Math.PI,!0),n.fillStyle=a.color,n.fill()},a},h=function(t,e){for(var n=[],a=0;a<r;a++){var i=f(t,e);n.push(i)}return n},m=function(t){var e=c.indexOf(t);e>-1&&c.splice(e,1)},p=function(e,n){s();var r=h(e,n),i=d(e,n),o=anime({targets:r,x:function(t){return t.x+anime.random(-a,a)},y:function(t){return t.y+anime.random(-a,a)},radius:0,duration:function(){return anime.random(1200,1800)},easing:"easeOutExpo",complete:m}),u=anime({targets:i,radius:function(){return anime.random(8.75*t(),11.25*t())},lineWidth:0,alpha:{value:0,easing:"linear",duration:function(){return anime.random(400,600)}},duration:function(){return anime.random(1e3,1200)},easing:"easeOutExpo",complete:m});c.push(o),c.push(u)};anime({duration:1/0,update:function(){n.clearRect(0,0,e.width,e.height),c.forEach((function(t){t.animatables.forEach((function(t){t.target.draw()}))}))}});return document.addEventListener("click",(function(t){u(t),p(i,o)}),!1),window.addEventListener("resize",s,!1),{boom:p}}),s=n("71ea"),u={name:"RandomMail",data:function(){return{randomMails:[1,2,3,4,5,6],stories:[],post_box_svg:n("1723")}},components:{Star:o["a"]},methods:{getRandomStories:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(s["a"])();case 2:t.stories=e.sent;case 3:case"end":return e.stop()}}),e)})))()},goToRootMailReply:function(t){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function n(){return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,e.$store.dispatch("saveSelectedStory",t);case 2:setTimeout((function(){e.$router.push({name:"RootMailReply"})}),800);case 3:case"end":return n.stop()}}),n)})))()},pop:function(t){t.target.classList.add("pop-ball");var e=document.querySelector(".big"),n=document.querySelector(".mystery"),r=document.querySelector(".random_subtitle"),a=document.querySelector(".click_arrow");e.classList.add("show"),n.classList.add("show"),r.classList.add("hide"),a.classList.add("hide"),setTimeout((function(){c()}),3e3)},goOneStepBack:function(){history.go(-1)}},mounted:function(){this.getRandomStories()},created:function(){var t=this.$store.getters.getAuthToken;""!=t&&null!=t||(alert("로그인이 필요합니다."),this.$router.push({name:"Login"}))}},l=u,d=(n("546b"),n("2877")),f=Object(d["a"])(l,r,a,!1,null,"6dc90d5b",null);e["default"]=f.exports},a434:function(t,e,n){"use strict";var r=n("23e7"),a=n("23cb"),i=n("a691"),o=n("50c4"),c=n("7b0b"),s=n("65f0"),u=n("8418"),l=n("1dde"),d=l("splice"),f=Math.max,h=Math.min,m=9007199254740991,p="Maximum allowed length exceeded";r({target:"Array",proto:!0,forced:!d},{splice:function(t,e){var n,r,l,d,g,v,b=c(this),w=o(b.length),y=a(t,w),x=arguments.length;if(0===x?n=r=0:1===x?(n=0,r=w-y):(n=x-2,r=h(f(i(e),0),w-y)),w+n-r>m)throw TypeError(p);for(l=s(b,r),d=0;d<r;d++)g=y+d,g in b&&u(l,d,b[g]);if(l.length=r,n<r){for(d=y;d<w-r;d++)g=d+r,v=d+n,g in b?b[v]=b[g]:delete b[v];for(d=w;d>w-r+n;d--)delete b[d-1]}else if(n>r)for(d=w-r;d>y;d--)g=d+r-1,v=d+n-1,g in b?b[v]=b[g]:delete b[v];for(d=0;d<n;d++)b[d+y]=arguments[d+2];return b.length=w-r+n,l}})},a640:function(t,e,n){"use strict";var r=n("d039");t.exports=function(t,e){var n=[][t];return!!n&&r((function(){n.call(null,e||function(){throw 1},1)}))}},b727:function(t,e,n){var r=n("0366"),a=n("44ad"),i=n("7b0b"),o=n("50c4"),c=n("65f0"),s=[].push,u=function(t){var e=1==t,n=2==t,u=3==t,l=4==t,d=6==t,f=7==t,h=5==t||d;return function(m,p,g,v){for(var b,w,y=i(m),x=a(y),_=r(p,g,3),k=o(x.length),E=0,S=v||c,R=e?S(m,k):n||f?S(m,0):void 0;k>E;E++)if((h||E in x)&&(b=x[E],w=_(b,E,y),t))if(e)R[E]=w;else if(w)switch(t){case 3:return!0;case 5:return b;case 6:return E;case 2:s.call(R,b)}else switch(t){case 4:return!1;case 7:s.call(R,b)}return d?-1:u||l?l:R}};t.exports={forEach:u(0),map:u(1),filter:u(2),some:u(3),every:u(4),find:u(5),findIndex:u(6),filterOut:u(7)}},c046:function(t,e,n){t.exports=n.p+"img/click_arrow1.fb469a9b.png"},cb29:function(t,e,n){var r=n("23e7"),a=n("81d5"),i=n("44d2");r({target:"Array",proto:!0},{fill:a}),i("fill")},ed8a:function(t,e,n){},f944:function(t,e,n){t.exports=n.p+"img/letter_1.f9eeae95.png"}}]);
//# sourceMappingURL=chunk-82954288.a913a139.js.map