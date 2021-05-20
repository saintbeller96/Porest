<template>
    <div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ totalPages }} 페이지</span>
      <button :disabled="pageNum >= totalPages - 1" @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
</template>

<script>
export default {
    props: ['pageSize', 'totalPages'],
    data(){
        return {
            pageNum: 0
        }
    },
    methods: {
        nextPage(){
            this.pageNum += 1;
            this.requestNext(this.pageNum);
        },
        prevPage(){
            this.pageNum -=1;
            this.requestNext(this.pageNum);
        },
        requestNext(offset){
            this.$emit('requestNext', offset);
        }
    },
}
</script>

<style>
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>