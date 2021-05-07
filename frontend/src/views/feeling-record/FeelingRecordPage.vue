<template>
  <div>
    <calendar @get-target-date="getDate"></calendar>
    <br />
    <dairy :getTargetDate="targetDate"></dairy>
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
  props: {},
  methods: {
    getDate(date) {
      this.targetDate = date;
    },
  },
};
</script>

<style scoped></style>
