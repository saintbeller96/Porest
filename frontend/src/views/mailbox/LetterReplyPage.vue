<template>
  <section>
    <header>
      답장 작성 페이지
    </header>
    <article>
      <div class="reply-container">
        <div class="left">
          사연
          <div class="letter-from-anonymous">
            <p>Dear Friends,</p>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea inventore eum adipisci vero repellat nobis
              praesentium eius! Nobis eligendi iusto neque doloremque aut! Adipisci nihil voluptatum cupiditate esse
              quidem labore! Voluptatibus rem enim eius eaque, consequatur corporis exercitationem aliquid quidem nihil
              cupiditate porro tenetur, ducimus beatae omnis iusto cum facilis?
            </p>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea inventore eum adipisci vero repellat nobis
              praesentium eius! Nobis eligendi iusto neque doloremque aut! Adipisci nihil voluptatum cupiditate esse
              quidem labore! Voluptatibus rem enim eius eaque, consequatur corporis exercitationem aliquid quidem nihil
              cupiditate porro tenetur, ducimus beatae omnis iusto cum facilis?
            </p>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea inventore eum adipisci vero repellat nobis
              praesentium eius! Nobis eligendi iusto neque doloremque aut! Adipisci nihil voluptatum cupiditate esse
              quidem labore! Voluptatibus rem enim eius eaque, consequatur corporis exercitationem aliquid quidem nihil
              cupiditate porro tenetur, ducimus beatae omnis iusto cum facilis?
            </p>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea inventore eum adipisci vero repellat nobis
              praesentium eius! Nobis eligendi iusto neque doloremque aut! Adipisci nihil voluptatum cupiditate esse
              quidem labore! Voluptatibus rem enim eius eaque, consequatur corporis exercitationem aliquid quidem nihil
              cupiditate porro tenetur, ducimus beatae omnis iusto cum facilis?
            </p>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea inventore eum adipisci vero repellat nobis
              praesentium eius! Nobis eligendi iusto neque doloremque aut! Adipisci nihil voluptatum cupiditate esse
              quidem labore! Voluptatibus rem enim eius eaque, consequatur corporis exercitationem aliquid quidem nihil
              cupiditate porro tenetur, ducimus beatae omnis iusto cum facilis?
            </p>
          </div>
        </div>
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
  height: 100vh;
  border: 1px solid;
}

.left {
  width: 50%;
  height: 100%;
  float: left;
  box-sizing: border-box;
  font: 14px sans-serif;
  padding: 20px;
  /* background: linear-gradient(#ccc, #fff); */
}
.right {
  width: 50%;
  height: 100%;
  float: right;
  box-sizing: border-box;
  background: yellow;
}

/* 사연 */
.letter-from-anonymous {
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
  margin: 26px auto 0;
  max-width: 550px;
  min-height: 300px;
  padding: 24px;
  position: relative;
  width: 80%;
}

.letter-from-anonymous:before,
.letter-from-anonymous:after {
  content: '';
  height: 98%;
  position: absolute;
  width: 100%;
  z-index: -1;
}

.letter-from-anonymous:before {
  background-color: #fafafa;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
  left: -5px;
  top: 4px;
  transform: rotate(-2.5deg);
}

.letter-from-anonymous:after {
  background-color: #f6f6f6;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);
  left: -3px;
  top: 1px;
  transform: rotate(1.4deg);
}
</style>
