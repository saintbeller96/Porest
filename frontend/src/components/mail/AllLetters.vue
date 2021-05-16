<template>
  <div class="all_letters_wrapper">
    <div class="exit_btn" @click="exitAll">떠나기</div>
    <div class="book_wrapper">
      <div class="book">
        <div
          class="page"
          :class="{ active: index == 0 }"
          v-for="(item, index) in pages"
          :key="index"
          :data-value="index"
        >
          <div class="front" :data-value="index">
            <div class="book_cover" v-if="index == 0">
              <div class="root_story_header">이번에도 면접에서 떨어졌어요</div>
              <div class="root_story_content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vitae voluptates perspiciatis est tempore
                magnam libero laboriosam nemo obcaecati aut totam? Consequuntur dolores, commodi omnis eaque in atque
                quibusdam ad reiciendis!
              </div>
            </div>
            <div class="reply" v-else>
              <div class="reply_header">답장한 제목</div>
              <div class="reply_content">답장한 목록</div>
            </div>
          </div>
          <div class="back" :data-value="index">
            <div class="letter_header">답변 받은 제목</div>
            <div class="letter_content">답변 받은 내용</div>
          </div>
        </div>
      </div>
    </div>
    <div class="all_letters_header"></div>
  </div>
</template>

<script>
import { init } from '@/assets/js/mail/AllLetters.js';
export default {
  name: 'Allletters',
  data() {
    return {
      pages: [1, 2, 3, 4, 5, 6, 7, 8],
    };
  },
  mounted() {
    init();
  },
  methods: {
    exitAll() {
      this.$emit('exitAll');
    },
  },
};
</script>

<style scoped>
.all_letters_wrapper {
  width: 100%;
  height: 100%;
  padding: 1rem;
  box-sizing: border-box;
  display: flex;
  align-items: center;
  position: relative;
}

.exit_btn {
  position: absolute;
  top: 1rem;
  right: 1rem;
  color: #fff;
  cursor: pointer;
}
.book_wrapper {
  width: 35%;
  height: 95%;
  border: 1px solid black;
  perspective: 2000px;
  position: relative;
  left: 50%;
}
.book {
  width: 100%;
  height: 100%;
  position: relative;
  transform-style: preserve-3d;
}
::-webkit-scrollbar {
  width: 12px;
  height: 8px;
}
::-webkit-scrollbar-corner {
}
::-webkit-scrollbar-thumb {
  background-color: rgb(177, 174, 174);
  border-radius: 6px;
}
.page {
  width: 100%;
  height: 100%;
  padding: 2rem;
  cursor: pointer;
  position: absolute;
  transform-origin: left center;
  transform-style: preserve-3d;
  transform: perspective(2000px) rotateY(0deg);
  transition: 1s all;
}

.front,
.back {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  padding: 2rem;
  overflow-y: scroll;
  background: linear-gradient(to bottom right, #fff, #ccc);
  backface-visibility: hidden;
  transform: perspective(2000px) rotateY(0);
}
.back {
  transform: rotateY(180deg);
}

.page.active {
  z-index: 1;
}

.page.flipped {
  transform: rotateY(180deg);
}
/* .page.flipped .front {
  transform: rotateY(-180deg);
}
.page.flipped .back {
  transform: rotateY(0deg);
} */
.page.flipped:last-of-type {
  z-index: 1;
}
.reply {
  width: 100%;
}
.root_story_header,
.letter_header,
.reply_header {
  pointer-events: none;
  width: 100%;
  padding: 1rem 0;
  text-align: center;
  font-size: 1.5rem;
  font-weight: 600;
  margin: 2rem 0;
  border: 1px solid;
}

.reply_header {
  height: 7%;
}

.root_story_content,
.reply_content,
.letter_content {
  pointer-events: none;
  font-size: 1.2rem;
  text-align: justify;
  letter-spacing: 1px;
  line-height: 1.5rem;
  padding: 1rem 0;
  width: 100%;
  height: 70%;
}

.book_cover,
.reply {
  pointer-events: none;
}
</style>
