(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-58f69671"],{3609:function(t,s,a){},"3ea7":function(t,s,a){},"497b":function(t,s,a){"use strict";var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",[a("div",{staticClass:"paper-plane"},[a("svg",{attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 95.04 61.39"}},[a("g",{attrs:{id:"레이어_2","data-name":"레이어 2"}},[a("g",{attrs:{id:"Capa_1","data-name":"Capa 1"}},[a("g",[a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 95.04 23.47 59.64 37.59 0 0"}}),a("polygon",{staticClass:"cls-2",attrs:{points:"59.64 37.59 57.04 56.59 0 0 59.64 37.59"}}),a("polygon",{staticClass:"cls-3",attrs:{points:"51 41.92 57.04 56.59 0 0 51 41.92"}}),a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 51 41.92 17.36 61.39 0 0"}})])])])])]),a("div",{staticClass:"paper-plane"},[a("svg",{attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 95.04 61.39"}},[a("g",{attrs:{id:"레이어_2","data-name":"레이어 2"}},[a("g",{attrs:{id:"Capa_1","data-name":"Capa 1"}},[a("g",[a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 95.04 23.47 59.64 37.59 0 0"}}),a("polygon",{staticClass:"cls-2",attrs:{points:"59.64 37.59 57.04 56.59 0 0 59.64 37.59"}}),a("polygon",{staticClass:"cls-3",attrs:{points:"51 41.92 57.04 56.59 0 0 51 41.92"}}),a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 51 41.92 17.36 61.39 0 0"}})])])])])]),a("div",{staticClass:"paper-plane"},[a("svg",{attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 95.04 61.39"}},[a("g",{attrs:{id:"레이어_2","data-name":"레이어 2"}},[a("g",{attrs:{id:"Capa_1","data-name":"Capa 1"}},[a("g",[a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 95.04 23.47 59.64 37.59 0 0"}}),a("polygon",{staticClass:"cls-2",attrs:{points:"59.64 37.59 57.04 56.59 0 0 59.64 37.59"}}),a("polygon",{staticClass:"cls-3",attrs:{points:"51 41.92 57.04 56.59 0 0 51 41.92"}}),a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 51 41.92 17.36 61.39 0 0"}})])])])])]),a("div",{staticClass:"paper-plane"},[a("svg",{attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 95.04 61.39"}},[a("g",{attrs:{id:"레이어_2","data-name":"레이어 2"}},[a("g",{attrs:{id:"Capa_1","data-name":"Capa 1"}},[a("g",[a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 95.04 23.47 59.64 37.59 0 0"}}),a("polygon",{staticClass:"cls-2",attrs:{points:"59.64 37.59 57.04 56.59 0 0 59.64 37.59"}}),a("polygon",{staticClass:"cls-3",attrs:{points:"51 41.92 57.04 56.59 0 0 51 41.92"}}),a("polygon",{staticClass:"cls-1",attrs:{points:"0 0 51 41.92 17.36 61.39 0 0"}})])])])])])])},n=[],i={},o=i,r=(a("4d75"),a("2877")),c=Object(r["a"])(o,e,n,!1,null,"31be62d8",null);s["a"]=c.exports},"4d75":function(t,s,a){"use strict";a("3ea7")},5464:function(t,s,a){"use strict";function e(t){var s=/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;return s.test(String(t).toLowerCase())}function n(t){var s=/^[A-Za-z0-9+]{8,20}$/;return s.test(t)}a.d(s,"a",(function(){return e})),a.d(s,"b",(function(){return n}))},"6c57":function(t,s,a){"use strict";a("3609")},"7c36":function(t,s,a){"use strict";var e,n,i,o,r,c,l,p,d,u,m,g;a.d(s,"a",(function(){return w})),d=0,u=1e-5,m=window.innerWidth,g=window.innerHeight;var w=function(){v(),h(),window.addEventListener("resize",C,!1)};function v(){n=new THREE.Scene,n.fog=new THREE.FogExp2("#222",.001),e=new THREE.PerspectiveCamera(75,m/g,1,1e3),e.position.z=0,e.position.y=1,e.rotation.x=Math.PI/2;var t=(new THREE.TextureLoader).load("https://s3-us-west-2.amazonaws.com/s.cdpn.io/1823170/star-sprite.png");c=new THREE.PointsMaterial({color:16777215,size:.9,map:t,transparent:!0,blending:THREE.AdditiveBlending}),l=35e3,o=new THREE.Geometry;for(var s=0;s<l;s++){var a=2e3*Math.random()-1e3,d=1e3*Math.random()-1e3,u=2e3*Math.random()-1e3;r=new THREE.Vector3(a,d,u),r.velocity=new THREE.Vector3(0,Math.random(),0),o.vertices.push(r)}p=new THREE.Points(o,c),p.sortParticles=!0,n.add(p),i=new THREE.WebGLRenderer({antialias:!0,alpha:!0}),i.setSize(m,g),document.getElementById("canvas").appendChild(i.domElement)}function h(){requestAnimationFrame(h),n.rotation.y+=d;var t=l;while(t--){var s=o.vertices[t];s.y>1e3&&(s.y=-1e3,s.velocity.y=Math.random()),s.velocity.y+=Math.random()*u,s.add(s.velocity)}p.geometry.verticesNeedUpdate=!0,f()}function f(){e.lookAt(n.position),i.render(n,e)}function C(){e.aspect=window.innerWidth/window.innerHeight,e.updateProjectionMatrix(),i.setSize(window.innerWidth,window.innerHeight)}},9905:function(t,s,a){"use strict";a.r(s);var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"home-wrapper"},[a("section",[a("div",{staticClass:"box"},[a("div",{staticClass:"container"},[a("div",{staticClass:"form"},[a("form",{on:{submit:function(t){t.preventDefault()}}},[a("p",{staticClass:"welcome"},[t._v("Welcome to POREST :)")]),a("p",{staticClass:"title"},[t._v(" Email ")]),a("div",{staticClass:"inputBox"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],staticClass:"input",attrs:{type:"email",placeholder:"이메일 주소를 입력해주세요.",autocomplete:"on"},domProps:{value:t.email},on:{input:function(s){s.target.composing||(t.email=s.target.value)}}})]),t.isValidEmail?t._e():a("p",{staticClass:"error_message"},[t._v(" 잘못된 이메일 양식입니다. ")]),a("p",{staticClass:"title"},[t._v("비밀번호")]),a("div",{staticClass:"inputBox"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password",placeholder:"8~20자의 영문, 숫자 입력",autocomplete:"off"},domProps:{value:t.password},on:{input:function(s){s.target.composing||(t.password=s.target.value)}}})]),!t.isValidPwd&&t.password.length<8?a("p",{staticClass:"error_message"},[t._v(" 8자 이상의 비밀번호를 입력해주세요. ")]):!t.isValidPwd&&t.password.length>20?a("p",{staticClass:"error_message"},[t._v(" 20자 이하의 비밀번호를 입력해주세요. ")]):t._e(),a("button",{staticClass:"button",on:{click:t.submitForm}},[t._v("Login")]),a("div",{staticClass:"go-to-find-password-container"},[a("span",{staticClass:"go-to-find-password",on:{click:t.goToFindPassword}},[t._v("비밀번호 찾기")])]),a("div",{staticClass:"go-to-signup-container"},[a("span",{staticClass:"go-to-signup",on:{click:t.goToSignup}},[t._v("회원가입")])])])])])])]),a("div",{staticClass:"white-show"}),a("div",{attrs:{id:"canvas"}})])},n=[],i=a("1da1"),o=(a("96cf"),a("5464")),r=a("7c36"),c=a("260b"),l=(a("ea7b"),a("497b")),p={components:{AuthForm:l["a"]},data:function(){return{email:"",nickname:"",password:""}},computed:{isValidEmail:function(){return""===this.email||Object(o["a"])(this.email)},isValidPwd:function(){return""===this.password||Object(o["b"])(this.password)},checkForm:function(){return Object(o["a"])(this.email)&&Object(o["b"])(this.password)}},methods:{goToSignup:function(){this.$router.push({name:"Signup"})},goToFindPassword:function(){this.$router.push({name:"FindPassword"})},submitForm:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function s(){return regeneratorRuntime.wrap((function(s){while(1)switch(s.prev=s.next){case 0:return console.log("login"),s.prev=1,s.next=4,t.$store.dispatch("LOGIN",{email:t.email,password:t.password});case 4:console.log("이동"),t.fireBaseLogin(),setTimeout((function(){var t=document.querySelector(".white-show");t.classList.add("active")}),1e3),t.$router.push({name:"Intro"}),s.next=13;break;case 10:s.prev=10,s.t0=s["catch"](1),alert("이메일이나 비밀번호를 다시 확인해주세요.");case 13:case"end":return s.stop()}}),s,null,[[1,10]])})))()},fireBaseLogin:function(){var t=this;console.log("login"),c["a"].auth().signInWithEmailAndPassword(this.email,this.password).then((function(t){console.log("response status",t)}),(function(s){return t.error=s.message}))}},mounted:function(){Object(r["a"])()},created:function(){}},d=p,u=(a("6c57"),a("2877")),m=Object(u["a"])(d,e,n,!1,null,"420459a0",null);s["default"]=m.exports}}]);
//# sourceMappingURL=chunk-58f69671.9b6197dc.js.map