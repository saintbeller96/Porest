<template>
  <div class="star-3d"></div>
</template>

<script>
import { star3D } from '@/assets/js/common/star3d.js';
export default {
  name: 'Star3D',
  data() {
    return {};
  },
  mounted() {
    star3D();
  },
  methods: {},
};
</script>

<style scoped src="@/assets/css/common/star3d.css"></style>
