(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-97de0c14"],{"65d4":function(t,e,o){"use strict";o.r(e);var n=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"text-wrapper"},[o("h1",{on:{click:t.moveToServer}},[t._v("Scroll")]),t._m(0),t._m(1)])},r=[function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"progress"},[o("span",{staticClass:"progress-bar"})])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"cloud-wrap"},[n("img",{attrs:{src:o("a179"),alt:"Cloud"}}),n("img",{attrs:{src:o("a179"),alt:"Cloud"}}),n("img",{attrs:{src:o("a179"),alt:"Cloud"}})])}],c=o("bc3a"),s=o.n(c),l={name:"Test",data:function(){return{}},mounted:function(){this.scrollEffect()},methods:{scrollEffect:function(){var t=0,e=document.querySelector(".progress-bar"),o=document.querySelector(".cloud-wrap");window.addEventListener("scroll",(function(){t=document.documentElement.scrollTop,console.log("scrollTop",t);var n=Math.ceil(t/(document.body.scrollHeight-window.innerHeight)*100);console.log("per",n),e.style.width=n+"%",o.style.transform="translate(0,"+t/1.4+"px)"}))},moveToServer:function(){s.a.get("http://localhost:3000/",{params:{data:""}}).then((function(t){console.log(t)}))}}},a=l,i=(o("d626"),o("2877")),u=Object(i["a"])(a,n,r,!1,null,"33f10726",null);e["default"]=u.exports},a179:function(t,e,o){t.exports=o.p+"img/cloud.02a1dc05.png"},d626:function(t,e,o){"use strict";o("f254")},f254:function(t,e,o){}}]);
//# sourceMappingURL=chunk-97de0c14.494bf37b.js.map