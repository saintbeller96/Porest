<template>
  <section>
    <header>
      답장 작성 페이지
    </header>
    <article>
      <div class="reply-container">
        <div class="left">사연</div>
        <div class="right">답변 작성</div>
      </div>
    </article>
  </section>
</template>

<script>
export default {};
</script>

<style scoped>
.reply-container {
  width: 100%;
  height: 80vh;
  border: 1px solid;
}

.left {
  width: 50%;
  height: 100%;
  float: left;
  box-sizing: border-box;
  background: #8977ad;
}
.right {
  width: 50%;
  height: 100%;
  float: right;
  box-sizing: border-box;
  background: yellow;
}
</style>
