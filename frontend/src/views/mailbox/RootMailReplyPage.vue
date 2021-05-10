<template>
  <div class="root-mail-reply-wrapper">
  <div class="envelope new">
  <div class="front">
    <div class="stamp"></div>
    <div class="mailme">
       <p>한사랑 수목원</p>
    </div>
  </div>
  
  
  <div class="back">
   
    <div class="letter">
    
    <div class="root-mail">
      <p>제목: 학교폭력 힘들어요</p>
      <p>내용: 왈놔러ㅗㄴ아롱너ㅗ랑놔러ㅗㄴㅇ론어ㅏㅗㄹ아너ㅗ라ㅓㅇ놀ㄴㅇ로아ㅗ
      ㅇ롸ㅓ올어로아ㅓ로오라ㅗㅇ러ㅘ오라ㅓ</p>
      <p>2021.05.04</p>
      <div class="btnReply">답장하기</div>
    </div>
     

      
    </div>
    
    <div class="flap left-flap"></div>
    <div class="flap right-flap"></div>
    <div class="flap bottom-flap"></div>
    <div class="flap top-flap"></div>
  </div>
</div>


<div class="envelope open reply">
  <div class="front">
    <div class="stamp"></div>
    <div class="mailme">
      <p>한사랑 수목원</p>
    </div>
  </div>
  
  
  <div>
    
    
  </div>
  
  
  
  <div class="back">
   
    <div class="letter">
    
     
     <div class="root-mail-reply">
       <form class="mailform">
        <div>
          <label for="reply_title">reply_title</label>
          <input type="text" name="reply_title" size="40" placeholder="reply_title">
        </div>
        <div>
          <label for="reply_content">reply_content</label>
          <textarea name="reply_content" cols="40" rows="5" placeholder="reply_content"></textarea>
        </div>
        <div>
          <input class="sendBtn" type="submit" value="Send">
        </div>
      </form>
     </div>
      
    </div>
    
    <div class="flap left-flap"></div>
    <div class="flap right-flap"></div>
    <div class="flap bottom-flap"></div>
    <div class="flap top-flap"></div>
  </div>
</div>

  </div>
</template>

<script>
import { init } from '@/assets/js/mail/RootMailReplyPage.js'
export default {
    name:'RootMailReply',
    mounted(){
        init()
    }
}
</script>

<style scoped src='@/assets/css/mail/RootMailReply.css'>

</style>