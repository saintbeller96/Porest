(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a1315be6"],{"50b8":function(e,t,a){"use strict";a("7a0f")},5464:function(e,t,a){"use strict";function s(e){var t=/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;return t.test(String(e).toLowerCase())}function n(e){var t=/^[A-Za-z0-9+]{6,12}$/;return t.test(e)}a.d(t,"a",(function(){return s})),a.d(t,"b",(function(){return n}))},"7a0f":function(e,t,a){},9905:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("section",[a("header",[e._v(" Login page ")]),a("form",{on:{submit:function(t){return t.preventDefault(),e.login(t)}}},[a("article",[a("div",[a("p",[e._v("email")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.email,expression:"email"}],attrs:{type:"email",placeholder:"이메일 주소를 입력해주세요."},domProps:{value:e.email},on:{input:function(t){t.target.composing||(e.email=t.target.value)}}}),e.isValidEmail?e._e():a("p",{staticClass:"error_message"},[e._v(" 잘못된 이메일 양식입니다. ")])]),a("div",[a("p",[e._v("비밀번호")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password",placeholder:"6~12자의 영문, 숫자 입력"},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),!e.isValidPwd&&e.password.length<6?a("p",{staticClass:"error_message"},[e._v("6자 이상의 비밀번호를 입력해주세요.")]):!e.isValidPwd&&e.password.length>12?a("p",{staticClass:"error_message"},[e._v(" 12자 이하의 비밀번호를 입력해주세요. ")]):e._e()])]),a("br"),a("button",{attrs:{disabled:!e.checkForm}},[e._v("로그인 하기")])]),a("br"),a("p",{on:{click:e.goToSignup}},[e._v("회원가입 페이지 이동")])])},n=[],i=a("5464"),o=a("260b"),r=(a("ea7b"),{data:function(){return{email:"",nickname:"",password:""}},computed:{isValidEmail:function(){return""===this.email||Object(i["a"])(this.email)},isValidPwd:function(){return""===this.password||Object(i["b"])(this.password)},checkForm:function(){return Object(i["a"])(this.email)&&Object(i["b"])(this.password)}},methods:{goToSignup:function(){this.$router.push({name:"Signup"})},login:function(){var e=this;console.log("login"),o["a"].auth().signInWithEmailAndPassword(this.email,this.password).then((function(){console.log("move to home"),e.$router.push("/main")}),(function(t){return e.error=t.message}))}}}),u=r,l=(a("50b8"),a("2877")),c=Object(l["a"])(u,s,n,!1,null,"b1faec96",null);t["default"]=c.exports}}]);
//# sourceMappingURL=chunk-a1315be6.185aa72e.js.map