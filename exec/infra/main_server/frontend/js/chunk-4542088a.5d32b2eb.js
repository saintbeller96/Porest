(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4542088a"],{"159b":function(o,t,e){var n=e("da84"),r=e("fdbc"),c=e("17c2"),a=e("9112");for(var i in r){var u=n[i],s=u&&u.prototype;if(s&&s.forEach!==c)try{a(s,"forEach",c)}catch(f){s.forEach=c}}},"17c2":function(o,t,e){"use strict";var n=e("b727").forEach,r=e("a640"),c=r("forEach");o.exports=c?[].forEach:function(o){return n(this,o,arguments.length>1?arguments[1]:void 0)}},"1dde":function(o,t,e){var n=e("d039"),r=e("b622"),c=e("2d00"),a=r("species");o.exports=function(o){return c>=51||!n((function(){var t=[],e=t.constructor={};return e[a]=function(){return{foo:1}},1!==t[o](Boolean).foo}))}},"65f0":function(o,t,e){var n=e("861d"),r=e("e8b5"),c=e("b622"),a=c("species");o.exports=function(o,t){var e;return r(o)&&(e=o.constructor,"function"!=typeof e||e!==Array&&!r(e.prototype)?n(e)&&(e=e[a],null===e&&(e=void 0)):e=void 0),new(void 0===e?Array:e)(0===t?0:t)}},8418:function(o,t,e){"use strict";var n=e("c04e"),r=e("9bf2"),c=e("5c6c");o.exports=function(o,t,e){var a=n(t);a in o?r.f(o,a,c(0,e)):o[a]=e}},"99af":function(o,t,e){"use strict";var n=e("23e7"),r=e("d039"),c=e("e8b5"),a=e("861d"),i=e("7b0b"),u=e("50c4"),s=e("8418"),f=e("65f0"),l=e("1dde"),d=e("b622"),m=e("2d00"),h=d("isConcatSpreadable"),v=9007199254740991,p="Maximum allowed index exceeded",b=m>=51||!r((function(){var o=[];return o[h]=!1,o.concat()[0]!==o})),g=l("concat"),y=function(o){if(!a(o))return!1;var t=o[h];return void 0!==t?!!t:c(o)},w=!b||!g;n({target:"Array",proto:!0,forced:w},{concat:function(o){var t,e,n,r,c,a=i(this),l=f(a,0),d=0;for(t=-1,n=arguments.length;t<n;t++)if(c=-1===t?a:arguments[t],y(c)){if(r=u(c.length),d+r>v)throw TypeError(p);for(e=0;e<r;e++,d++)e in c&&s(l,d,c[e])}else{if(d>=v)throw TypeError(p);s(l,d++,c)}return l.length=d,l}})},a2da:function(o,t,e){"use strict";e.r(t);var n=function(){var o=this,t=o.$createElement,e=o._self._c||t;return e("div",[e("form",[e("label",{attrs:{for:"roomNmae"}},[o._v("RoomName")]),e("input",{directives:[{name:"model",rawName:"v-model",value:o.roomName,expression:"roomName"}],ref:"roomName",staticClass:"form-control",attrs:{type:"text",name:"roomName",placeholder:"Room name","aria-describedby":"buttonAdd"},domProps:{value:o.roomName},on:{input:function(t){t.target.composing||(o.roomName=t.target.value)}}}),e("button",{staticClass:"btn btn-sm btn-info",attrs:{type:"submit",id:"buttonAdd"},on:{click:function(t){return t.preventDefault(),o.addRoom(t)}}},[o._v(" + ")])]),o._l(o.rooms,(function(t,n){return e("div",{key:n},[e("div",{on:{click:function(e){return o.moveToCheckIn(t.id)}}},[o._v(o._s(t.name))]),e("span",{on:{click:function(e){return o.deleteRoom(t.id)}}},[o._v("Delete")])])}))],2)},r=[],c=(e("159b"),e("b0c0"),e("99af"),e("17e1")),a=e("260b"),i=(e("ea7b"),{name:"RoomsPage",data:function(){return{roomName:null,uid:this.$store.state.uid,rooms:[]}},props:["user"],mounted:function(){var o=this;if(console.log(this.rooms),0==this.rooms.length){console.log("시작한다");var t=c["a"].collection("users");t.get().then((function(e){e.forEach((function(e){t.doc(e.id).collection("rooms").onSnapshot((function(t){console.log("read",o.rooms),t.forEach((function(t){o.rooms.push({id:t.id,hostID:e.id,name:t.data().name})})),console.log(o.rooms)}))}))}))}},methods:{addRoom:function(){console.log(this.user.nickName);var o=c["a"].collection("users").doc(this.user.uid);o.set({name:this.user.uid}),o.collection("rooms").add({name:this.roomName,createdAt:a["a"].firestore.FieldValue.serverTimestamp()})},deleteRoom:function(o){c["a"].collection("users").doc(this.user.uid).collection("rooms").doc(o).delete()},moveToCheckIn:function(o){this.$router.push("/checkin/".concat(this.uid,"/").concat(o))}}}),u=i,s=e("2877"),f=Object(s["a"])(u,n,r,!1,null,null,null);t["default"]=f.exports},a640:function(o,t,e){"use strict";var n=e("d039");o.exports=function(o,t){var e=[][o];return!!e&&n((function(){e.call(null,t||function(){throw 1},1)}))}},b0c0:function(o,t,e){var n=e("83ab"),r=e("9bf2").f,c=Function.prototype,a=c.toString,i=/^\s*function ([^ (]*)/,u="name";n&&!(u in c)&&r(c,u,{configurable:!0,get:function(){try{return a.call(this).match(i)[1]}catch(o){return""}}})},b727:function(o,t,e){var n=e("0366"),r=e("44ad"),c=e("7b0b"),a=e("50c4"),i=e("65f0"),u=[].push,s=function(o){var t=1==o,e=2==o,s=3==o,f=4==o,l=6==o,d=7==o,m=5==o||l;return function(h,v,p,b){for(var g,y,w=c(h),x=r(w),E=n(v,p,3),N=a(x.length),k=0,A=b||i,_=t?A(h,N):e||d?A(h,0):void 0;N>k;k++)if((m||k in x)&&(g=x[k],y=E(g,k,w),o))if(t)_[k]=y;else if(y)switch(o){case 3:return!0;case 5:return g;case 6:return k;case 2:u.call(_,g)}else switch(o){case 4:return!1;case 7:u.call(_,g)}return l?-1:s||f?f:_}};o.exports={forEach:s(0),map:s(1),filter:s(2),some:s(3),every:s(4),find:s(5),findIndex:s(6),filterOut:s(7)}},e8b5:function(o,t,e){var n=e("c6b6");o.exports=Array.isArray||function(o){return"Array"==n(o)}}}]);
//# sourceMappingURL=chunk-4542088a.5d32b2eb.js.map