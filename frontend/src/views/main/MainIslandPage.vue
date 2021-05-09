<template>
  
<div class="mainisland">
  <div class="main_wrapper">
    <div class="post_ground_wrapper">
      <div class="post_ground_container">
        <div class="post_island">
          <object :data="post_island" type="image/svg+xml"></object>
          <span class="post_shadow"></span>
        </div>

      </div>
    </div>


    <div class="board_ground_wrapper">
      <div class="board_ground_container">
        <div class="board_island">
          <object :data="board_island" type="image/svg+xml"></object>
          <span class="board_shadow"></span>
        </div>
      </div>
    </div>

   
    <div class="radio_ground_wrapper">
      <div class="radio_ground_container">
        <div class="radio_island">
          <object  :data="radio_island" type="image/svg+xml"></object>
          <span class="radio_shadow"></span>
        </div>
      </div>
    </div>

   
    <div class="video_ground_wrapper">
      <div class="video_ground_container">
        <div class="video_island">
          <object :data="video_island" type="image/svg+xml"></object>
          <span class="video_shadow"></span>
        </div>
      </div>
    </div>

   
    <div class="calender_ground_wrapper">
      <div class="calender_ground_container">
        <div class="calender_island">
          <object :data="calender_island" type="image/svg+xml"></object>
          <span class="calender_shadow"></span>
        </div>

      </div>
    </div>

  </div>


</div>

</template>

<script>
export default {
    data(){
        return {
            post_island: require('../../assets/svg/post.svg'),
            board_island: require('../../assets/svg/board.svg'),
            radio_island:require('../../assets/svg/radio.svg'),
            video_island: require('../../assets/svg/video.svg'),
            calender_island:require('../../assets/svg/calender.svg')

        }
    }
}
</script>

<style scoped src='@/assets/css/main/MainIslandPage.css'>

</style>