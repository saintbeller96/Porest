<template>
  <div class="root-mail-reply-wrapper">
  <div class="envelope new">
  <div class="front">
    <div class="stamp"></div>
    <div class="mailme">
      <p>Click and get in touch!</p>
      <p>example@example.com</p>
    </div>
  </div>
  <div class="back">
    <div class="letter">
      <form class="mailform">
        <div>
          <label for="name">Name</label>
          <input type="text" name="name" size="40" placeholder="Name">
        </div>
        <div>
          <label for="emailadress">Email adress</label>
          <input type="text" name="emailadress" size="40" placeholder="Email adress">
        </div>
        <div>
          <label for="message">Message</label>
          <textarea name="message" cols="40" rows="5" placeholder="Message"></textarea>
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
  </div>
</template>

<script>
import { init } from '@/assets/js/mail/RootMailReply.js'
export default {
    name:'RootMailReply',
    mounted(){
        init()
    }
}
</script>

<style scoped src='@/assets/css/mail/RootMailReply.css'>

</style>