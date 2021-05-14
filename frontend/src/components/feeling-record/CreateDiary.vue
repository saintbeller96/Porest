<template>
  <diary-edit-form :getTargetDate="getTargetDate">
    <template slot="span" slot-scope="scopeProps">
      <span @click="scopeProps.createDiary">저장하기</span>
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
