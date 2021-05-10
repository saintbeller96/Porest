<template>
  <div>
    <div>
      <div v-if="getTargetDate.length === 0">
        <p>{{ month }}월 {{ today }}일</p>
      </div>
      <div v-else>
        <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일</p>
      </div>
      <p>내용 작성</p>
      <textarea cols="70" rows="10"></textarea>
    </div>
    <div style="margin-bottom: 30px;">
      <select-feelings></select-feelings>
    </div>
  </div>
</template>

<script>
import SelectFeelings from '@/components/feeling-record/SelectFeelings';
export default {
  props: {
    getTargetDate: Array,
  },
  components: {
    SelectFeelings,
  },
  data() {
    return {
      year: 0,
      month: 0,
      today: 0,
      modal: true,
    };
  },
  created() {
    const date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.today = date.getDate();
  },
};
</script>

<style></style>
