<template>
  <diary-edit-form :getTargetDate="getTargetDate">
    <template slot="buttons" slot-scope="scopeProps">
      <button @click="scopeProps.createDiary">저장하기</button>
    </template>
  </diary-edit-form>
</template>

<script>
import DiaryEditForm from '@/components/common/DiaryEditForm';
export default {
  components: {
    DiaryEditForm,
  },
  props: {
    getTargetDate: Array,
  },
};
</script>

<style></style>
