(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-31a11574"],{c6fc:function(e,t,a){},e38f:function(e,t,a){"use strict";a("c6fc")},fd81:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"drawing-wrapper amongus"},[a("div",{staticClass:"back"},[a("i",{staticClass:"fas fa-arrow-left",on:{click:e.moveToBack}})]),a("div",{attrs:{id:"content"}},[a("form",[a("div",{staticClass:"change__drawing__header"},[e._v("도안 선택하기")]),e._m(0),a("div",{staticClass:"color__wrapper"},[a("ejs-colorpicker",{attrs:{id:"color"},on:{change:e.color},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}),a("div",{staticClass:"color-code",attrs:{"data-value":e.value}},[e._v(e._s(e.value))]),a("div",{staticClass:"colo__header"},[e._v(": 색상")])],1),e._m(1),e._m(2)]),a("canvas",{attrs:{id:"drawing-canvas"}})])])},o=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("select",{staticClass:"change__drawing "},[a("option",{staticClass:"draw",attrs:{value:"amongus"}},[e._v("어몽어스")]),a("option",{staticClass:"draw",attrs:{value:"pokect"}},[e._v("포켓몬")]),a("option",{staticClass:"draw",attrs:{value:"pichu"}},[e._v("피츄")]),a("option",{staticClass:"draw",attrs:{value:"uchu"}},[e._v("우츠보트")]),a("option",{staticClass:"draw",attrs:{value:"fire"}},[e._v("파이어")]),a("option",{staticClass:"draw",attrs:{value:"digdag"}},[e._v("디그다그")])])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"thickness__wrapper"},[a("input",{attrs:{type:"number",id:"thickness",min:"1",max:"25",value:"5"}}),a("div",{staticClass:"thickness__header"},[e._v(": 펜 굵기")])])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"controls__btns"},[a("div",{staticClass:"undo"},[e._v("작업 취소")]),a("div",{staticClass:"clear",attrs:{colorformat:"rgba"}},[e._v("초기화")])])}],c="#ffffff",r=!1,s=[],i="",l=function(e){c=e,r=!0},u=function(){var e=document.querySelector(".drawing-wrapper"),t=document.querySelector(".change__drawing");t.addEventListener("change",(function(t){console.log("chae",t.target.value);var a=t.target.value;""==i?(i=a,e.classList.add(a)):(e.classList.remove(i),e.classList.add(a),i=a)}));var a=document.querySelector("#drawing-canvas"),n=a.getContext("2d"),o=document.querySelector("#content"),l=getComputedStyle(o),u=-1;a.width=parseInt(l.getPropertyValue("width")),a.height=parseInt(l.getPropertyValue("height"));var d={x:0,y:0};a.addEventListener("mousemove",(function(e){d.x=e.clientX-this.offsetLeft,d.y=e.clientY-this.offsetTop})),n.lineWidth=5,n.lineJoin="round",n.lineCap="round";var v=document.querySelector("#thickness"),f=document.querySelector("#color"),h=document.querySelector(".e-dropdown-btn");function m(){var e=document.querySelector("#thickness").value;n.lineWidth=e}h.addEventListener("click",(function(){console.log("color pick");var e=document.querySelector(".e-apply");e.addEventListener("click",(function(){g()}))})),v.addEventListener("change",m),f.addEventListener("change",(function(e){g(e)}));var g=function(){console.log(c),n.strokeStyle=c};r&&(console.log("changed"),g()),a.addEventListener("mousedown",(function(){n.beginPath(),n.moveTo(d.x,d.y),a.addEventListener("mousemove",y,!1)}),!1),a.addEventListener("mouseup",(function(){s.push(n.getImageData(0,0,a.width,a.height)),u+=1,console.log("restore array",s),a.removeEventListener("mousemove",y,!1)}),!1);var p=document.querySelector(".clear"),_=document.querySelector(".undo");function w(){n.clearRect(0,0,a.width,a.height),s=[],u=-1}function k(){u<=0?w():(u-=1,s.pop(),n.putImageData(s[u],0,0))}p.addEventListener("click",w),_.addEventListener("click",k);var y=function(){n.lineTo(d.x,d.y),n.stroke()}},d={name:"Drawingpage",data:function(){return{value:null,image:"../../assets/image/amongus.jpg"}},components:{},created:function(){var e=this.$store.getters.getAuthToken;""!=e&&null!=e||(alert("로그인이 필요합니다."),this.$router.push({name:"Login"}))},mounted:function(){var e=this;u();var t=document.querySelector(".e-dropdown-btn");t.addEventListener("click",(function(){var t=document.querySelector(".e-hsv-color"),a=document.querySelector(".e-hex");console.log("오픈",t),t.addEventListener("click",(function(){e.color(a.value)}))}))},methods:{color:function(e){console.log("change"),l(e)},moveToBack:function(){this.$router.go(-1)}}},v=d,f=(a("e38f"),a("2877")),h=Object(f["a"])(v,n,o,!1,null,"5f368cf6",null);t["default"]=h.exports}}]);
//# sourceMappingURL=chunk-31a11574.b7482f04.js.map