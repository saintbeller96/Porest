<template>
    <div class="container">
        <div class="ban-report">
            <report-table :banReports="banReports"></report-table>
            <pagination :totalPages="totalPages" :pageSize="pageSize" v-on:requestNext="getNextBanReports"></pagination>
        </div>
    </div>
</template>

<script>
import { getBanReports } from '@/api/ban-report';
import ReportTable from '../../components/ban/ReportTable.vue';
import Pagination from '../../components/ban/Pagination.vue';
export default{
  components: { ReportTable, Pagination },
    data() {
        return {
            offset: 0,
            pageSize: 20,
            totalPages: 0,
            banReports: [],
        };
  },
  methods: {
      getNextBanReports(offset){
          getBanReports(offset, this.pageSize)
          .then((res)=>{
            this.offset = res.data.pageable.offset;
            this.pageSize = res.data.pageable.pageSize;
            this.banReports = res.data.content;   
          })
      },
  },
  created(){
        getBanReports(0, this.pageSize)
        .then((res)=>{
            this.totalPages = res.data.totalPages;
            this.offset = res.data.pageable.offset;
            this.pageSize = res.data.pageable.pageSize;
            this.banReports = res.data.content;   
        })
  }
}
</script>

<style scoped>
.container {
    width: 100vw;
    height: 100vh; 
    margin: 0;
    padding: 0;
    display:flex;
    justify-content: center;
    align-items:flex-start;
    overflow: scroll;
    box-sizing: border-box;
    background-image: url('../../assets/image/sky.jpg');
    background-repeat: no-repeat;
    background-position: 50% 50%;
    position: relative;
}
.ban-report{
    margin: 10% 4%;
}
</style>