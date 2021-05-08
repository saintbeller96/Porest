<template>
  <div class="feeling-record-background">
    <div class="calendar-area">
      <calendar @get-target-date="getDate"></calendar>
    </div>
    <div class="dairy-area">
      <dairy :getTargetDate="targetDate"></dairy>
    </div>
  </div>
</template>

<script>
import Calendar from '@/components/feeling-record/Calendar';
import Dairy from '@/components/feeling-record/Dairy';
export default {
  components: {
    Calendar,
    Dairy,
  },
  data() {
    return {
      targetDate: [],
    };
  },
  methods: {
    getDate(date) {
      this.targetDate = date;
    },
  },
};
</script>

<style scoped>
.feeling-record-background {
  height: 100vh;
  width: 100vw;
  display: grid;
  background-image: linear-gradient(135deg, #a8edea 10%, #fed6e3 100%);
  /* 그리드 나누기 */
  grid-template-columns: repeat(6, 1fr);
  box-sizing: border-box;

  /* background-image: url('../../assets/image/407.jpg');
  background-size: cover;
  background-position: center;
  background-attachment: fixed; */
}

.calendar-area {
  grid-column-start: 2;
  grid-column-end: 4;
  align-items: center;
  justify-content: center;
  display: flex;
}

.dairy-area {
  grid-column-start: 4;
  grid-column-end: 6;
  align-items: center;
  justify-content: center;
  display: flex;
}
</style>
