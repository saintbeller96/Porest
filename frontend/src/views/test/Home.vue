<template>
  <div>
    home
    {{ user }}
  </div>
</template>

<script>
import db from '@/db.js';
export default {
  name: 'Home',
  data() {
    return {
      user: null,
    };
  },
  mounted() {
  },
  methods: {},
};
</script>
