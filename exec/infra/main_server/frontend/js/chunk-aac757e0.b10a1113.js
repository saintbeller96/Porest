(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-aac757e0"],{"14fb":function(t,i,n){"use strict";n.r(i);var a=function(){var t=this,i=t.$createElement,n=t._self._c||i;return n("div",{staticClass:"post_plane_main"},[n("div",{staticClass:"post_main_wrapper"},[t._m(0),t._m(1),n("div",{staticClass:"plane_fold"},[n("svg",{attrs:{height:"100%",version:"1.1",width:"100%","xml:space":"preserve",xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink"}},[n("g",{attrs:{id:"plane"}},[n("polygon",{staticStyle:{fill:"#ffffff"},attrs:{id:"top_left_wing",points:"150,150, 150,0, 0,150"}}),n("polygon",{staticStyle:{fill:"#ffffff"},attrs:{id:"top_right_wing",points:"150,0 150,150 300,150"}}),n("polygon",{staticStyle:{fill:"#ffffff"},attrs:{id:"left_wing",points:"150,0 90,150 0,150"}}),n("polygon",{staticStyle:{fill:"#ffffff"},attrs:{id:"right_wing",points:"150,0 210,150 300,150"}}),n("polygon",{staticStyle:{fill:"#ffffff"},attrs:{id:"left_bottom",points:"0,150 150,150 150,190 90,150","stroke-width":"0.5"}}),n("polygon",{staticStyle:{fill:"#ffffff"},attrs:{id:"right_bottom",points:"150,150 300,150 210,150 150,190","stroke-width":"0.5"}}),n("polygon",{attrs:{id:"left_inside_wing",points:"150,0 210,150 150,190",fill:"#eeeeee",stroke:"#dddddd","stroke-width":"1"}}),n("polygon",{staticStyle:{fill:"#eeeeee"},attrs:{id:"right_inside_wing",points:"150,0 90,150 150,190",stroke:"#dddddd","stroke-width":"1"}})])])])])])},o=[function(){var t=this,i=t.$createElement,n=t._self._c||i;return n("div",{staticClass:"post_main post_main_container"},[n("div",{staticClass:"post_main_wall post_wall_back"}),n("div",{staticClass:"post_main_wall post_wall_left"}),n("div",{staticClass:"post_main_wall post_wall_right"}),n("div",{staticClass:"post_main_wall post_wall_bottom"})])},function(){var t=this,i=t.$createElement,a=t._self._c||i;return a("div",{staticClass:"planesvg",attrs:{id:"planesvg"}},[a("img",{attrs:{src:n("cdab"),alt:""}})])}],e=function(){document.addEventListener("DOMContentLoaded",(function(){setTimeout(rotate_and_fly,5e3)})),rotate_and_fly=function(){var t=Snap("#left_inside_wing"),i=Snap("#right_inside_wing"),n=Snap("#left_wing"),a=Snap("#right_wing");t.animate({fill:"#ffffff",stroke:"white"},600),i.animate({fill:"#ffffff",stroke:"white"},600),n.animate({stroke:"white"},500),a.animate({stroke:"white"},500),fold_left_top_wing()},fold_left_top_wing=function(){var t=Snap("#top_left_wing");Snap.animate(t.attr("points"),[0,0,150,0,0,150],(function(i){t.attr({points:i})}),500,mina.easeout,fold_right_top_wing),t.animate({stroke:"white"},550)},fold_right_top_wing=function(){var t=Snap("#top_right_wing");Snap.animate(t.attr("points"),[150,0,300,0,300,150],(function(i){t.attr({points:i})}),500,mina.linear,fold_left_bottom_wing),t.animate({stroke:"white"},550)},fold_left_bottom_wing=function(){var t=Snap("#left_bottom");Snap.animate(t.attr("points"),[0,150,150,150,150,190,0,190],(function(i){t.attr({points:i})}),500,mina.linear,fold_right_bottom_wing)},fold_right_bottom_wing=function(){var t=Snap("#right_bottom");Snap.animate(t.attr("points"),[150,150,300,150,300,190,150,190],(function(i){t.attr({points:i})}),500,mina.linear)}},s={mounted:function(){e()}},l=s,f=(n("5504"),n("2877")),_=Object(f["a"])(l,a,o,!1,null,"fb550c08",null);i["default"]=_.exports},5504:function(t,i,n){"use strict";n("d65d")},cdab:function(t,i,n){t.exports=n.p+"img/plane2.7a4f2139.svg"},d65d:function(t,i,n){}}]);
//# sourceMappingURL=chunk-aac757e0.b10a1113.js.map