<template>
  <div class="write-letter-wrapper">
 
  
<div class="envelope open">
  <div class="front">
    <div class="stamp"></div>
    <div class="mailme">
      <p>당신의 고민을 담은 편지</p>
      <p>한사랑 수목원이 전해드립니다</p>
    </div>
  </div>
  
  <div class="back">

    <div class="letter">
      <form class="mailform">
        <div>
          <label for="title">title</label>
          <input type="text" name="title" size="40" placeholder="고민의 제목을 적어주세요">
        </div>
        <div>
          <label for="content">content</label>
          <textarea name="content" cols="40" rows="5" placeholder="고민을 남겨주세요"></textarea>
        </div>
        <div>
          <input class="sendBtn" type="submit" value="Send">
        </div>
      </form>
    </div>
    <div class="flap left-flap"></div>
    <div class="flap right-flap"></div>
    <div class="flap bottom-flap"></div>
    <div class="flap top-flap"></div>
  </div>
</div>

<div class="notification">
    <div>
      <div>
        <p>Message sent!</p>
        <p>Write a new message(보류)</p>
      </div>
    </div>
</div>

</div>
</template>

<script>

import { init } from '@/assets/js/mail/WriteLetterPage.js'
export default {
    name:'WriteLetterPage',
    mounted(){
        init()
    }
}
</script>

<style scoped  src='@/assets/css/mail/WriteLetterPage.css'>
</style>
